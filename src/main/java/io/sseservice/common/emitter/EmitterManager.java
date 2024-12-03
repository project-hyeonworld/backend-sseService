package io.sseservice.common.emitter;

import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface EmitterManager<T extends CustomEmitter> {

    T create(long userId);

    void add(long userId);

    void remove(long userId);

    T get(long userId);

    T retrieve(long userId);

}
