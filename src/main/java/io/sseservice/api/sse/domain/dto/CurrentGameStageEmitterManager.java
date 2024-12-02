package io.sseservice.api.sse.domain.dto;

import io.sseservice.api.sse.interfaces.EmitterManager;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 18.
 */
public class CurrentGameStageEmitterManager implements EmitterManager<CurrentGameStageEmitter, CurrentGameStageEmitters> {

    private CurrentGameStageEmitters currentGameStageEmitters;

    private CurrentGameStageEmitterManager() {
        this.currentGameStageEmitters = CurrentGameStageEmitters.from();
    }

    public static EmitterManager from() {
        return new CurrentGameStageEmitterManager();
    }

    @Override
    public CurrentGameStageEmitter create(long userId) {
        CurrentGameStageEmitter emitter = CurrentGameStageEmitter.from();
        return emitter;
    }

    @Override
    public void add(long userId) {
        currentGameStageEmitters.add(userId);
    }

    @Override
    public void remove(long userId) {
        currentGameStageEmitters.remove(userId);
    }

    @Override
    public CurrentGameStageEmitter get(long userId) {
        return currentGameStageEmitters.get(userId);
    }

    @Override
    public CurrentGameStageEmitter retrieve(long userId) {
        return currentGameStageEmitters.retrieve(userId);
    }

    @Override
    public List<CurrentGameStageEmitter> get() {
        return currentGameStageEmitters.toList();
    }

    @Override
    public void set(List<Long> userIds, List<CurrentGameStageEmitter> emitters) {
        currentGameStageEmitters.set(userIds, emitters);
    }

    @Override
    public void set(List<CurrentGameStageEmitter> emitters) {
        currentGameStageEmitters.set(emitters);
    }

    public void sendAll(byte gameStage) {
        currentGameStageEmitters.sendAll(gameStage);
    }

    public void refill() {
        currentGameStageEmitters.refill();
    }

    public void handleGameIn(long userId) {
        currentGameStageEmitters.add(userId);
    }


}
