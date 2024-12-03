package io.sseservice.common.event.kafka.producer;

import io.sseservice.common.event.EventPublisher;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 1.
 */
public interface KafkaSender<E> extends EventPublisher<E> {
}
