package com.example.demo.model.event;

import com.example.demo.model.notification.Notification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EventGeral {
    EventMetadata eventMetadata;
    Notification notification;
}
