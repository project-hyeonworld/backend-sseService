package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.api.gameStage.event.GameStageEvent;
import io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage.PatchKafkaConsumerManager;
import io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage.PatchKafkaEvent;
import io.sseservice.common.event.GenericEventPublisher;
import io.sseservice.common.event.kafka.consumer.GenericKafkaReceiver;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
public class GameStageKafkaReceiver extends GenericKafkaReceiver<GameStageEvent> {

    private final PatchKafkaConsumerManager manager;
    private final GenericEventPublisher<GameStageEvent> eventPublisher;

    protected GameStageKafkaReceiver(
            PatchKafkaConsumerManager patchKafkaConsumerManager, GenericEventPublisher<GameStageEvent> eventPublisher) {
        this.manager = patchKafkaConsumerManager;
        this.eventPublisher = eventPublisher;
    }

    public void execute() {
        while (true) {
            handleEvents(manager.receive());
        }
    }

    @Override
    public void handleEvent(GameStageEvent event) {
        eventPublisher.execute(event);
    }

    private void handleEvents(List<PatchKafkaEvent> events) {
        for (PatchKafkaEvent event : events) {
            handleEvent(event);
        }
    }
}
