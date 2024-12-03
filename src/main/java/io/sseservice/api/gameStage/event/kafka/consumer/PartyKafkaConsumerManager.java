package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerStrategy;
import io.sseservice.common.event.kafka.consumer.KafkaConsumerManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class PartyKafkaConsumerManager extends GenericKafkaConsumerManager<PartyGameStagePatchKafkaEvent> {

    private final PartyKafkaConsumerFactory partyKafkaConsumerFactory;

    @Override
    public GenericKafkaConsumerStrategy<PartyGameStagePatchKafkaEvent, ?, ?> getConsumer(Class<PartyGameStagePatchKafkaEvent> eventClass) {
        return partyKafkaConsumerFactory.getConsumer(eventClass);
    }
}
