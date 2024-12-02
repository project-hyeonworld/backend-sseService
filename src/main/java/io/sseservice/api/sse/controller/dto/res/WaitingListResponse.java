package io.sseservice.api.sse.controller.dto.res;

import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 20.
 */
public record WaitingListResponse (
        List<String> names
) {

    public static WaitingListResponse from(List<String> waitingList) {
        return new WaitingListResponse(waitingList);
    }
}
