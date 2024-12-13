package io.sseservice.api.waitingList.event.kafka.consumer.authentication.login;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.common.event.GenericEventPublisher;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import io.sseservice.common.event.kafka.consumer.GenericKafkaReceiver;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
@Component
public class LoginKafkaReceiver extends GenericKafkaReceiver<LoginEvent> {

    private final GenericKafkaConsumerManager<LoginEvent> manager;
    private final GenericEventPublisher<WaitingListEvent> publisher;

    protected LoginKafkaReceiver(
            GenericKafkaConsumerManager<LoginEvent> kafkaConsumerManager, GenericEventPublisher<WaitingListEvent> publisher) {
        this.manager = kafkaConsumerManager;
        this.publisher = publisher;
    }

    @Override
    protected void execute() {
        while(true) {
            handleEvents(manager.receive());
        }
    }

    private void handleEvents(List<LoginEvent> events) {
        for (LoginEvent event : events) {
            handleEvent(event);
        }
    }

    @Override
    public void handleEvent(LoginEvent event) {
        publisher.execute(event);
    }
}
