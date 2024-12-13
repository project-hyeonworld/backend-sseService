package io.sseservice.api.waitingList.interfaces;

import io.sseservice.api.waitingList.event.WaitingListEvent;
import io.sseservice.common.event.GenericEventHandler;
import io.sseservice.common.event.GenericEventListener;
import java.util.List;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 13.
 */
@Component
public class WaitingListEventListener extends GenericEventListener<WaitingListEvent> {

    protected WaitingListEventListener(
            List<GenericEventHandler<? extends WaitingListEvent, WaitingListEvent>> genericEventHandlers) {
        super(genericEventHandlers);
    }

    @Override
    @EventListener
    public void handleEvent(WaitingListEvent event) {
        handlers.get(event.getEventClass()).handle(event);
    }
}
