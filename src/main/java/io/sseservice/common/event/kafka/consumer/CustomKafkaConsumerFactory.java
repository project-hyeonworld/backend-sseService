package io.sseservice.common.event.kafka.consumer;

import io.sseservice.common.annotation.StrategyFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 2.
 */
@StrategyFactory
public class CustomKafkaConsumerFactory {
    private final Map<String, DefaultKafkaConsumerStrategy> strategies;

    public CustomKafkaConsumerFactory(List<DefaultKafkaConsumerStrategy> kafkaConsumerStrategies) {
        this.strategies = new HashMap<>();
        for (DefaultKafkaConsumerStrategy kafkaConsumerStrategy : kafkaConsumerStrategies) {
            strategies.put(kafkaConsumerStrategy.getEventName(), kafkaConsumerStrategy);
        }
    }

    public DefaultKafkaConsumerStrategy getConsumer(Class eventClass) {
        return strategies.get(eventClass.getName());
    }
}


