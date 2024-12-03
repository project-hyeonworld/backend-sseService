package io.sseservice.api.gameStage.domain;

import io.sseservice.api.gameStage.domain.dto.GameStageEmitter;
import io.sseservice.api.gameStage.domain.dto.GameStageEmitterManager;
import io.sseservice.api.gameStage.infrastructure.GameStageEmitterManagerCache;
import io.sseservice.common.domain.sseService.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Service
@RequiredArgsConstructor
public class GameStageService implements SseService<GameStageEmitterManager> {

    private final GameStageEmitterManagerCache emitterManagerCache;
    //TODO: handle LogOutEvent

    public GameStageEmitter getEmitter(long partyId, long userId) {
        GameStageEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(()-> createEmitterManager(partyId));
        return manager.get(userId);
    }

    public GameStageEmitter retreiveEmitter(long partyId, long userId) {
        GameStageEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(()-> createEmitterManager(partyId));
        return manager.retrieve(userId);
    }

    public byte sendGameStage(long partyId, byte gameStage) {
        GameStageEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(()-> createEmitterManager(partyId));
        manager.sendAll(gameStage);
        return gameStage;
    }

    @Override
    public GameStageEmitterManager createEmitterManager(long partyId) {
        return emitterManagerCache.save(partyId, GameStageEmitterManager.from());
    }
}
