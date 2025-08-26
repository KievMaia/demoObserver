package com.example.demo.chain.steps.card;

import com.example.demo.chain.AbstractStep;
import com.example.demo.model.notification.CommonNotification;
import com.example.demo.model.notification.card.CardAuthorizationNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class CardValidationStep extends AbstractStep<CommonNotification> {
    @Override
    protected Optional<CommonNotification> handleAndApplyNext(CommonNotification event) throws Exception {
        log.info("Efetua as validações cartão");

        var cardAuthorizationNotification = (CardAuthorizationNotification) event.getPayload();

        if("optout".equals(cardAuthorizationNotification.getPostAuthorizeCardRequest().getAuthorization())) {
            log.info("Encerra o fluxo do chain no CardValidationStep");
            return Optional.empty();
        }

        return Optional.of(event);
    }

    @Override
    protected void handleException(Exception e, CommonNotification event) {

    }
}

