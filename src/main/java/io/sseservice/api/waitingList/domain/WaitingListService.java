package io.sseservice.api.waitingList.domain;

import io.sseservice.api.gameStage.domain.dto.GameStageEmitter;
import io.sseservice.api.waitingList.domain.dto.WaitingListEmitter;
import io.sseservice.api.waitingList.domain.dto.WaitingListEmitterManager;
import io.sseservice.api.waitingList.domain.dto.WaitingListEmitters;
import io.sseservice.api.waitingList.infrastructure.WaitingListEmitterManagerCache;
import io.sseservice.api.waitingList.infrastructure.SseRepository;
import io.sseservice.common.constant.EmitterType;
import io.sseservice.common.emitter.EmitterManager;
import io.sseservice.common.emitter.SseManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
@Service
@RequiredArgsConstructor
public class WaitingListService {

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

    private WaitingListEmitterManager createEmitterManager(long partyId) {
        return emitterManagerCache.save(partyId, WaitingListEmitterManager.from());
    }

    //WaitingList doesnt have to know about high-level procedure
//    public void logIn(long partyId, String userName) {
//        addNameOnWaitingList(partyId, userName);
//    }
//
//    public void gameOut(long partyId, long userId, String userName) {
//    }
//
//    public void gameIn(long partyId, String userName) {
//        WaitingListEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
//                .orElseGet(()-> createEmitterManager(partyId));
//        manager.removeNameFromWaitingList(userName);
//    }
//
//    public void logOut(long partyId, long userId, String userName) {
//        WaitingListEmitterManager manager = emitterManagerCache.findByPartyId(partyId)
//                .orElseGet(()-> createEmitterManager(partyId));
//        manager.remove(userId);
//    }
}




