package com.newroztech.dizli.notifiactionmodule.inapp;


import com.newroztech.dizli.notifiactionmodule.ApiResponse;
import com.newroztech.dizli.notifiactionmodule.inapp.validators.NotificationShouldBelongToThisUser;
import com.newroztech.dizli.notifiactionmodule.utils.NotificationUtils;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InAppNotificationController {
    private final InAppNotificationService inAppNotificationService;

    @GetMapping(value = NotificationUtils.GET_ALL_NOTIFICATIONS, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<InAppNotification> fetchRecentNotification(@AuthenticationPrincipal Jwt jwt, @PathVariable @NotEmpty String userId){
        Pageable pageable = PageRequest.of(0, 50, Sort.by("createdAt").descending());
        return inAppNotificationService.fetchRecentNotificationByUserId(jwt.getSubject(), pageable);
    }

    @GetMapping(value = NotificationUtils.GET_ALL_UNREAD_NOTIFICATIONS, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<InAppNotification> fetchTotalUnreadNotification(
            @AuthenticationPrincipal Jwt jwt
    ){
        Pageable pageable = PageRequest.of(0, 50, Sort.by("CreatedAt").descending());
        return inAppNotificationService.fetchTotalUnreadNotification(jwt.getSubject(), pageable);
    }
    @PostMapping(value = NotificationUtils.MARK_NOTIFICATION_AS_READ, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> markNotificationAsReadByUserIdAndNotificationId(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable @NotEmpty @NotificationShouldBelongToThisUser String notificationId
    ){
        inAppNotificationService.markNotificationAsReadByUserIdAndNotificationId(jwt.getSubject(), notificationId);
        return new ResponseEntity<>(
                new ApiResponse(200, "Notification has been marked as read"), HttpStatus.OK
        );
    }
}
