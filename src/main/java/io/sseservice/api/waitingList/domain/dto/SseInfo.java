package io.sseservice.api.waitingList.domain.dto;

import io.sseservice.api.waitingList.infrastructure.entity.Sse;

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
