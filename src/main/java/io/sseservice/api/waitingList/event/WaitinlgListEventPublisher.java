package io.sseservice.api.waitingList.event;

import io.sseservice.common.event.GenericEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
public class WaitinlgListEventPublisher extends GenericEventPublisher<WaitingListEvent> {

    protected WaitinlgListEventPublisher(ApplicationEventPublisher eventPublisher) {
        super(eventPublisher);
    }

    @Override
    public void execute(WaitingListEvent event) {
        publisher.publishEvent(event);
    }
}
