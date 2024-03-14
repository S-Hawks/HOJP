package com.newroztech.dizli.notifiactionmodule.inapp;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InAppNotificationService {
    private final InAppNotificationRepository inAppNotificationRepository;

    public Page<InAppNotification> fetchRecentNotificationByUserId(String userId, Pageable pageable) {
        return inAppNotificationRepository.findByUserId(userId, pageable);
    }

    public Page<InAppNotification> fetchTotalUnreadNotification(String userId, Pageable pageable) {
        return inAppNotificationRepository.countAllByUserIdAndRead(userId, pageable, false);
    }

    public void markNotificationAsReadByUserIdAndNotificationId(String userId, String notificationId) {
        InAppNotification inAppNotification = inAppNotificationRepository.findByIdAndUserId(notificationId, userId);
        inAppNotification.setRead(true);
        inAppNotificationRepository.save(inAppNotification);
    }
}
