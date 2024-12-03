package io.sseservice.api.waitingList.event;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
public class WaitingListEventImpl extends WaitingListEventBase implements WaitingListEvent {

    private int sessionType;
    private String userName;

    public WaitingListEventImpl(long userId, int sessionType, String userName) {
        super(userId);
        this.sessionType = sessionType;
        this.userName = userName;
    }

    public static WaitingListEventImpl from(long userId, int sessionType, String userName) {
        return new WaitingListEventImpl(userId, sessionType, userName);
    }
}