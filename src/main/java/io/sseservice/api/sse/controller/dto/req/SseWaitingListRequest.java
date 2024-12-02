package io.sseservice.api.sse.controller.dto.req;

import io.sseservice.api.sse.domain.dto.in.SseWaitingListCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
public record SseWaitingListRequest (
        long partyId
) implements SseRequest
{
    public SseWaitingListCommand toCommand() {
        return new SseWaitingListCommand(partyId);
    }
}
