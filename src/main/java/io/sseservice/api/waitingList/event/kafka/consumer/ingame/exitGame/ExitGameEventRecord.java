package io.sseservice.api.waitingList.event.kafka.consumer.ingame.exitGame;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 25.
 */
public record ExitGameEventRecord (
        long partyId,
        String userName
){

}
