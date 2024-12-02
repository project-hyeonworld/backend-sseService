package io.sseservice.api.sse.infrastructure;

import io.sseservice.api.sse.infrastructure.entity.Sse;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface SseRepository {

    Sse save(Sse entity);
}
