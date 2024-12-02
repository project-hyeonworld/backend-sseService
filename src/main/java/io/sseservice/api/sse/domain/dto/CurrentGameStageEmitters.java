package io.sseservice.api.sse.domain.dto;

import io.sseservice.api.sse.interfaces.CustomEmitters;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 19.
 */
public class CurrentGameStageEmitters extends CustomEmitters<CurrentGameStageEmitter> {

    private CurrentGameStageEmitters() {
        super();
    }

    @Override
    protected CurrentGameStageEmitter createEmitter() {
        return CurrentGameStageEmitter.from();
    }

    private CurrentGameStageEmitters(long userId) {
        super();
        emitters.put(userId, CurrentGameStageEmitter.from());
    }

    public CurrentGameStageEmitters from(long userId) {
        return new CurrentGameStageEmitters(userId);
    }

    public static CurrentGameStageEmitters from() {
        return new CurrentGameStageEmitters();
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

    private Callable<Void> getVoidCallable(CurrentGameStageEmitter emitter, byte gameStage) {
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
            emitters.put(key, CurrentGameStageEmitter.from());
            return null;
        };
    }


}
