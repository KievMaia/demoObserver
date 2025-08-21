package com.example.demo.model.notification.pedido;

import com.example.demo.model.Pedido;
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
public class PedidoNotification implements Notification {

    private String productType;
    private Pedido pedido;

    @Override
    public String getProductType() {
        return "";
    }
}
