package io.sseservice.common.emitter;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public abstract class CustomEmitters<T extends CustomEmitter> {

    protected final ConcurrentHashMap<Long, T> emitters;

    protected CustomEmitters() {
        this.emitters = new ConcurrentHashMap<>();
    }

    protected abstract T createEmitter();

    public List<T> toList() {
        return emitters.values().stream().toList();
    }

    public T get(long userId) {
        return emitters.get(userId);
    }

    public T retrieve(long userId) {
        T emitter = emitters.get(userId);
        if (emitter == null || emitter.isCompleted()) {
            emitter = createEmitter();
            add(userId, emitter);
        }
        return emitter;
    }

    public void add(long userId) {
        emitters.put(userId, createEmitter());
    }

    public void add(long userId, T emitter) {
        emitters.put(userId, emitter);
    }

    public void set(List<T> incomingEmitters) {
        int i = 0;
        for (Entry<Long, T> entry : emitters.entrySet()) {
            emitters.put(entry.getKey(), incomingEmitters.get(i++));
        }
    }

    public void set(List<Long> userIds, List<T> incomingEmitters) {
        emitters.clear();
        for (int i = 0; i < userIds.size(); ++i) {
            emitters.put(userIds.get(i), incomingEmitters.get(i));
        }
    }

    public void remove(long userId) {
        T emitter = emitters.get(userId);
        if (emitter != null) {
            emitter.complete();
            emitters.remove(userId);
        }
    }

}
