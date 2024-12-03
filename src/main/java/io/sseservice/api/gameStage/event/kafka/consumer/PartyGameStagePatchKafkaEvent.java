package io.sseservice.api.gameStage.event.kafka.consumer;

import io.sseservice.api.gameStage.event.GameStageEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
public record PartyGameStagePatchKafkaEvent (
        long partyId,
        byte gameStage
) implements GameStageEvent {

    public static PartyGameStagePatchKafkaEvent from(long partyId, byte gameStage) {
        return new PartyGameStagePatchKafkaEvent(partyId, gameStage);
    }
}
