package io.sseservice.api.waitingList.event.kafka.consumer.sessionEvent;

import io.sseservice.api.waitingList.event.WaitingListEventBase;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
public class SessionEventImpl extends WaitingListEventBase implements SessionEvent {

    public int sessionType;

    public SessionEventImpl(long userId, int sessionType) {
        super(userId);
        this.sessionType = sessionType;
    }

    public static SessionEventImpl from(long userId, int sessionType) {
        return new SessionEventImpl(userId, sessionType);
    }

    public int sessionType() {
        return sessionType;
    }
}
