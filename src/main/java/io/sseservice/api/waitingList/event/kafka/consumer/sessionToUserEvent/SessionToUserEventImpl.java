package io.sseservice.api.waitingList.event.kafka.consumer.sessionToUserEvent;

import io.sseservice.api.waitingList.event.WaitingListEventBase;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
public class SessionToUserEventImpl extends WaitingListEventBase implements SessionToUserEvent {

    private long userId;
    private String userName;

    public SessionToUserEventImpl(long userId, String userName) {
        super(userId);
        this.userName = userName;
    }

    public static SessionToUserEventImpl from(long userId, String userName) {
        return new SessionToUserEventImpl(userId, userName);
    }
}