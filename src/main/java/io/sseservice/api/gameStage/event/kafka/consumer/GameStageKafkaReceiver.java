package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.api.gameStage.event.GameStageEventPublisher;
import io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage.PatchKafkaConsumerManager;
import io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage.PatchKafkaEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerStrategy;
import io.sseservice.common.event.kafka.consumer.KafkaReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class GameStageKafkaReceiver implements KafkaReceiver<PatchKafkaEvent> {

    private final PatchKafkaConsumerManager patchKafkaConsumerManager;
    private final GameStageEventPublisher eventPublisher;


    @Override
    public void execute() {
        GenericKafkaConsumerStrategy consumer = patchKafkaConsumerManager.getConsumer(
                PatchKafkaEvent.class);
        while (true) {
            handleEvents(consumer.receive());
        }
    }

    @Override
    public void handleEvent(PatchKafkaEvent event) {
        eventPublisher.execute(event);
    }
}
