package io.sseservice.api.waitingList.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 4.
 */
@Component
@RequiredArgsConstructor
public class WaitinlgListEventPublisherImpl implements WaitingListEventPublisher{

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void execute(WaitingListEvent event) {
        eventPublisher.publishEvent(event);
    }
}
