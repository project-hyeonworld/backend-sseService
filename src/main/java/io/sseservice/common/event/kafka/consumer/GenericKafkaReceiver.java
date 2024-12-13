package io.sseservice.common.event.kafka.consumer;

import io.sseservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 8.
 */
public abstract class GenericKafkaReceiver<E extends CustomEvent> implements KafkaReceiver<E> {

    protected abstract void execute();
    public abstract void handleEvent(E event);

}
