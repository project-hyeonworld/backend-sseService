package io.sseservice.api.sse.domain.dto;

import io.sseservice.api.sse.constant.EventType;
import io.sseservice.api.sse.interfaces.CustomEmitter;
import java.io.IOException;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 18.
 */
public class CurrentGameStageEmitter extends CustomEmitter {
    private CurrentGameStageEmitter() {
        super(60 * 60 * 1000L);
    }

    public static CurrentGameStageEmitter from() {
        CurrentGameStageEmitter emitter = new CurrentGameStageEmitter();

        emitter.onCompletion(emitter::setCompleted);
        emitter.onTimeout(emitter::setCompleted);

//        try {
//            emitter.send(SseEmitter.event()
//                    .name(EventType.CONNECTION_CHECK.getEventName())
//                    .data("SSE connected")
//                    .reconnectTime(1000L));
//        } catch (IOException e) {
//            log.error("Fail to send emitter id={}, {}", userId, e.getMessage());
//        }
        return emitter;
    }

    public void send(byte gameStage) throws IOException {
        try {
            send(CustomEmitter.event()
                    .name(EventType.CHANGE_CURRENT_STAGE.getEventName())
                    .data(gameStage));
        } catch (IOException e) {
            //completeWithError(e);
        }
        return;
    }
}
