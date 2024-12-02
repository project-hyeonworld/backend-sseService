package io.sseservice.api.sse.domain.strategy;

import io.sseservice.api.sse.constant.EmitterType;
import io.sseservice.api.gameStage.domain.dto.GameStageEmitterManager;
import io.sseservice.api.sse.domain.dto.WaitingListEmitterManager;
import io.sseservice.common.emitter.EmitterManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
@Component
public class EmitterManagerStrategy {
    private ConcurrentHashMap<EmitterType, Supplier<EmitterManager>> strategy;

    public EmitterManagerStrategy() {
        this.strategy = new ConcurrentHashMap<>();
        this.strategy.put(EmitterType.WAITING_LIST, WaitingListEmitterManager::from);
        this.strategy.put(EmitterType.CURRENT_GAME_STAGE, GameStageEmitterManager::from);
    }

    public EmitterManager get(EmitterType emitterType) {
        return strategy.get(emitterType).get();
    }

    public List<EmitterManager> getAll() {
        return strategy.values().stream()
                .map(Supplier::get)
                .toList();
    }
}
