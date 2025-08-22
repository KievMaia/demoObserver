package com.example.demo.chain;

import com.example.demo.chain.steps.card.CardValidationStep;
import com.example.demo.chain.steps.commonsteps.PersistenceStep;
import com.example.demo.chain.steps.eef.EEFValidationStep;
import com.example.demo.model.notification.CommonNotification;
import com.example.demo.model.notification.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProxyAdapterHandlerFactory {

    private final List<IElementChainable<? extends Notification>> allSteps;

    public IElementChainable<CommonNotification> buildChainForCard() {
        return IElementChainable.buildChain(
                List.of(
                        getStep(CardValidationStep.class),
                        getStep(PersistenceStep.class)
                ),
                new NoHandleStep<>()
        );
    }

    public IElementChainable<CommonNotification> buildChainForEEF() {
        return IElementChainable.buildChain(
                List.of(
                        getStep(PersistenceStep.class),
                        getStep(EEFValidationStep.class)
                ),
                new NoHandleStep<>()
        );
    }

    @SuppressWarnings("unchecked")
    private <T extends Notification> IElementChainable<T> getStep(Class<? extends IElementChainable<T>> clazz) {
        return (IElementChainable<T>) allSteps.stream()
                .filter(clazz::isInstance)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Step not found: " + clazz));
    }
}