package io.sseservice.api.waitingList.interfaces.handler.ingame;

import io.sseservice.api.waitingList.domain.WaitingListService;
import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.ExitGameMessage;
import io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.event.ExitGameEvent;
import io.sseservice.common.event.GenericEventHandler;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
@Component
public class ExitGameHandler extends GenericEventHandler<ExitGameEvent, WaitingListEvent> {

    private final WaitingListService waitingListService;

    protected ExitGameHandler(WaitingListService waitingListService) {
        this.waitingListService = waitingListService;
    }

    @Override
    public Class<ExitGameEvent> getEventType() {
        return ExitGameEvent.class;
    }

    @Override
    public void handle(WaitingListEvent event) {
        ExitGameMessage message = (ExitGameMessage) event;
        waitingListService.addNameOnWaitingList(message.partyId(), message.userName());
    }
}
