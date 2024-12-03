package io.sseservice.api.waitingList.event.kafka.consumer.sessionToUserEvent;

import io.sseservice.api.waitingList.event.WaitingListEventImpl;
import io.sseservice.api.waitingList.event.kafka.consumer.sessionToPartyEvent.SessionToPartyEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerStrategy;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
public class SessionToUserEventKafkaConsumerStrategy extends GenericKafkaConsumerStrategy<SessionToUserEventImpl, String, Long> {

    @Override
    protected SessionToUserEventImpl convertToEvent(ConsumerRecord<String, Long> record) {
        return null;
    }

    @Override
    public Class<SessionToUserEventImpl> getEventClass() {
        WaitingListEventImpl a = WaitingListEventImpl.from(2,3,"a");

        return null;
    }
}
