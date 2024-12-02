package io.sseservice.api.sse.domain.dto;

import io.sseservice.api.sse.constant.EventType;
import io.sseservice.api.sse.interfaces.EmitterManager;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public class WaitingListEmitterManager implements EmitterManager<WaitingListEmitter, WaitingListEmitters> {
    private WaitingListEmitters waitingListEmitters;
    @Getter
    private final List<String> waitingList;

    private WaitingListEmitterManager() {
        this.waitingListEmitters = WaitingListEmitters.from();
        this.waitingList = new ArrayList<>();
    }

    public static EmitterManager from() {
        return new WaitingListEmitterManager();
    }

    @Override
    public WaitingListEmitter create(long userId) {
        return WaitingListEmitter.from();
    }

    @Override
    public void add(long userId) {
        waitingListEmitters.add(userId);
    }

    @Override
    public void remove(long userId) {
        waitingListEmitters.remove(userId);
    }

    @Override
    public WaitingListEmitter get(long userId) {
        return waitingListEmitters.get(userId);
    }

    @Override
    public WaitingListEmitter retrieve(long userId) {
        return waitingListEmitters.retrieve(userId);
    }

    @Override
    public List<WaitingListEmitter> get() {
        return waitingListEmitters.toList();
    }

    @Override
    public void set(List<WaitingListEmitter> emitter) {
        waitingListEmitters.set(emitter);
    }

    @Override
    public void set(List<Long> userIds, List<WaitingListEmitter> emitters) {
        waitingListEmitters.set(userIds, emitters);
    }

    public void handleGameIn(String userName) {
        removeNameFromWaitingList(userName);
    }

    public void handleLogIn(String name) {
        addNameOnWaitingList(name);
    }

    public String addNameOnWaitingList(String name) {
        waitingList.add(name);
        waitingListEmitters.send(EventType.ADD_NAME_TO_WAITING_LIST, name);
        return name;
    }

    public String removeNameFromWaitingList(String name) {
        waitingList.remove(name);
        waitingListEmitters.send(EventType.REMOVE_NAME_FROM_WAITING_LIST, name);
        return name;
    }

}
