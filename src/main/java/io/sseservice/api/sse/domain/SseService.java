package io.sseservice.api.sse.domain;

import io.sseservice.api.sse.constant.EmitterType;
import io.sseservice.api.gameStage.domain.dto.GameStageEmitter;
import io.sseservice.api.sse.domain.dto.WaitingListEmitter;
import io.sseservice.api.sse.domain.strategy.EmitterManagerStrategy;
import io.sseservice.api.sse.infrastructure.SseRepository;
import io.sseservice.common.SseTable;
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
public class SseService {

    private final SseRepository sseRepository;
    private final SseTable sseTable;
    private final EmitterManagerStrategy emitterManagerStrategy;

    public void logIn(long partyId, String userName) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        sseManager.handleLogIn(userName);
    }

    public void gameOut(long partyId, long userId, String userName) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
    }

    public void gameIn(long partyId, String userName) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        sseManager.handleGameIn(userName);
    }

    public void logOut(long partyId, long userId, String userName) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        sseManager.remove(EmitterType.ALL, userId);
    }

    public GameStageEmitter getGameStageEmitter(long partyId, long userId) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        return (GameStageEmitter) sseManager.getEmitter(EmitterType.CURRENT_GAME_STAGE, userId);
    }

    public List<String> getWaitingList(long partyId) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        return sseManager.getWaitingList();
    }

    public WaitingListEmitter getWaitingListEmitter(long partyId, long userId) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        return (WaitingListEmitter) sseManager.getEmitter(EmitterType.WAITING_LIST ,userId);
    }

    public WaitingListEmitter retrieveWaitingListEmitter(long partyId, long userId) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        return (WaitingListEmitter) sseManager.retrieveEmitter(EmitterType.WAITING_LIST ,userId);
    }

    public String addNameOnWaitingList(long partyId, String name) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
         return sseManager.addNameOnWaitingList(name);
    }

    public String removeNameFromWaitingList(long partyId, String name) {
        SseManager sseManager = sseTable.findByPartyId(partyId)
                .orElseGet(()->createSseManager(partyId));
        return sseManager.removeNameFromWaitingList(name);
    }

    private SseManager createSseManager(long partyId) {
        return sseTable.save(partyId, SseManager.from(emitterManagerStrategy));
    }
}




