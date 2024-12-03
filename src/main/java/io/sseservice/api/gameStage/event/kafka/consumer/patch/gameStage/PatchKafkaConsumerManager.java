package io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage;

import io.sseservice.api.gameStage.event.GameStageEvent;
import io.sseservice.common.event.kafka.consumer.GenericKafkaConsumerManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class PatchKafkaConsumerManager extends GenericKafkaConsumerManager<GameStageEvent> {

    private final PatchKafkaConsumerFactory patchKafkaConsumerFactory;

}
