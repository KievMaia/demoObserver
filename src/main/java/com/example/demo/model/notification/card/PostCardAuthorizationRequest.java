package com.example.demo.model.notification.card;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostCardAuthorizationRequest {
    String authorization;
}
