package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.common.event.CustomEvent;
import io.sseservice.common.event.kafka.consumer.CustomKafkaConsumerFactory;
import io.sseservice.common.event.kafka.consumer.DefaultKafkaConsumerStrategy;
import io.sseservice.common.event.kafka.consumer.KafkaConsumerManager;
import io.sseservice.common.event.kafka.consumer.KafkaConsumerStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class PartyKafkaConsumerManager implements KafkaConsumerManager<PartyGameStagePatchKafkaEvent> {

    private final CustomKafkaConsumerFactory customKafkaConsumerFactory;

    @Override
    public DefaultKafkaConsumerStrategy getConsumer(Class<PartyGameStagePatchKafkaEvent> eventClass) {
        return customKafkaConsumerFactory.getConsumer(eventClass);
    }
}
