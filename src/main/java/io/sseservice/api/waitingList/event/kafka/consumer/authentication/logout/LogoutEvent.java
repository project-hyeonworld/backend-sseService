package io.sseservice.api.waitingList.event.kafka.consumer.authentication.logout;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 14.
 */
public interface LogoutEvent<T extends Message> extends WaitingListEvent, Message {

}