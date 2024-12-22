package io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event.EnterGameEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 23.
 */
public record EnterGameMessage (
        long partyId,
        String userName
) implements EnterGameEvent, Message {

    @Override
    public Class<EnterGameEvent> getEventClass() {
        return EnterGameEvent.class;
    }

    public static EnterGameMessage from(long partyId, String userName) {
        return new EnterGameMessage(partyId, userName);
    }
}