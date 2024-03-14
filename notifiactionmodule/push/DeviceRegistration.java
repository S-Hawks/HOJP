package com.newroztech.dizli.notifiactionmodule.push;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(indexes = {@Index(columnList = "userId")})
public class DeviceRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userId;

    private String registrationToken;

    private String deviceType;

    @CreationTimestamp
    private Date createdAt;

    private boolean notificationEnable = true;

}