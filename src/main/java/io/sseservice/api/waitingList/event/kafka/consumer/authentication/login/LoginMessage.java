package io.sseservice.api.waitingList.event.kafka.consumer.authentication.login;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
public record LoginMessage (
    long userId,
    long partyId,
    String userName
) implements LoginEvent {

    public Class<LoginEvent> getEventClass() {
        return LoginEvent.class;
    }

    public static LoginMessage from(long userId, long partyId, String userName) {
        return new LoginMessage(userId, partyId, userName);
    }
}