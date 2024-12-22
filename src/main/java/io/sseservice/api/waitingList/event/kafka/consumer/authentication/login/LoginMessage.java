package io.sseservice.api.waitingList.event.kafka.consumer.authentication.login;

import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
public record LoginMessage (
    long partyId,
    String userName
) implements LoginEvent, Message {

    public Class<LoginEvent> getEventClass() {
        return LoginEvent.class;
    }

    public static LoginMessage from(long partyId, String userName) {
        return new LoginMessage(partyId, userName);
    }
}