package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.api.gameStage.event.GameStageEventPublisher;
import io.sseservice.common.event.kafka.consumer.DefaultKafkaConsumerStrategy;
import io.sseservice.common.event.kafka.consumer.KafkaReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class PartyGameStagePatchKafkaReceiver implements KafkaReceiver<PartyGameStagePatchKafkaEvent> {

    private final PartyKafkaConsumerManager partyKafkaConsumerManager;
    private final GameStageEventPublisher eventPublisher;


    @Override
    public void execute() {
        DefaultKafkaConsumerStrategy consumer = partyKafkaConsumerManager.getConsumer(
                PartyGameStagePatchKafkaEvent.class);
        while (true) {
            handleEvents(consumer.receive());
        }
    }

    @Override
    public void handleEvent(PartyGameStagePatchKafkaEvent event) {
        eventPublisher.execute(event);
    }
}
