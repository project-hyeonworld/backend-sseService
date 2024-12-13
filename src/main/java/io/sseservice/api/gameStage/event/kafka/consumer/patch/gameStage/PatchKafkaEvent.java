package io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage;

import io.sseservice.api.gameStage.event.GameStageEvent;
import io.sseservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
public record PatchKafkaEvent(
        long partyId,
        byte gameStage
) implements GameStageEvent {
    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return GameStageEvent.class;
    }

    public static PatchKafkaEvent from(long partyId, byte gameStage) {
        return new PatchKafkaEvent(partyId, gameStage);
    }
}
