package com.newroztech.dizli.notifiactionmodule.push;

import com.newroztech.dizli.notifiactionmodule.ApiResponse;
import com.newroztech.dizli.notifiactionmodule.utils.NotificationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
public class DeviceRegistrationController {

    private final DeviceRegistrationService deviceRegistrationService;
    @PostMapping(value = NotificationUtils.DEVICE_REGISTRATION_URI, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> registerDevice(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody DeviceRegistration deviceRegistration){
         deviceRegistrationService.registerDevice(jwt.getClaimAsString("email"), deviceRegistration);
         return new ResponseEntity<>(new ApiResponse(200, "success"), HttpStatus.OK);
    }

    @PostMapping(value = NotificationUtils.SUBSCRIBE_TO_TOPIC, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> subscribeToTopic(@RequestBody String userId, String topic)
    {
        deviceRegistrationService.subscribeToTopic(userId, topic);
        return new ResponseEntity<>(new ApiResponse(200, "Success"), HttpStatus.OK);
    }

    @PostMapping(value = NotificationUtils.UNSUBSCRIBE_TO_TOPIC, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> unsubscribeToTopic(@RequestBody String userId,String topic) {
        deviceRegistrationService.unsubscribeToTopic(userId , topic);
        return new ResponseEntity<>(new ApiResponse(200, "Success"), HttpStatus.OK);
    }

    @PostMapping(value = NotificationUtils.TOGGLE_NOTIFICATION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> toggleNotification(@AuthenticationPrincipal Jwt jwt, @PathVariable boolean notification) {
        deviceRegistrationService.toggleNotification(jwt.getClaimAsString("email"), notification);
        return new ResponseEntity<>(new ApiResponse(200, "Success"), HttpStatus.OK);
    }
}
