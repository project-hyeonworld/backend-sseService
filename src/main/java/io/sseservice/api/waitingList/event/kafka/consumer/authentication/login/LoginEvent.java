package io.sseservice.api.waitingList.event.kafka.consumer.authentication.login;

import io.sseservice.api.waitingList.event.kafka.consumer.authentication.AuthenticationEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 12.
 */
public interface LoginEvent<T extends Message> extends AuthenticationEvent, Message {

}
