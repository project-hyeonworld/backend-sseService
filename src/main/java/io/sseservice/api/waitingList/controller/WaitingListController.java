package io.sseservice.api.waitingList.controller;

import io.sseservice.api.waitingList.controller.dto.res.WaitingListResponse;
import io.sseservice.api.waitingList.domain.WaitingListService;
import io.sseservice.api.waitingList.domain.dto.WaitingListEmitter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/sse/{partyId}/waiting-list")
public class WaitingListController {

    private final WaitingListService waitingListService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<WaitingListEmitter> getWaitingList(@PathVariable long partyId, @RequestParam long userId) {
        return ResponseEntity.ok(waitingListService.retrieveWaitingListEmitter(partyId, userId));
    }

    //TODO:Switch to Post mehtod
    @GetMapping(value = "/init")
    public ResponseEntity<WaitingListResponse> initWaitingList(@PathVariable long partyId) {
        return ResponseEntity.ok(WaitingListResponse.from(waitingListService.getWaitingList(partyId)));
    }

    @PostMapping(value = "/{name}")
    public ResponseEntity<String> addNameOnWaitingList(@PathVariable long partyId,
            @PathVariable String name) {
        return ResponseEntity.ok(waitingListService.addNameOnWaitingList(partyId, name));
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<String> removeNameFromWaitingList(@PathVariable long partyId,
            @PathVariable String name) {
        return ResponseEntity.ok(waitingListService.removeNameFromWaitingList(partyId, name));
    }
}
