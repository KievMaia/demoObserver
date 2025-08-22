package com.example.demo.chain.steps.card;

import com.example.demo.chain.AbstractStep;
import com.example.demo.model.notification.CommonNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class CardValidationStep extends AbstractStep<CommonNotification> {
    @Override
    protected Optional<CommonNotification> handleAndApplyNext(CommonNotification event) throws Exception {
        log.info("Efetua as validações cartão");
        return Optional.of(event);
    }

    @Override
    protected void handleException(Exception e, CommonNotification event) {

    }
}

