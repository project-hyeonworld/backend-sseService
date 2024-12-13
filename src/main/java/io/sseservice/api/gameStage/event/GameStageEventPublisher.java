package io.sseservice.api.gameStage.event;

import io.sseservice.common.event.GenericEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
public class GameStageEventPublisher extends GenericEventPublisher<GameStageEvent> {

    private final ApplicationEventPublisher applicationEventPublisher;

    protected GameStageEventPublisher(ApplicationEventPublisher publisher,
            ApplicationEventPublisher applicationEventPublisher) {
        super(publisher);
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void execute(GameStageEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
