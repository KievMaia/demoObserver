package com.example.demo.cartao.adapter;

import com.example.demo.model.notification.cartao.CardOptIn;
import com.example.demo.model.notification.cartao.CardOptInNotification;

public class CardOptInNotificationAdapter {

    public static CardOptInNotification toCardOptInNotification(CardOptIn cardOptin) {
        return CardOptInNotification.builder()
                .cardOptin(cardOptin)
                .build();
    }
}
