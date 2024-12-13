package io.sseservice.api.waitingList.interfaces.handler.authentication;

import io.sseservice.api.waitingList.domain.WaitingListService;
import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.authentication.login.LoginEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.authentication.login.LoginMessage;
import io.sseservice.common.event.GenericEventHandler;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
@Component
public class LoginEventHandler extends GenericEventHandler<LoginEvent, WaitingListEvent> {

    private final WaitingListService waitingListService;

    public LoginEventHandler(WaitingListService waitingListService) {
        this.waitingListService = waitingListService;
    }

    @Override
    public Class<LoginEvent> getEventType() {
        return LoginEvent.class;
    }

    @Override
    public void handle(WaitingListEvent event) {
        LoginMessage message = (LoginMessage) event;
        waitingListService.addNameOnWaitingList(message.partyId(), message.userName());
    }
}
