package io.sseservice.api.waitingList.event.kafka.consumer.authentication;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 12.
 */
public interface AuthenticationEvent extends WaitingListEvent, Message {

}
