package io.sseservice.common.emitter;

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
}
