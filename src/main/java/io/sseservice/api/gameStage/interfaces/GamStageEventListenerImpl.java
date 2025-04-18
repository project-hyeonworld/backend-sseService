package io.sseservice.api.gameStage.interfaces;

import io.sseservice.api.gameStage.domain.GameStageService;
import io.sseservice.api.gameStage.event.GameStageEvent;
import io.sseservice.api.gameStage.event.kafka.consumer.patch.gameStage.PatchKafkaEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
@RequiredArgsConstructor
public class GamStageEventListenerImpl implements GameStageEventListener{

    private final GameStageService gameStageService;

    @Override
    @EventListener
    public void handleEvent(GameStageEvent event) {
        if (event instanceof PatchKafkaEvent) {
            handleEventBy((PatchKafkaEvent) event);
        }
    }

    private void handleEventBy(PatchKafkaEvent event) {
        gameStageService.sendGameStage(event.partyId(), event.gameStage());
    }
}
