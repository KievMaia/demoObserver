package com.example.demo.controller;

import com.example.demo.model.notification.restaurante.RestaurantePedido;
import com.example.demo.restaurante.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.restaurante.adapter.PedidoNotificationAdapter.toPedidoNotification;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping(
            value = "/demo",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RestaurantePedido> createDispatcher(@RequestBody RestaurantePedido restaurantePedido){
        pedidoService.gerarPedido(toPedidoNotification(restaurantePedido));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
