package io.sseservice.api.waitingList.interfaces.handler.ingame;

import io.sseservice.api.waitingList.domain.WaitingListService;
import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.EnterGameMessage;
import io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event.EnterGameEvent;
import io.sseservice.common.event.GenericEventHandler;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 23.
 */
@Component
public class EnterGameHandler extends GenericEventHandler<EnterGameEvent, WaitingListEvent> {

    private final WaitingListService waitingListService;

    protected EnterGameHandler(WaitingListService waitingListService) {
        this.waitingListService = waitingListService;
    }


    @Override
    public Class<EnterGameEvent> getEventType() {
        return EnterGameEvent.class;
    }

    @Override
    public void handle(WaitingListEvent event) {
        EnterGameMessage message = (EnterGameMessage) event;
        waitingListService.addNameOnWaitingList(message.partyId(), message.userName());
    }
}
