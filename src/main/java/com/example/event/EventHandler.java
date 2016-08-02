package com.example.event;

import com.example.event.helper.TypeResolver;

public interface EventHandler<T extends Event> {
    void handle(T event);

    default boolean canHandle(Object event) {
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(
                EventHandler.class, this.getClass());
        return typeArgs[0].isAssignableFrom(event.getClass());
    }
}
