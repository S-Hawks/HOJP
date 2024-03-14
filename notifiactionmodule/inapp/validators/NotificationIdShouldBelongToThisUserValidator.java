package com.newroztech.dizli.notifiactionmodule.inapp.validators;

import com.newroztech.dizli.notifiactionmodule.inapp.InAppNotificationRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

@RequiredArgsConstructor
public class NotificationIdShouldBelongToThisUserValidator implements ConstraintValidator<NotificationShouldBelongToThisUser, String> {
    private final InAppNotificationRepository inAppNotificationRepository;

    @Override
    public void initialize(NotificationShouldBelongToThisUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String notificationId, ConstraintValidatorContext context) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            System.out.println(jwt.getSubject());
            return inAppNotificationRepository.existsByIdAndUserId(notificationId, jwt.getSubject());
        }
        return false;
    }
}
