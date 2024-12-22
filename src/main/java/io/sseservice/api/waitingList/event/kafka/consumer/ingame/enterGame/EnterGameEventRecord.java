package io.sseservice.api.waitingList.event.kafka.consumer.ingame.enterGame;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 22.
 */
public record EnterGameEventRecord (
        long partyId,
        String userName
){

}
