package io.sseservice.api.sse.constant;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public enum EmitterType {
    WAITING_LIST("WaitingList"),
    CURRENT_GAME_STAGE("CurrentGameStage"),
    ALL("All");

    private String eventName;

    EmitterType(String EventName) {
    }
}
