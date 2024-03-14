package com.newroztech.dizli.notifiactionmodule.push;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRegistrationRepository extends JpaRepository<DeviceRegistration, UUID> {
    long countAllByUserId(String userId);
    void deleteAllByUserId(String userId);
    DeviceRegistration findByUserId(String userId);

}
