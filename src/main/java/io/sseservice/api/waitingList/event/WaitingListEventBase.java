package io.sseservice.api.waitingList.event;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
public abstract class WaitingListEventBase implements WaitingListEvent {
    protected long userId;

    public WaitingListEventBase(long userId) {
        this.userId = userId;
    }

    public long userId() {
        return userId;
    }
}
