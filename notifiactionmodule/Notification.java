package com.newroztech.dizli.notifiactionmodule;

import com.newroztech.dizli.notifiactionmodule.email.EmailTemplate;
import com.newroztech.dizli.notifiactionmodule.push.PushTemplate;
import com.newroztech.dizli.notifiactionmodule.enums.NotificationType;
import com.newroztech.dizli.notifiactionmodule.inapp.InAppTemplate;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true,nullable = false)
    @Enumerated(value = EnumType.STRING)
    private NotificationType notificationType;

    @OneToOne(cascade = CascadeType.ALL)
    private EmailTemplate emailTemplate;

    @OneToOne(cascade = CascadeType.ALL)
    private InAppTemplate inAppTemplate;

    @OneToOne(cascade = CascadeType.ALL)
    private PushTemplate pushTemplate;

}
