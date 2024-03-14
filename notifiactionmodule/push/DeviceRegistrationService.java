package com.newroztech.dizli.notifiactionmodule.push;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.TopicManagementResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DeviceRegistrationService {
    private final DeviceRegistrationRepository deviceRegistrationRepository;

    @Transactional
    public boolean registerDevice(String userId, DeviceRegistration deviceRegistration) {
        if (deviceRegistrationRepository.countAllByUserId(userId) > 0)
            deviceRegistrationRepository.deleteAllByUserId(userId);

        var device = new DeviceRegistration();
        device.setUserId(userId)
                .setRegistrationToken(deviceRegistration.getRegistrationToken())
                .setDeviceType(deviceRegistration.getDeviceType());

        //TODO: Topic should subscribe during registration.

        deviceRegistrationRepository.save(device);

        return true;
    }

    public void subscribeToTopic(String userId, String topic)  {
        DeviceRegistration deviceRegistration = deviceRegistrationRepository.findByUserId(userId);
        if (deviceRegistration != null) {
            try {
                TopicManagementResponse response = FirebaseMessaging.getInstance()
                        .subscribeToTopic(List.of(deviceRegistration.getRegistrationToken()),topic);
                System.out.println(response.getSuccessCount() + " tokens were subscribed successfully.");
            } catch (FirebaseMessagingException e) {
                System.out.println("Fail with error code: " + e.getErrorCode());
                System.out.println(e.getMessage());
            }
        }

    }
    public void unsubscribeToTopic(String userId, String topic) {
        DeviceRegistration deviceRegistration = deviceRegistrationRepository.findByUserId(userId);
        if (deviceRegistration != null) {
            try {
                TopicManagementResponse response = FirebaseMessaging.getInstance()
                        .unsubscribeFromTopic(List.of(deviceRegistration.getRegistrationToken()), topic);
                System.out.println(response.getSuccessCount() + " tokens were unsubscribed successfully");
            }catch (FirebaseMessagingException e){
                System.out.println("Fail with error code: " + e.getErrorCode());
                System.out.println(e.getMessage());
            }
        }
    }

    public void toggleNotification(String userId, boolean notification) {
        DeviceRegistration deviceRegistration = deviceRegistrationRepository.findByUserId(userId);
        if(deviceRegistration != null){
            deviceRegistration.setNotificationEnable(notification);
            deviceRegistrationRepository.save(deviceRegistration);
        }
    }
}
