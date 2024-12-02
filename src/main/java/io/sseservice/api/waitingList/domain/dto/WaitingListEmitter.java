package io.sseservice.api.waitingList.domain.dto;

import io.sseservice.common.emitter.CustomEmitter;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public class WaitingListEmitter extends CustomEmitter {
    private WaitingListEmitter() {
        super(60 * 60 * 1000L);
    }

    public static WaitingListEmitter from() {
        WaitingListEmitter emitter = new WaitingListEmitter();
        emitter.onCompletion(emitter::setCompleted);
        emitter.onTimeout(emitter::setCompleted);
        return emitter;
    }
}