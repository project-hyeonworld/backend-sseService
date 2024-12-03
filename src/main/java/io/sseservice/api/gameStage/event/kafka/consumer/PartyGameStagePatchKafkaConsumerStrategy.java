package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.common.annotation.Strategy;
import io.sseservice.common.event.kafka.consumer.DefaultKafkaConsumerStrategy;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Strategy(4)
public class PartyGameStagePatchKafkaConsumerStrategy extends DefaultKafkaConsumerStrategy<PartyGameStagePatchKafkaEvent, String, PartyGameStagePatchKafkaEvent> {

    public PartyGameStagePatchKafkaConsumerStrategy(@Value("${spring.kafka.broker.url}")String brokerUrl, @Value("${spring.kafka.topic.party-dashboard.game-stage.change}") String topic, @Value("${spring.application.name}") String groupId) {
        Properties props = new Properties();
        timeout = Duration.ofMillis(1000);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 10);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, PartyGameStagePatchKafkaEventDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public Class<PartyGameStagePatchKafkaEvent> getEventClass() {
        return PartyGameStagePatchKafkaEvent.class;
    }

    @Override
    protected PartyGameStagePatchKafkaEvent convertToEvent(PartyGameStagePatchKafkaEvent value) {
        return value;
    }
}
