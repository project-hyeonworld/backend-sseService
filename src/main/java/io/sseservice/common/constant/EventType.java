package io.sseservice.common.constant;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public enum EventType {
    CONNECTION_CHECK ("connect"),
    CHANGE_CURRENT_STAGE ("ChangeCurrentStage"),
    ADD_NAME_TO_WAITING_LIST ("AddNameToWaitingList"),
    REMOVE_NAME_FROM_WAITING_LIST ("RemoveNameFromWaitingList");

    private String eventName;

    EventType(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }
}
