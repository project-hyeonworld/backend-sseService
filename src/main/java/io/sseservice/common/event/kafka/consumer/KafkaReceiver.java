package io.sseservice.common.event.kafka.consumer;

import io.sseservice.common.event.CustomEvent;
import io.sseservice.common.event.EventListener;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 1.
 */
public interface KafkaReceiver<E extends CustomEvent> extends EventListener<E> {
}
