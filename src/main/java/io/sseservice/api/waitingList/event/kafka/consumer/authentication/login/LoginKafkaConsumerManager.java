package io.sseservice.api.waitingList.event.kafka.consumer.authentication.login;

import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumer;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
@Component
public class LoginKafkaConsumerManager extends GenericKafkaConsumerManager<LoginEvent> {

    private final GenericKafkaConsumer<LoginEvent, ?, ?> consumer;

    public LoginKafkaConsumerManager(GenericKafkaConsumer<LoginEvent, ?, ?> consumer) {
        this.consumer = consumer;
    }


    @Override
    public List<LoginEvent> receive() {
        return consumer.receive();
    }
}
