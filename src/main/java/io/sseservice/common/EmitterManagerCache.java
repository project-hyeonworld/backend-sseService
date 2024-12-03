package io.sseservice.common;

import io.sseservice.common.emitter.EmitterManager;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
public class EmitterManagerCache<EM extends EmitterManager> {
    protected final ConcurrentHashMap<Long, EM> emitterManagers;

    public EmitterManagerCache() {
        emitterManagers = new ConcurrentHashMap<>();
    }

    public Optional<EM> findByPartyId(long partyId) {
        return Optional.ofNullable(emitterManagers.get(partyId));
    }

    public EM save(long partyId, EM emitterManage) {
        if (emitterManagers.containsKey(partyId)) {
            return emitterManagers.get(partyId);
        }
        emitterManagers.put(partyId, emitterManage);
        return emitterManage;
    }
}
