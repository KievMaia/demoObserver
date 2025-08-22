package com.example.demo.command.common;

import com.example.demo.model.event.DefaultEvent;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.event.ObserverEventTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public abstract class CommandIGeneric<T extends DefaultEvent>
    implements ICommandIGenericGenerator<T> {

  protected final List<ObserverEventTypeEnum> acceptableEventType;

  protected CommandIGeneric(List<ObserverEventTypeEnum> acceptableEventType) {
    this.acceptableEventType = Objects.requireNonNullElseGet(acceptableEventType, ArrayList::new);
  }

  @Override
  public void notify(T solicitation) {
    if (acceptableEventType.contains(solicitation.getEventMetadata().eventType())) {
      this.execute(solicitation);
    }
  }

  protected DefaultEvent buildNextEvent(
          DefaultEvent eventSolicitation, ObserverEventTypeEnum newEvent) {
    return DefaultEvent.builder()
        .eventMetadata(
            new EventMetadata(newEvent))
        .notification(eventSolicitation.getNotification())
        .build();
  }
}
