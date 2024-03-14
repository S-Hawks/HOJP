package com.newroztech.dizli.notifiactionmodule.push;


import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class PushNotificationService {
    private final DeviceRegistrationRepository deviceRegistrationRepository;
    private static final Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    public void sendPushNotification(String userId, String topic, String title, String body) throws FirebaseMessagingException {
        DeviceRegistration deviceRegistration = deviceRegistrationRepository.findByUserId(userId);
        if (deviceRegistration.isNotificationEnable()){
            if(topic != null){
                    sendNotificationToTopic(topic, title, body);
            }else{
                String deviceRegistrationToken = deviceRegistrationRepository.findByUserId(userId).getRegistrationToken();
                sendNotificationByToken(deviceRegistrationToken, title, body);
            }
        }else {
            logger.warn("User with ID " + userId + " not found in device registrations or notifications are disabled.");
        }

    }
    public void sendNotificationByToken(String token , String title) throws FirebaseMessagingException {
        Message message = Message.builder().setNotification
                (Notification.builder()
                        .setTitle(title)
                        .build()
                )
                .setAndroidConfig(AndroidConfig.builder()
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .build()
                )
                .setApnsConfig(ApnsConfig.builder()
                                .setAps(Aps.builder()
                                        .setAlert(ApsAlert.builder()
                                                .setTitle(title)
                                                .build()).build()
                                )
                                .build()
                        ).setToken(token).build();

        String status = FirebaseMessaging.getInstance().send(message);
        logger.info("Notification send to: " + token + " \n Notification status: " + status);
    }
    public void sendNotificationByToken(String token, String title, String body) throws FirebaseMessagingException {
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build()
                ).setAndroidConfig(AndroidConfig.builder()
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .build()
                )
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setAlert(ApsAlert.builder()
                                        .setTitle(title)
                                        .build()).build()
                        )
                        .build()
                ).setToken(token).build();

        String status = FirebaseMessaging.getInstance().send(message);
        logger.info("Notification send to: " + token + " \n Notification status: " + status);
    }

    public void sendNotificationToTopic(String topic, String title) throws FirebaseMessagingException{
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .build()
                )
                .setAndroidConfig(AndroidConfig.builder()
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .build()
                )
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setAlert(ApsAlert.builder()
                                        .setTitle(title)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .setTopic(topic)
                .build();

        String status = FirebaseMessaging.getInstance().send(message);
        logger.info("Notification send to: " + topic + " \n Notification status: " + status);
    }
    public void sendNotificationToTopic(String topic, String title, String body) throws FirebaseMessagingException {
        Message message = Message.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build()
                )
                .setAndroidConfig(AndroidConfig.builder()
                        .setPriority(AndroidConfig.Priority.HIGH)
                        .build()
                )
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setAlert(ApsAlert.builder()
                                        .setTitle(title)
                                        .build()
                                )
                                .build()
                        )
                        .build()
                )
                .setTopic(topic)
                .build();

        String status = FirebaseMessaging.getInstance().send(message);
        logger.info("Notification send to: " + topic + " \n Notification status: " + status);
    }

}


