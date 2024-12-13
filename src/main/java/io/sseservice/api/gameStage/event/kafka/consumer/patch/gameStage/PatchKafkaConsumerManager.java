package io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage;

import io.sseservice.api.gameStage.event.GameStageEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumer;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerFactory;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
public class PatchKafkaConsumerManager extends GenericKafkaConsumerManager<PatchKafkaEvent> {

    private final GenericKafkaConsumer<PatchKafkaEvent, ?, ?> consumer;

    public PatchKafkaConsumerManager(GenericKafkaConsumer<PatchKafkaEvent, ?, ?> consumer) {
        this.consumer = consumer;
    }

    @Override
    public List<PatchKafkaEvent> receive() {
        return consumer.receive();
    }
}
