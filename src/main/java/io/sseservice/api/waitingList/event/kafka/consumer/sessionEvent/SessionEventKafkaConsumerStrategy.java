package io.sseservice.api.waitingList.event.kafka.consumer.sessionEvent;

import io.sseservice.api.waitingList.event.WaitingListEventImpl;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerStrategy;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
public class SessionEventKafkaConsumerStrategy extends GenericKafkaConsumerStrategy<SessionEventImpl, String, Long> {

    @Override
    protected SessionEventImpl convertToEvent(ConsumerRecord<String, Long> record) {
        return null;
    }

    @Override
    public Class<SessionEventImpl> getEventClass() {
        WaitingListEventImpl a = WaitingListEventImpl.from(2,3,"a");

        return null;
    }
}
