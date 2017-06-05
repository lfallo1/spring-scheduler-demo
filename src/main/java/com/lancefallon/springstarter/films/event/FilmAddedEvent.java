package com.lancefallon.springstarter.films.event;

import org.springframework.context.ApplicationEvent;

/**
 * FilmAddedEvent object
 * @author lfallon
 *
 */
public class FilmAddedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	/**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public FilmAddedEvent(Object source) {
        super(source);
    }
}