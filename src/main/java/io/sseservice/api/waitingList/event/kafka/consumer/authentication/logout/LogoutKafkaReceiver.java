package io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.common.event.GenericEventPublisher;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import io.sseservice.common.event.kafka.consumer.GenericKafkaReceiver;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 14.
 */
@Component
public class LogoutKafkaReceiver extends GenericKafkaReceiver<LogoutEvent> {

    private final GenericKafkaConsumerManager<LogoutEvent> manager;
    private final GenericEventPublisher<WaitingListEvent> publisher;

    protected LogoutKafkaReceiver(
            GenericKafkaConsumerManager<LogoutEvent> kafkaConsumerManager, GenericEventPublisher<WaitingListEvent> publisher) {
        this.manager = kafkaConsumerManager;
        this.publisher = publisher;
    }

    @Override
    protected void execute() {
        while (true) {
            handleEvents(manager.receive());
        }
    }

    private void handleEvents(List<LogoutEvent> events) {
        for (LogoutEvent event : events) {
            handleEvent(event);
        }
    }

    @Override
    public void handleEvent(LogoutEvent event) {
        publisher.execute(event);
    }
}