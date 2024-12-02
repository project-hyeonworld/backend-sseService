package io.sseservice.api.sse.controller;

import io.sseservice.api.sse.controller.dto.res.WaitingListResponse;
import io.sseservice.api.sse.domain.SseService;
import io.sseservice.api.sse.domain.dto.CurrentGameStageEmitter;
import io.sseservice.api.sse.domain.dto.WaitingListEmitter;
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
@RequestMapping("/api/v2/sse")
public class SseController {
    private final SseService sseService;

    @GetMapping(value = "/{partyId}/waiting-list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<WaitingListEmitter> getWaitingList(@PathVariable long partyId, @RequestParam long userId) {
         return ResponseEntity.ok(sseService.retrieveWaitingListEmitter(partyId, userId));
    }

    @GetMapping(value = "/{partyId}/game-stage", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<CurrentGameStageEmitter> getGameStage(@PathVariable long partyId, @RequestParam long userId) {
        return ResponseEntity.ok(sseService.retreiveGameStageEmitter(partyId, userId));
    }

    @GetMapping(value = "/{partyId}/waiting-list/init")
    public ResponseEntity<WaitingListResponse> initWaitingList(@PathVariable long partyId) {
        return ResponseEntity.ok(WaitingListResponse.from(sseService.getWaitingList(partyId)));
    }

    @PostMapping(value = "/{partyId}/game-stage/{gameStage}")
    public ResponseEntity<Byte> postGameStage(@PathVariable long partyId,
            @PathVariable byte gameStage) {
        return ResponseEntity.ok(sseService.sendCurrentGameStage(partyId, gameStage));
    }

    @PostMapping(value = "/{partyId}/waiting-list/{name}")
    public ResponseEntity<String> addNameOnWaitingList(@PathVariable long partyId,
            @PathVariable String name) {
        return ResponseEntity.ok(sseService.addNameOnWaitingList(partyId, name));
    }

    @DeleteMapping(value = "/{partyId}/waiting-list/{name}")
    public ResponseEntity<String> removeNameFromWaitingList(@PathVariable long partyId,
            @PathVariable String name) {
        return ResponseEntity.ok(sseService.removeNameFromWaitingList(partyId, name));
    }
}
