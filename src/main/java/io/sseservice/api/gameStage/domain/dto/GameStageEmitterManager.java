package io.sseservice.api.gameStage.domain.dto;

import io.sseservice.common.emitter.EmitterManager;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 18.
 */
public class GameStageEmitterManager implements EmitterManager<GameStageEmitter, GameStageEmitters> {

    private GameStageEmitters gameStageEmitters;

    private GameStageEmitterManager() {
        this.gameStageEmitters = GameStageEmitters.from();
    }

    public static EmitterManager from() {
        return new GameStageEmitterManager();
    }

    @Override
    public GameStageEmitter create(long userId) {
        GameStageEmitter emitter = GameStageEmitter.from();
        return emitter;
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

    @Override
    public List<GameStageEmitter> get() {
        return gameStageEmitters.toList();
    }

    @Override
    public void set(List<Long> userIds, List<GameStageEmitter> emitters) {
        gameStageEmitters.set(userIds, emitters);
    }

    @Override
    public void set(List<GameStageEmitter> emitters) {
        gameStageEmitters.set(emitters);
    }

    public void sendAll(byte gameStage) {
        gameStageEmitters.sendAll(gameStage);
    }

    public void refill() {
        gameStageEmitters.refill();
    }

    public void handleGameIn(long userId) {
        gameStageEmitters.add(userId);
    }


}
