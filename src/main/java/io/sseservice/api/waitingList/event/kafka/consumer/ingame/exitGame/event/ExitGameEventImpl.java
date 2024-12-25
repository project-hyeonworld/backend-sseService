package io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.event;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event.EnterGameEvent;
import io.sseservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
public class ExitGameEventImpl implements ExitGameEvent {

    private final long userId;
    private final long partyId;
    private final String userName;

    public ExitGameEventImpl(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return EnterGameEvent.class;
    }
}
