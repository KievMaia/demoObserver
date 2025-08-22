package com.example.demo.cartao.command.common;

import com.example.demo.model.event.OptInEvent;
import com.example.demo.model.event.EventMetadata;
import com.example.demo.model.event.ObserverEventTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public abstract class CommandIGeneric<T extends OptInEvent>
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

  protected OptInEvent buildNextEvent(
          OptInEvent eventSolicitation, ObserverEventTypeEnum newEvent) {
    return OptInEvent.builder()
        .eventMetadata(
            new EventMetadata(newEvent))
        .notification(eventSolicitation.getNotification())
        .build();
  }
}
