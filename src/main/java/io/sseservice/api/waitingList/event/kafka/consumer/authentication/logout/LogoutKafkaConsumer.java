package io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 14.
 */
@Component
public class LogoutKafkaConsumer extends GenericKafkaConsumer<LogoutEvent, Long, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public LogoutKafkaConsumer(@Value("${spring.kafka.broker.url}")String brokerUrl, @Value("${spring.kafka.topic.session.authentication.log-out}")String topic, @Value("${spring.application.name}") String groupId) {
        timeout = Duration.ofMillis(1000);
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerUrl);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Collections.singletonList(topic));
    }

    @Override
    public Class<LogoutEvent> getEventClass() {
        return LogoutEvent.class;
    }

    @Override
    public List<LogoutEvent> receive() {
        List<LogoutEvent> events = new ArrayList<>();
        ConsumerRecords<Long, String> records = consume();
        for (ConsumerRecord<Long, String> record : records) {
            events.add(convertToEvent(record));
        }
        return events;
    }

    @Override
    protected LogoutEvent convertToEvent(ConsumerRecord<Long, String> record) {
        try {
            LogoutEventRecord logoutEventRecord = objectMapper.readValue(record.value(), LogoutEventRecord.class);
            return LogoutMessage.from(logoutEventRecord.partyId(), logoutEventRecord.userName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
