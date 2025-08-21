package com.example.demo.restaurante.adapter;

import com.example.demo.model.notification.restaurante.RestaurantePedido;
import com.example.demo.model.notification.restaurante.RestauranteNotification;

public class PedidoNotificationAdapter {

    public static RestauranteNotification toPedidoNotification(RestaurantePedido restaurantePedido) {
        return RestauranteNotification.builder()
                .restaurantePedido(restaurantePedido)
                .build();
    }
}
