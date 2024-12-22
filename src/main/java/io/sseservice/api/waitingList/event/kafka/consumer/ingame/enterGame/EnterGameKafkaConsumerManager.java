package io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event.EnterGameEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumer;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 23.
 */
@Component
public class EnterGameKafkaConsumerManager extends GenericKafkaConsumerManager<EnterGameEvent> {

    private final GenericKafkaConsumer<EnterGameEvent, ?, ?> consumer;

    protected EnterGameKafkaConsumerManager(GenericKafkaConsumer<EnterGameEvent, ?, ?> consumer) {
        this.consumer = consumer;
    }

    @Override
    public List<EnterGameEvent> receive() {
        return consumer.receive();
    }
}
