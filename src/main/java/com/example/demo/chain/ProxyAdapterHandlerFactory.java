package com.example.demo.chain;

import com.example.demo.chain.steps.card.CardValidationStep;
import com.example.demo.chain.steps.commonsteps.PersistenceStep;
import com.example.demo.chain.steps.eef.EEFValidationStep;
import com.example.demo.model.event.DefaultEvent;
import com.example.demo.model.notification.CommonNotification;
import com.example.demo.observable.GenericSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_CSU_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SAP_PROCESSING;
import static com.example.demo.model.event.ObserverEventTypeEnum.EVENT_TYPE_SEND_DATALAKE;

@Service
@RequiredArgsConstructor
public class ProxyAdapterHandlerFactory {

    private final GenericSubject<DefaultEvent> genericSubject;

    private final CardValidationStep cardValidationStep;
    private final EEFValidationStep eefValidationStep;

    public IElementChainable<CommonNotification> buildChainForCard() {
        var persistenceStep = new PersistenceStep(
                genericSubject,
                notification -> List.of(
                        EVENT_TYPE_SAP_PROCESSING,
                        EVENT_TYPE_CSU_PROCESSING,
                        EVENT_TYPE_SEND_DATALAKE
                )
        );

        return IElementChainable.buildChain(
                List.of(cardValidationStep,
                        persistenceStep),
                new NoHandleStep<>()
        );
    }

    public IElementChainable<CommonNotification> buildChainForEEF() {
        var persistenceStep = new PersistenceStep(
                genericSubject,
                notification -> List.of(
                        EVENT_TYPE_CSU_PROCESSING
                )
        );

        return IElementChainable.buildChain(
                List.of(persistenceStep,
                        eefValidationStep),
                new NoHandleStep<>()
        );
    }
}