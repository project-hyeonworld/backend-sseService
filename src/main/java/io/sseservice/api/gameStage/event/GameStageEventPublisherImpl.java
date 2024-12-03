package io.sseservice.api.gameStage.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class GameStageEventPublisherImpl implements GameStageEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void execute(GameStageEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
