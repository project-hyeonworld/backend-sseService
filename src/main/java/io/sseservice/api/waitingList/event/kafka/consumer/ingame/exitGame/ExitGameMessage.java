package io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.event.ExitGameEvent;
import io.sseservice.common.event.CustomEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
public record ExitGameMessage (
    long partyId,
    String userName
)implements ExitGameEvent, Message {

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return ExitGameEvent.class;
    }

    public static ExitGameMessage from(long partyId, String userName) {
        return new ExitGameMessage(partyId, userName);
    }
}
