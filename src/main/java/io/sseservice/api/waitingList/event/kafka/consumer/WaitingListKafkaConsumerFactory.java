package io.sseservice.api.waitingList.event.kafka.consumer;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.api.waitingList.event.WaitingListEventBase;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerFactory;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerStrategy;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
public class WaitingListKafkaConsumerFactory extends GenericKafkaConsumerFactory<WaitingListEventBase> {

    public WaitingListKafkaConsumerFactory(
            List<GenericKafkaConsumerStrategy<? extends WaitingListEventBase, ?, ?>> defaultKafkaConsumerStrategies) {
        super(defaultKafkaConsumerStrategies);
    }
}
