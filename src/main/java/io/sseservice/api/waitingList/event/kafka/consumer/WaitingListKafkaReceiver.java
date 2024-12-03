package io.sseservice.api.waitingList.event.kafka.consumer;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.WaitingListEventPublisher;
import io.sseservice.common.event.kafka.consumer.KafkaReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
@RequiredArgsConstructor
public class WaitingListKafkaReceiver implements KafkaReceiver<WaitingListEvent> {

    private final WaitingListKafkaConsumerManager manager;
    private final WaitingListEventPublisher eventPublisher;

    @Override
    public void execute() {
        while (true) {
            handleEvents(manager.retriveEvents());
        }

    }

    @Override
    public void handleEvent(WaitingListEvent event) {
        eventPublisher.execute(event);
    }
}
