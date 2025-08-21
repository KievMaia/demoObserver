package com.example.demo.model.event;

import lombok.Builder;

@Builder
public record EventMetadata(ObserverEventTypeEnum eventType) {}