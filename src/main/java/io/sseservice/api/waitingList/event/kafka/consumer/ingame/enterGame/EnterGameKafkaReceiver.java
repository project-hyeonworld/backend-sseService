package io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame;

import io.sseservice.api.waitingList.event.WaitinlgListEventPublisher;
import io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout.LogoutEvent;
import io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame.event.EnterGameEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import io.sseservice.common.event.kafka.consumer.GenericKafkaReceiver;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 23.
 */
@Component
public class EnterGameKafkaReceiver extends GenericKafkaReceiver<EnterGameEvent> {

    private final GenericKafkaConsumerManager<EnterGameEvent> manager;
    private final WaitinlgListEventPublisher publisher;

    protected EnterGameKafkaReceiver(GenericKafkaConsumerManager<EnterGameEvent> manager,
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

    private void handleEvents(List<EnterGameEvent> events) {
        for (EnterGameEvent event : events) {
            handleEvent(event);
        }
    }

    @Override
    public void handleEvent(EnterGameEvent event) {
        publisher.execute(event);
    }
}
