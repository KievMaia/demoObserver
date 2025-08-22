package com.example.demo.controller;

import com.example.demo.chain.ProxyAdapterHandlerFactory;
import com.example.demo.model.notification.card.PostCardAuthorizationRequest;
import com.example.demo.service.CardAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.adapter.cartao.CardAuthorizationNotificationAdapter.toCardAuthorizationNotification;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CardAuthorizationController {

    private final ProxyAdapterHandlerFactory handlerFactory;

    private final CardAuthorizationService service;

    @PostMapping(
            value = "/demo-card",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PostCardAuthorizationRequest> authorize(@RequestBody PostCardAuthorizationRequest request) {
        handlerFactory.buildChainForCard().handle(toCardAuthorizationNotification(request));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
