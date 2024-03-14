package com.newroztech.dizli.notifiactionmodule.utils;

public class NotificationUtils {
    public static final String DEVICE_REGISTRATION_URI = "/api/v1/private/notification/device-registration";
    public static final String SUBSCRIBE_TO_TOPIC = "/api/v1/private/notification/subscribe-topic";

    public static final String UNSUBSCRIBE_TO_TOPIC = "/api/v1/private/notification/unsubscribe-topic";

    public static final String TOGGLE_NOTIFICATION = "/api/v1/private/notification/toggle-notification";

//    ADMIN ENDPOINTS
    public static final String SET_NOTIFICATION = "/api/v1/private/admin/create-email";
    public static final String UPDATE_NOTIFICATION = "/api/v1/private/admin/update-email/{id}";
    public static final String DELETE_NOTIFICATION = "/api/v1/private/admin/delete-email/{id}";

//    IN APP NOTIFICATION
    public static final String GET_ALL_NOTIFICATIONS = "/api/v1/private/notification/in-app";
    public static  final String GET_ALL_UNREAD_NOTIFICATIONS = "/api/v1/private/notification/in-app/count-all";

    public static  final String MARK_NOTIFICATION_AS_READ = "/api/v1/private/notification/{notificationId}/in-app/mark-as-read";

}
