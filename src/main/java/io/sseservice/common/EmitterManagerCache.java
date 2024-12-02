package io.sseservice.common;

import io.sseservice.common.emitter.EmitterManager;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
public class EmitterManagerCache<T extends EmitterManager> {
    protected final ConcurrentHashMap<Long, T> emitterManagers;

    public EmitterManagerCache() {
        emitterManagers = new ConcurrentHashMap<>();
    }

    public Optional<T> findByPartyId(long partyId) {
        return Optional.ofNullable(emitterManagers.get(partyId));
    }

    public T save(long partyId, T emitterManager) {
        if (emitterManagers.containsKey(partyId)) {
            return emitterManagers.get(partyId);
        }
        emitterManagers.put(partyId, emitterManager);
        return emitterManager;
    }
}
