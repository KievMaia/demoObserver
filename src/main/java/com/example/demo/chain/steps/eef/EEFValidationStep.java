package com.example.demo.chain.steps.eef;

import com.example.demo.chain.AbstractStep;
import com.example.demo.model.notification.CommonNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class EEFValidationStep extends AbstractStep<CommonNotification> {
    @Override
    protected Optional<CommonNotification> handleAndApplyNext(CommonNotification event) throws Exception {
        log.info("Efetua as validações eef");
        return Optional.empty();
    }

    @Override
    protected void handleException(Exception e, CommonNotification event) {

    }
}
