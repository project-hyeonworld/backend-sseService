package io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout;

import io.sseservice.common.event.CustomEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 14.
 */
public record LogoutMessage(
        long partyId,
        String userName
) implements LogoutEvent, Message {

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return LogoutEvent.class;
    }

    public static LogoutMessage from(long partyId, String userName) {
        return new LogoutMessage(partyId, userName);
    }
}