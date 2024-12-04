package io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage;

import io.sseservice.api.gameStage.event.GameStageEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerFactory;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
public class PatchKafkaConsumerManager extends GenericKafkaConsumerManager<GameStageEvent> {

    public PatchKafkaConsumerManager(
            GenericKafkaConsumerFactory<GameStageEvent> genericKafkaConsumerFactory) {
        super(genericKafkaConsumerFactory);
    }
}
