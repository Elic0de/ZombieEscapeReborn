package com.github.elic0de.zombieEscape.minigame.event;

/**
 * Central dispatcher for events.
 * It registers listeners and dispatches events to them.
 */
public class EventDispatcher<T extends Event> {
    private final Map<Class<? extends Event>, Set<EventListener<T>>> listeners = new HashMap<>();

    /**
     * Registers an event listener for a specific event class.
     */
    public void register(Class<? extends Event> eventClass, EventListener<T> listener) {
        listeners.computeIfAbsent(eventClass, k -> new HashSet<>()).add(listener);
    }

    /**
     * Dispatches the event to all registered listeners.
     */
    public void dispatch(T event) {
        Class<? extends Event> eventClass = event.getClass();
        if (listeners.containsKey(eventClass)) {
            for (EventListener<T> listener : listeners.get(eventClass)) {
                listener.onEvent(event);
            }
        }
    }

    /**
     * Simple event listener interface.
     */
    public interface EventListener<T extends Event> {
        void onEvent(T event);
    }
}
