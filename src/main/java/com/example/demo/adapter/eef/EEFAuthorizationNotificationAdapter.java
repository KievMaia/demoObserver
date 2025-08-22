package com.example.demo.adapter.eef;


import com.example.demo.model.notification.CommonNotification;
import com.example.demo.model.notification.eef.PostEEFAuthorizationRequest;

public class EEFAuthorizationNotificationAdapter {

    public static CommonNotification toEEFAuthorizationNotification(PostEEFAuthorizationRequest postEEFAuthorizationRequest) {
        return CommonNotification.builder()
                .payload(postEEFAuthorizationRequest)
                .build();
    }
}
