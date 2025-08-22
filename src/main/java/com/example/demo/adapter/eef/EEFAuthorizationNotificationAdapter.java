package com.example.demo.adapter.eef;


import com.example.demo.model.notification.eef.EEFAuthorizationNotification;
import com.example.demo.model.notification.eef.PostEEFAuthorizationRequest;

public class EEFAuthorizationNotificationAdapter {

    public static EEFAuthorizationNotification toEEFAuthorizationNotification(PostEEFAuthorizationRequest postEEFAuthorizationRequest) {
        return EEFAuthorizationNotification.builder()
                .postEEFAuthorizationRequest(postEEFAuthorizationRequest)
                .build();
    }
}
