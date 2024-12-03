package io.sseservice.common.domain.sseService;

import io.sseservice.common.emitter.EmitterManager;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
public interface SseService<EM extends EmitterManager> {

    public EM createEmitterManager(long partyId);
}
