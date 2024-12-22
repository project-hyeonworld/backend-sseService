package io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.IngameEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 22.
 */
public interface EnterGameEvent<T extends Message> extends IngameEvent {

    static EnterGameEvent<?> from(long userId, long partyId, String userName) {
        return new EnterGameEventImpl(userId, partyId, userName);
    }

}
