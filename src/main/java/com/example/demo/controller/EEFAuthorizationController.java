package com.example.demo.controller;

import com.example.demo.chain.ProxyAdapterHandlerFactory;
import com.example.demo.model.notification.eef.PostEEFAuthorizationRequest;
import com.example.demo.service.EEFAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.adapter.eef.EEFAuthorizationNotificationAdapter.toEEFAuthorizationNotification;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EEFAuthorizationController {

    private final ProxyAdapterHandlerFactory handlerFactory;
    private final EEFAuthorizationService service;

    @PostMapping(
            value = "/demo-eef",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PostEEFAuthorizationRequest> authorize(@RequestBody PostEEFAuthorizationRequest request) {
        handlerFactory.buildChainForEEF().handle(toEEFAuthorizationNotification(request));
        return ResponseEntity.ok().build();
    }
}
