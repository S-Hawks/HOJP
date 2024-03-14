package com.newroztech.dizli.notifiactionmodule;

import com.newroztech.dizli.notifiactionmodule.enums.NotificationType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
    Notification findNotificationByNotificationType(NotificationType notificationType);

    @EntityGraph(attributePaths = {"emailTemplate", "pushTemplate", "inAppTemplate"})
    Optional<Notification> findById(String id);
}
