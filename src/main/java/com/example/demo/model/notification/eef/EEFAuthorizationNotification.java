package com.example.demo.model.notification.eef;

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
public class EEFAuthorizationNotification implements Notification {

    private PostEEFAuthorizationRequest postEEFAuthorizationRequest;
}
