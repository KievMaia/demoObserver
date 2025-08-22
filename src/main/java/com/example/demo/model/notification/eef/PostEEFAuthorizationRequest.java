package com.example.demo.model.notification.eef;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostEEFAuthorizationRequest {
    String authorization;
}
