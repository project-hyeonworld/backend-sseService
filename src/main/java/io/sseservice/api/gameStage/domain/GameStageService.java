package io.sseservice.api.gameStage.domain;

import io.sseservice.api.gameStage.domain.dto.GameStageEmitter;
import io.sseservice.common.emitter.EmitterManagerStrategy;
import io.sseservice.common.constant.EmitterType;
import io.sseservice.common.emitter.SseManager;
import io.sseservice.common.SseTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Service
@RequiredArgsConstructor
public class GameStageService {

    private final SseTable sseTable;

    private final EmitterManagerStrategy emitterManagerStrategy;

    public GameStageEmitter retreiveEmitter(long partyId, long userId) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        return (GameStageEmitter) sseManager.retrieveEmitter(EmitterType.CURRENT_GAME_STAGE, userId);
    }

    private SseManager createSseManager(long partyId) {
        return sseTable.save(partyId, SseManager.from(emitterManagerStrategy));
    }

    public byte sendGameStage(long partyId, byte gameStage) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        sseManager.handleChangeGameStage(gameStage);
        return gameStage;
    }


}
