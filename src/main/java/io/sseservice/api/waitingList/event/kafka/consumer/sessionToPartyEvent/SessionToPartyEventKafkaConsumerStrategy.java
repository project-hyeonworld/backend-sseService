package io.sseservice.api.waitingList.event.kafka.consumer.sessionToPartyEvent;

import io.sseservice.api.waitingList.event.WaitingListEventImpl;
import io.sseservice.api.waitingList.event.kafka.consumer.sessionEvent.SessionEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerStrategy;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
public class SessionToPartyEventKafkaConsumerStrategy extends GenericKafkaConsumerStrategy<SessionToPartyEventImpl, String, Long> {

    @Override
    protected SessionToPartyEventImpl convertToEvent(ConsumerRecord<String, Long> record) {
        return null;
    }

    @Override
    public Class<SessionToPartyEventImpl> getEventClass() {
        return SessionToPartyEventImpl.class;
    }
}
