package com.example.demo.adapter.cartao;

import com.example.demo.model.notification.cartao.PostCardAuthorizationRequest;
import com.example.demo.model.notification.cartao.CardAuthorizationNotification;

public class CardAuthorizationNotificationAdapter {

    public static CardAuthorizationNotification toCardAuthorizationNotification(PostCardAuthorizationRequest postCardAuthorizationRequest) {
        return CardAuthorizationNotification.builder()
                .postAuthorizeCardRequest(postCardAuthorizationRequest)
                .build();
    }
}
