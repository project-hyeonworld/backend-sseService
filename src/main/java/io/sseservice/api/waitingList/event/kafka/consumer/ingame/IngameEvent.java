package io.sseservice.api.waitingList.event.kafka.consumer.ingame;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.common.event.kafka.consumer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 23.
 */
public interface IngameEvent extends WaitingListEvent, Message {

}
