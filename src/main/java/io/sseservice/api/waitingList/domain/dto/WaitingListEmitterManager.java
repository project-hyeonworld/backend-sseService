package io.sseservice.api.waitingList.domain.dto;

import io.sseservice.common.constant.EventType;
import io.sseservice.common.emitter.EmitterManager;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 4.
 */
public class WaitingListEmitterManager implements EmitterManager<WaitingListEmitter> {
    private final WaitingListEmitters waitingListEmitters;
    @Getter
    private final List<String> waitingList;

    private WaitingListEmitterManager() {
        this.waitingListEmitters = WaitingListEmitters.from();
        this.waitingList = new ArrayList<>();
    }

    public static WaitingListEmitterManager from() {
        return new WaitingListEmitterManager();
    }

    @Override
    public WaitingListEmitter create(long userId) {
        return WaitingListEmitter.from();
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
    public void add(long userId) {
        waitingListEmitters.add(userId);
    }

    public String addNameOnWaitingList(String name) {
        waitingList.add(name);
        waitingListEmitters.sendAll(EventType.ADD_NAME_TO_WAITING_LIST, name);
        return name;
    }

    public String removeNameFromWaitingList(String name) {
        waitingList.remove(name);
        waitingListEmitters.sendAll(EventType.REMOVE_NAME_FROM_WAITING_LIST, name);
        return name;
    }

    @Override
    public void remove(long userId) {
        waitingListEmitters.remove(userId);
    }

}
