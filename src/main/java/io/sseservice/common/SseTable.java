package io.sseservice.common;

import io.sseservice.common.emitter.SseManager;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 17.
 */
@Component
public class SseTable {
    private final ConcurrentHashMap<Long, SseManager> sseManagers;

    public SseTable() {
        this.sseManagers = new ConcurrentHashMap<>();
    }

    public Optional<SseManager> findByPartyId(long partyId) {
        return Optional.ofNullable(sseManagers.get(partyId));
    }

    public SseManager save(long partyId, SseManager sseManager) {
        if (sseManagers.containsKey(partyId)) {
            return sseManagers.get(partyId);
        }
        sseManagers.put(partyId, sseManager);
        return sseManager;
    }
}
