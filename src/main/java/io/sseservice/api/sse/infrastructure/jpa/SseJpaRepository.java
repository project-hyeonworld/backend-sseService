package io.sseservice.api.sse.infrastructure.jpa;

import io.sseservice.api.sse.infrastructure.entity.Sse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface SseJpaRepository extends JpaRepository<Sse, Long> {

}
