package io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame;

import io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.event.ExitGameEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumer;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
@Component
public class ExitGameKafkaConsumerManager extends GenericKafkaConsumerManager<ExitGameEvent> {

    private final GenericKafkaConsumer<ExitGameEvent, ?, ?> consumer;

    protected ExitGameKafkaConsumerManager(GenericKafkaConsumer<ExitGameEvent, ?, ?> consumer) {
        this.consumer = consumer;
    }


    @Override
    public List<ExitGameEvent> receive() {
        return consumer.receive();
    }
}
