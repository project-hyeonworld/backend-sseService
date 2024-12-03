package io.sseservice.api.waitingList.domain;

import io.sseservice.api.waitingList.domain.dto.WaitingListEmitter;
import io.sseservice.api.waitingList.domain.dto.WaitingListEmitterManager;
import io.sseservice.api.waitingList.infrastructure.WaitingListEmitterManagerCache;
import io.sseservice.common.domain.sseService.SseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
@Service
@RequiredArgsConstructor
public class WaitingListService implements SseService<WaitingListEmitterManager> {

    private final WaitingListEmitterManagerCache emitterManagerCache;

    public List<String> getWaitingList(long partyId) {
        WaitingListEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(() -> createEmitterManager(partyId));
        return manager.getWaitingList();
    }

    public WaitingListEmitter retrieveWaitingListEmitter(long partyId, long userId) {
        WaitingListEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(() -> createEmitterManager(partyId));
        return manager.retrieve(userId);
    }

    public String addNameOnWaitingList(long partyId, String userName) {
        WaitingListEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(() -> createEmitterManager(partyId));
        return manager.addNameOnWaitingList(userName);
    }

    public String removeNameFromWaitingList(long partyId, String userName) {
        WaitingListEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
                .orElseGet(() -> createEmitterManager(partyId));
        return manager.removeNameFromWaitingList(userName);
    }

    @Override
    public WaitingListEmitterManager createEmitterManager(long partyId) {
        return emitterManagerCache.save(partyId, WaitingListEmitterManager.from());
    }
}




