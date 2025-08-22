package com.example.demo.controller;

import com.example.demo.model.notification.cartao.CardOptIn;
import com.example.demo.cartao.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.cartao.adapter.CardOptInNotificationAdapter.toCardOptInNotification;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping(
            value = "/demo",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CardOptIn> createDispatcher(@RequestBody CardOptIn authorization){
        authorizationService.process(toCardOptInNotification(authorization));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
