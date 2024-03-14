package com.newroztech.dizli.notifiactionmodule;

import com.newroztech.dizli.notifiactionmodule.utils.NotificationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NotificationController {
    public final NotificationService notificationService;

    @PostMapping(value = NotificationUtils.SET_NOTIFICATION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> setNotification(@RequestBody Notification notification){
        return new ResponseEntity<>(
                new ApiResponse(200 ,
                        "Notification Save Successfully",
                        notificationService.saveNotification(notification)
                        ), HttpStatus.OK
        );
    }
    @PutMapping(value = NotificationUtils.UPDATE_NOTIFICATION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> updateNotification(@PathVariable String id, @RequestBody Notification notification){
        return new ResponseEntity<>(
                new ApiResponse(200,
                        "Notification Update Successfully",
                        notificationService.updateNotification(id, notification)
                        ), HttpStatus.OK
        );
    }
}
