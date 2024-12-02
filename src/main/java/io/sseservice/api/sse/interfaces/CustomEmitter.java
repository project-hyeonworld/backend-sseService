package io.sseservice.api.sse.interfaces;

import io.sseservice.api.sse.constant.EventType;
import java.io.IOException;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public abstract class CustomEmitter extends SseEmitter {
    protected boolean completed;
    protected CustomEmitter(long timeout) {
        super(timeout);
    }

    protected CustomEmitter() {
        super();
    }

    protected boolean isCompleted() {
        return completed;
    }

    protected void setCompleted() {
        completed = true;
    }

    public void send() {
        try {
            send(CustomEmitter.event()
                    .name(EventType.CONNECTION_CHECK.getEventName())
                    .data(null));
            complete();
        } catch (IOException e) {
            completeWithError(e);
        }

    }
}
