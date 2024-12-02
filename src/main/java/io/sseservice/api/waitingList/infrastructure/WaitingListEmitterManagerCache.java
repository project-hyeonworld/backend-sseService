package io.sseservice.api.waitingList.infrastructure;

import io.sseservice.api.waitingList.domain.dto.WaitingListEmitterManager;
import io.sseservice.common.EmitterManagerCache;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 3.
 */
@Component
public class WaitingListEmitterManagerCache extends EmitterManagerCache<WaitingListEmitterManager> {
}
