package com.newroztech.dizli.notifiactionmodule.inapp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InAppNotificationRepository extends JpaRepository<InAppNotification, String> {


    Page<InAppNotification> findByUserId(String userId, Pageable pageable);

    Page<InAppNotification> countAllByUserIdAndRead(String userId, Pageable pageable, boolean read);

    InAppNotification findByIdAndUserId(String id, String userId);

    boolean existsByIdAndUserId(String notificationId, String userId);


}
