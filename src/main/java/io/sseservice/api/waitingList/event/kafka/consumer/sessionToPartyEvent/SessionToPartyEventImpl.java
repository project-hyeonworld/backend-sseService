package io.sseservice.api.waitingList.event.kafka.consumer.sessionToPartyEvent;

import io.sseservice.api.waitingList.event.WaitingListEventBase;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
public class SessionToPartyEventImpl extends WaitingListEventBase implements SessionToPartyEvent {

    private long partyId;

    private SessionToPartyEventImpl(long userId, long partyId) {
        super(userId);
        this.partyId = partyId;
    }

    public static SessionToPartyEventImpl from(long userId, long partyId) {
        return new SessionToPartyEventImpl(userId, partyId);
    }

    public long partyId() {
        return partyId;
    }
}