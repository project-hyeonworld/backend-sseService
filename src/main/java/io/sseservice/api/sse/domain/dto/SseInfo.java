package io.sseservice.api.sse.domain.dto;

import io.sseservice.api.sse.infrastructure.entity.Sse;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public class SseInfo {
    private long partyId;

    public static Sse toEntity(long partyId) {
        return Sse.defaultBuilder()
                .partyId(partyId)
                .build();
    }
}
