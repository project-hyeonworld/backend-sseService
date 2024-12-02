package io.sseservice.api.gameStage.domain.dto;

import io.sseservice.api.sse.constant.EventType;
import io.sseservice.common.emitter.CustomEmitter;
import java.io.IOException;
/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 18.
 */
public class GameStageEmitter extends CustomEmitter {
    private GameStageEmitter() {
        super(60 * 60 * 1000L);
    }

    public static GameStageEmitter from() {
        GameStageEmitter emitter = new GameStageEmitter();

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
