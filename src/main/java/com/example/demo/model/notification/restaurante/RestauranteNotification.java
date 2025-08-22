package com.example.demo.model.notification.restaurante;

import com.example.demo.model.notification.Notification;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestauranteNotification implements Notification {

    private String productType;
    private RestaurantePedido restaurantePedido;
}
