package com.example.demo.observable;

import com.example.demo.model.event.EventGeral;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("genericSubjectGenerator") public class GenericSubjectGenerator extends GenericSubject<EventGeral> {}
