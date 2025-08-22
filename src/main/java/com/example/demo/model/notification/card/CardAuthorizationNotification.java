package com.example.demo.model.notification.card;

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
public class CardAuthorizationNotification implements Notification {

    private PostCardAuthorizationRequest postAuthorizeCardRequest;
}
