package io.sseservice.api.waitingList.infrastructure;

import io.sseservice.api.waitingList.infrastructure.entity.Sse;
import io.sseservice.api.waitingList.infrastructure.jpa.SseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
@Repository
@Primary
@RequiredArgsConstructor
public class SseRepositoryImpl implements SseRepository {

    private final SseJpaRepository sseJpaRepository;

    public Sse save(Sse sse) {
        return sseJpaRepository.save(sse);
    }
}
