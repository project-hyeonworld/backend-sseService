package io.sseservice.api.waitingList.controller.dto.req;

import io.sseservice.api.waitingList.domain.dto.in.WaitingListCommand;
import io.sseservice.common.dto.SseRequest;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
public record WaitingListRequest(
        long partyId
) implements SseRequest
{
    public WaitingListCommand toCommand() {
        return new WaitingListCommand(partyId);
    }
}
