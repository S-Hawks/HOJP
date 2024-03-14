package com.newroztech.dizli.notifiactionmodule;


import com.google.firebase.messaging.FirebaseMessagingException;
import com.newroztech.dizli.notifiactionmodule.push.PushNotificationService;
import com.newroztech.dizli.notifiactionmodule.email.configurations.EmailService;
import com.newroztech.dizli.notifiactionmodule.enums.NotificationType;
import com.newroztech.dizli.notifiactionmodule.inapp.InAppNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SendNotificationService {
    private final EmailService emailService;
    private final NotificationService notificationService;
    private final PushNotificationService pushNotificationService;
    private final InAppNotificationRepository inAppNotificationRepository;
    private static  final Logger logger = LoggerFactory.getLogger(SendNotificationService.class);

    public void send(String destinationEmail, NotificationType notificationType, Map<String , String> param) {
        if(notificationService.getNotificationByType(notificationType).getEmailTemplate().getActive()){
            String subject = getEmailSubject(notificationType);
            String body = getEmailContent(notificationType, param);
            emailService.sendEmail(destinationEmail, subject, body);
        }
        logger.info("Email Send Successfully");

        if(notificationService.getNotificationByType(notificationType).getPushTemplate().getActive()){
            String getTitle = getPushTitle(notificationType);
            String getMessage = getPushMessage(notificationType);
            String getTopic = getPushTopic(notificationType);
            try {
                pushNotificationService.sendPushNotification(destinationEmail,getTopic, getTitle, getMessage);
            } catch (FirebaseMessagingException e) {
                throw new RuntimeException(e) ;
            }
        }

    }
    public void send(String destinationEmail, NotificationType notificationType){
        if(notificationService.getNotificationByType(notificationType).getEmailTemplate().getActive()){
            String subject = getEmailSubject(notificationType);
            String body = getEmailContent(notificationType);
            emailService.sendEmail(destinationEmail, subject, body);
        }
        if(notificationService.getNotificationByType(notificationType).getPushTemplate().getActive()){
            String getTitle = getPushTitle(notificationType);
            String getMessage = getPushMessage(notificationType);
            String getTopic = getPushTopic(notificationType);
            try {
                pushNotificationService.sendPushNotification(destinationEmail,getTopic, getTitle, getMessage);
            } catch (FirebaseMessagingException e) {
                throw new RuntimeException(e) ;
            }
        }
    }

    private String getEmailSubject(NotificationType notificationType){
        return notificationService.getNotificationByType(notificationType).getEmailTemplate().getSubject();
    }

    //Fetch Email body by notification with dynamic parameter.
    private String getEmailContent(NotificationType notificationType, Map<String, String> param){
        String body = notificationService.getNotificationByType(notificationType).getEmailTemplate().getContent();
        for(Map.Entry<String, String> entry: param.entrySet()){
            String key = "[" + entry.getKey() + "]";
            String value = entry.getValue();
            body = body.replace("(?i)" + key, value);
        }
        return body;
    }
    private String getEmailContent(NotificationType notificationType){
        return notificationService.getNotificationByType(notificationType).getEmailTemplate().getContent();

    }

    private String getPushTitle(NotificationType notificationType){
       return notificationService.getNotificationByType(notificationType).getPushTemplate().getTitle();
    }
    private String getPushMessage(NotificationType notificationType){
        return notificationService.getNotificationByType(notificationType).getPushTemplate().getMessage();
    }

    private String getPushTopic(NotificationType notificationType){
        String pushTopic = notificationService.getNotificationByType(notificationType).getPushTemplate().getTopic();
        return pushTopic != null ? pushTopic : null;
    }



}
