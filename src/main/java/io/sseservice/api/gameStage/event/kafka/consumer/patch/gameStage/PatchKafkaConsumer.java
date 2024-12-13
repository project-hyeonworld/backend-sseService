package io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage;

import io.sseservice.common.annotation.Strategy;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
public class PatchKafkaConsumer extends
        GenericKafkaConsumer<PatchKafkaEvent, Long, Integer> {

    public PatchKafkaConsumer(@Value("${spring.kafka.broker.url}")String brokerUrl, @Value("${spring.kafka.topic.party-dashboard.game-stage.change}") String topic, @Value("${spring.application.name}") String groupId) {
        Properties props = new Properties();
        timeout = Duration.ofMillis(1000);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public Class<PatchKafkaEvent> getEventClass() {
        return PatchKafkaEvent.class;
    }

    @Override
    public List<PatchKafkaEvent> receive() {
        List<PatchKafkaEvent> events = new ArrayList<>();
        ConsumerRecords<Long, Integer> records = consume();
        for (ConsumerRecord<Long, Integer> record : records) {
            events.add(convertToEvent(record));
        }
        return events;
    }

    protected ConsumerRecords<Long, Integer> consume() {
        return kafkaConsumer.poll(timeout);
    }

    @Override
    protected PatchKafkaEvent convertToEvent(ConsumerRecord<Long, Integer> record) {
        return PatchKafkaEvent.from(record.key(), record.value().byteValue());
    }
}
