package io.sseservice.api.gameStage.domain.dto;

import io.sseservice.common.emitter.EmitterManager;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 18.
 */
public class GameStageEmitterManager implements EmitterManager<GameStageEmitter> {

    private final GameStageEmitters gameStageEmitters;

    private GameStageEmitterManager() {
        this.gameStageEmitters = GameStageEmitters.from();
    }

    public static GameStageEmitterManager from() {
        return new GameStageEmitterManager();
    }

    @Override
    public GameStageEmitter create(long userId) {
        return GameStageEmitter.from();
    }

    @Override
    public void add(long userId) {
        gameStageEmitters.add(userId);
    }

    @Override
    public void remove(long userId) {
        gameStageEmitters.remove(userId);
    }

    @Override
    public GameStageEmitter get(long userId) {
        return gameStageEmitters.get(userId);
    }

    @Override
    public GameStageEmitter retrieve(long userId) {
        return gameStageEmitters.retrieve(userId);
    }

    public void sendAll(byte gameStage) {
        gameStageEmitters.sendAll(gameStage);
    }

}
