package io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.event;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.IngameEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
public interface ExitGameEvent extends IngameEvent {

    static ExitGameEvent from(long userId, long partyId, String userName) {
        return new ExitGameEventImpl(userId, partyId, userName);
    }

}
