package io.sseservice.api.gameStage.domain.dto;

import io.sseservice.common.emitter.CustomEmitters;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 19.
 */
public class GameStageEmitters extends CustomEmitters<GameStageEmitter> {

    private GameStageEmitters() {
        super();
    }

    @Override
    protected GameStageEmitter createEmitter() {
        return GameStageEmitter.from();
    }

    private GameStageEmitters(long userId) {
        super();
        emitters.put(userId, GameStageEmitter.from());
    }

    public GameStageEmitters from(long userId) {
        return new GameStageEmitters(userId);
    }

    public static GameStageEmitters from() {
        return new GameStageEmitters();
    }

    public void sendAll(byte gameStage) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(emitters.size());
            List<Callable<Void>> tasks = getSendTasks(gameStage);
            try {
                executorService.invokeAll(tasks);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                executorService.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Callable<Void>> getSendTasks(byte gameStage) {
        return emitters.values().stream()
                .map(emiiter -> getVoidCallable(emiiter, gameStage))
                .toList();
    }

    private Callable<Void> getVoidCallable(GameStageEmitter emitter, byte gameStage) {
        return () -> {
            emitter.send(gameStage);
            return null;
        };
    }

    public void refill() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(emitters.size());
            List<Callable<Void>> tasks = getRefillTasks();
            try {
                executorService.invokeAll(tasks);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                executorService.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Callable<Void>> getRefillTasks() {
        return emitters.keySet().stream()
                .map(this::getVoidCallable)
                .toList();
    }

    private Callable<Void> getVoidCallable(Long key) {
        return () -> {
            emitters.put(key, GameStageEmitter.from());
            return null;
        };
    }


}
