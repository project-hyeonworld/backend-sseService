package io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame;

import io.sseservice.api.waitingList.event.WaitinlgListEventPublisher;
import io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame.event.ExitGameEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import io.sseservice.common.event.kafka.consumer.GenericKafkaReceiver;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
@Component
public class ExitGameKafkaReceiver extends GenericKafkaReceiver<ExitGameEvent> {

    private final GenericKafkaConsumerManager<ExitGameEvent> manager;
    private final WaitinlgListEventPublisher publisher;

    protected ExitGameKafkaReceiver (GenericKafkaConsumerManager<ExitGameEvent> manager,
            WaitinlgListEventPublisher publisher) {
        this.manager = manager;
        this.publisher = publisher;
    }

    @Override
    protected void execute() {
        while (true) {
            handleEvents(manager.receive());
        }
    }

    private void handleEvents(List<ExitGameEvent> events) {
        for (ExitGameEvent event : events) {
            handleEvent(event);
        }
    }

    @Override
    public void handleEvent(ExitGameEvent event) {
        publisher.execute(event);
    }
}
