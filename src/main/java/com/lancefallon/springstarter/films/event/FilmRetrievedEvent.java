package com.lancefallon.springstarter.films.event;

import org.springframework.context.ApplicationEvent;

public class FilmRetrievedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	/**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public FilmRetrievedEvent(Object source) {
        super(source);
    }
}