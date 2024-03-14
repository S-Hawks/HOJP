package com.newroztech.dizli.notifiactionmodule;

import com.newroztech.dizli.notifiactionmodule.email.EmailTemplate;
import com.newroztech.dizli.notifiactionmodule.push.PushTemplate;
import com.newroztech.dizli.notifiactionmodule.email.configurations.HtmlSanitizerService;
import com.newroztech.dizli.notifiactionmodule.enums.NotificationType;
import com.newroztech.dizli.notifiactionmodule.exceptions.EmailOperationException;
import com.newroztech.dizli.notifiactionmodule.inapp.InAppTemplate;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final HtmlSanitizerService htmlSanitizerService;
    private final EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Transactional
    public Notification saveNotification(Notification notification) {
        try{
            Notification existNotification = notificationRepository.findNotificationByNotificationType(notification.getNotificationType());
            if(existNotification != null){
                notificationRepository.delete(existNotification);
                entityManager.flush();
                entityManager.clear();
            }

            EmailTemplate emailTemplate = sanitizeEmailTemplate(notification.getEmailTemplate());
            Notification newNotification = createNotification(notification);
            newNotification.setEmailTemplate(emailTemplate);

            notificationRepository.save(newNotification);
            return newNotification;

        }catch (DataIntegrityViolationException e){
            throw new EmailOperationException("Notification content could nto be saved: " + e.getMessage(), e.getCause());
        }

    }
    private Notification createNotification(Notification source){
        Notification notification = new Notification();
        notification.setNotificationType(source.getNotificationType());
        notification.setPushTemplate(source.getPushTemplate());
        notification.setInAppTemplate(source.getInAppTemplate());
        return notification;
    }

    private EmailTemplate sanitizeEmailTemplate(EmailTemplate source){
        EmailTemplate sanitizeEmailTemplate = new EmailTemplate();
        sanitizeEmailTemplate.setActive(source.getActive());
        sanitizeEmailTemplate.setSubject(source.getSubject());
        String sanitizeHtml= htmlSanitizerService.sanitizerHtml(source.getContent());
        sanitizeEmailTemplate.setContent(sanitizeHtml);
        return sanitizeEmailTemplate;
    }


    @Transactional
    public Notification updateNotification(String id, Notification notification){
        return notificationRepository.findById(id)
                .map(existingNotification -> {

                    updateEmailTemplate(existingNotification.getEmailTemplate(), notification.getEmailTemplate());
                    updateInAppTemplate(existingNotification.getInAppTemplate(), notification.getInAppTemplate());
                    updatePushTemplate(existingNotification.getPushTemplate(), notification.getPushTemplate());

                    return notificationRepository.save(existingNotification);

                }).orElseThrow(() -> new EmailOperationException("Notification not found: " + id));
    }

    private void updateEmailTemplate(EmailTemplate existEmailTemplate, EmailTemplate updateEmailTemplate){
        if(existEmailTemplate != null && updateEmailTemplate != null){
            existEmailTemplate.setSubject(updateEmailTemplate.getSubject());
            existEmailTemplate.setContent(updateEmailTemplate.getContent());
            existEmailTemplate.setActive(updateEmailTemplate.getActive());
        }
    }
    private void updateInAppTemplate(InAppTemplate existInAppTemplate, InAppTemplate updateInAppTemplate){
        if(existInAppTemplate != null && updateInAppTemplate != null){
            existInAppTemplate.setTitle(updateInAppTemplate.getTitle());
            existInAppTemplate.setMessage(updateInAppTemplate.getMessage());
            existInAppTemplate.setActive(updateInAppTemplate.getActive());
            existInAppTemplate.setIcon(updateInAppTemplate.getIcon());
        }
    }
    private void updatePushTemplate(PushTemplate existPushTemplate, PushTemplate updatePushTemplate){
        if(existPushTemplate != null && updatePushTemplate != null){
            existPushTemplate.setTitle(updatePushTemplate.getTitle());
            existPushTemplate.setMessage(updatePushTemplate.getMessage());
            existPushTemplate.setTopic(updatePushTemplate.getTopic());
            existPushTemplate.setActive(updatePushTemplate.getActive());
        }
    }

    public Notification getNotificationByType(NotificationType notificationType){
        Notification notification = notificationRepository.findNotificationByNotificationType(notificationType);
        return notification != null ? notification : null;
    }
}
