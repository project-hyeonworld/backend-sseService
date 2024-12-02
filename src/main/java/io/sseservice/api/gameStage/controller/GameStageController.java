package io.sseservice.api.gameStage.controller;

import io.sseservice.api.gameStage.domain.GameStageService;
import io.sseservice.api.gameStage.domain.dto.GameStageEmitter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/sse/{partyId}/game-stage")
public class GameStageController {

    private final GameStageService gameStageService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<GameStageEmitter> getGameStageEmitter(@PathVariable long partyId, @RequestParam long userId) {
        return ResponseEntity.ok(gameStageService.retreiveEmitter(partyId, userId));
    }

    @PostMapping(value = "/{gameStage}")
    public ResponseEntity<Byte> postGameStage(@PathVariable long partyId,
            @PathVariable byte gameStage) {
        return ResponseEntity.ok(gameStageService.sendGameStage(partyId, gameStage));
    }
}
