package io.sseservice.api.gameStage.event.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 2.
 */
public class PartyGameStagePatchKafkaEventDeserializer implements Deserializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PartyGameStagePatchKafkaEvent deserialize(String s, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, PartyGameStagePatchKafkaEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
