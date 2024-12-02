package io.sseservice.api.sse.interfaces;

import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 14.
 */
public interface EmitterManager<T extends CustomEmitter, TCollection extends CustomEmitters<T>> {

    T create(long userId);

    void add(long userId);

    void remove(long userId);

    T get(long userId);

    T retrieve(long userId);

    List<T> get();

    void set(List<T> emitters);

    void set(List<Long> userIds, List<T> emitters);



}
