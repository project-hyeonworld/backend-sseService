package io.sseservice.api.sse.interfaces;

import io.sseservice.api.sse.constant.EmitterType;
import io.sseservice.api.sse.domain.dto.CurrentGameStageEmitterManager;
import io.sseservice.api.sse.domain.dto.WaitingListEmitterManager;
import io.sseservice.api.sse.domain.strategy.EmitterManagerStrategy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public class SseManager {
    private final ConcurrentHashMap<EmitterType, EmitterManager<?, ?>> sseCollection;
    private final EmitterManagerStrategy emitterManagerStrategy;

    private SseManager (EmitterManagerStrategy emitterManagerStrategy) {
        this.emitterManagerStrategy = emitterManagerStrategy;
        this.sseCollection = new ConcurrentHashMap<>();
    }

    public static SseManager from(EmitterManagerStrategy emitterManagerStrategy) {
        return new SseManager(emitterManagerStrategy);
    }

    public void handleLogIn(String userName) {
        WaitingListEmitterManager waitingListEmitterManager = (WaitingListEmitterManager) getEmitterManager(EmitterType.WAITING_LIST);
        waitingListEmitterManager.handleLogIn(userName);
    }

    public void handleGameIn(String userName) {
        WaitingListEmitterManager waitingListEmitterManager = (WaitingListEmitterManager) getEmitterManager(EmitterType.WAITING_LIST);
        waitingListEmitterManager.handleGameIn(userName);
    }

    public void handleChangeGameStage(byte gameStage) {
        CurrentGameStageEmitterManager emitterManager = (CurrentGameStageEmitterManager) getEmitterManager(EmitterType.CURRENT_GAME_STAGE);
        emitterManager.sendAll(gameStage);
        //emitterManager.refill();
    }

    //Nobody listens to this.
    public void add(EmitterType emitterType, long userId) {
        EmitterManager emitterManager = getEmitterManager(emitterType);
        emitterManager.add(userId);
    }

    public void remove(EmitterType emitterType, long userId) {
        List<EmitterManager> emitterManagers = getEmitterManagers(emitterType);
        for (EmitterManager emitterManager : emitterManagers) {
            emitterManager.remove(userId);
        }
    }

    public CustomEmitter getEmitter(EmitterType emitterType, long userId) {
        EmitterManager emitterManager = getEmitterManager(emitterType);
        return emitterManager.get(userId);
    }

    public CustomEmitter retrieveEmitter(EmitterType emitterType, long userId) {
        EmitterManager emitterManager = getEmitterManager(emitterType);
        return emitterManager.retrieve(userId);
    }

    private EmitterManager getEmitterManager(EmitterType emitterType) {
        if (sseCollection.containsKey(emitterType)) {
            return sseCollection.get(emitterType);
        }
        EmitterManager emitterManager = emitterManagerStrategy.get(emitterType);
        sseCollection.put(emitterType, emitterManager);
        return emitterManager;
    }

    private List<EmitterManager> getEmitterManagers(EmitterType emitterType) {
        if (emitterType == EmitterType.ALL) {
            return emitterManagerStrategy.getAll();
        }
        return List.of(emitterManagerStrategy.get(emitterType));
    }

    public List<String> getWaitingList() {
        WaitingListEmitterManager waitingListEmitterManager = (WaitingListEmitterManager) getEmitterManager(EmitterType.WAITING_LIST);
        return waitingListEmitterManager.getWaitingList();
    }

    public String addNameOnWaitingList(String name) {
        WaitingListEmitterManager waitingListEmitterManager = (WaitingListEmitterManager) getEmitterManager(EmitterType.WAITING_LIST);
        return waitingListEmitterManager.addNameOnWaitingList(name);
    }

    public String removeNameFromWaitingList(String name) {
        WaitingListEmitterManager waitingListEmitterManager = (WaitingListEmitterManager) getEmitterManager(EmitterType.WAITING_LIST);
        return waitingListEmitterManager.removeNameFromWaitingList(name);
    }
}
