package io.sseservice.api.waitingList.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sse")
public class Sse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long partyId;

    public static SseBuilder defaultBuilder(){
        return Sse.builder();
    }
}
