package com.example.demo.adapter.cartao;

import com.example.demo.model.notification.CommonNotification;
import com.example.demo.model.notification.card.PostCardAuthorizationRequest;

public class CardAuthorizationNotificationAdapter {

    public static CommonNotification toCardAuthorizationNotification(PostCardAuthorizationRequest postCardAuthorizationRequest) {
        return CommonNotification.builder()
                .payload(postCardAuthorizationRequest)
                .build();
    }
}
