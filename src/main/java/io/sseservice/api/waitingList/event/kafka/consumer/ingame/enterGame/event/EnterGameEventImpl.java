package io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event;

import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 18.
 */
public class EnterGameEventImpl implements EnterGameEvent, Message {

    private final long userId;
    private final long partyId;
    private final String userName;

    EnterGameEventImpl(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }


    public long userId() {
        return userId;
    }

    public long partyId() {
        return partyId;
    }

    public String userName(){
        return userName;
    }

    @Override
    public Class<EnterGameEvent> getEventClass() {
        return EnterGameEvent.class;
    }
}
