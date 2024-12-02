package io.sseservice.api.waitingList.infrastructure;

import io.sseservice.api.waitingList.infrastructure.entity.Sse;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface SseRepository {

    Sse save(Sse entity);
}
