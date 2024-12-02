package io.sseservice.api.sse.domain.dto;

import io.sseservice.api.sse.constant.EventType;
import io.sseservice.api.sse.interfaces.CustomEmitter;
import io.sseservice.api.sse.interfaces.CustomEmitters;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public class WaitingListEmitters extends CustomEmitters<WaitingListEmitter> {

    public WaitingListEmitters() {
        super();
    }

    @Override
    protected WaitingListEmitter createEmitter() {
        return WaitingListEmitter.from();
    }

    public static WaitingListEmitters from() {
        return new WaitingListEmitters();
    }



    public void send(EventType eventType, String name) {
        if (!emitters.isEmpty()) {
            ExecutorService executorService = Executors.newFixedThreadPool(emitters.size());
            List<Callable<Void>> tasks = getThreadTasks(eventType, name);
            try {
                executorService.invokeAll(tasks);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                executorService.shutdown();
            }
        }
    }

    private List<Callable<Void>> getThreadTasks(EventType eventType, String name) {
        return emitters.values().stream()
                .map(emiiter -> getVoidCallable(emiiter, eventType, name))
                .toList();
    }

    private Callable<Void> getVoidCallable(WaitingListEmitter emitter, EventType eventType, String name) {
        return () -> {
            try {
                emitter.send(CustomEmitter.event()
                        .name(eventType.getEventName())
                        .data(name));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        };
    }

    public void add(long userId) {
        emitters.put(userId, createEmitter());
    }


}
