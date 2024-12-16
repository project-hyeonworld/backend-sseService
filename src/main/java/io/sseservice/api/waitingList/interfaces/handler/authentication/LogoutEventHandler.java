package io.sseservice.api.waitingList.interfaces.handler.authentication;

import io.sseservice.api.waitingList.domain.WaitingListService;
import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout.LogoutEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout.LogoutMessage;
import io.sseservice.common.event.GenericEventHandler;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 15.
 */
@Component
public class LogoutEventHandler extends GenericEventHandler<LogoutEvent, WaitingListEvent> {

    private final WaitingListService waitingListService;

    public LogoutEventHandler(WaitingListService waitingListService) {
        this.waitingListService = waitingListService;
    }

    @Override
    public Class<LogoutEvent> getEventType() {
        return LogoutEvent.class;
    }

    @Override
    public void handle(WaitingListEvent event) {
        LogoutMessage message = (LogoutMessage) event;
        waitingListService.removeNameFromWaitingList(message.partyId(), message.userName());
    }
}