package io.sseservice.api.waitingList.event.kafka.consumer;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.WaitingListEventBase;
import io.sseservice.api.waitingList.event.kafka.consumer.sessionEvent.SessionEventImpl;
import io.sseservice.api.waitingList.event.kafka.consumer.sessionToPartyEvent.SessionToPartyEventImpl;
import io.sseservice.api.waitingList.event.kafka.consumer.sessionToUserEvent.SessionToUserEventImpl;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
@RequiredArgsConstructor
public class WaitingListKafkaConsumerManager extends GenericKafkaConsumerManager<WaitingListEventBase> {

    private final WaitingListKafkaConsumerFactory factory;

    public List<WaitingListEvent> retriveEvents() {
        factory.getConsumer(SessionEventImpl.class);
        factory.getConsumer(SessionToPartyEventImpl.class);
        factory.getConsumer(SessionToUserEventImpl.class);
        return null;
    }
}
