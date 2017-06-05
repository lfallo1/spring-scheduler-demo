package com.lancefallon.springstarter.films.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import com.lancefallon.springstarter.config.event.CustomApplicationEventPublisher;

/**
 * publisher that handles publishing of film-added events events.
 * @author lfallon
 *
 */
@Component
public class FilmAddedEventPublisher extends CustomApplicationEventPublisher {

	@Override
    public void publish(ApplicationEvent event){
		//simply call super in this example
        super.publish(event);
    }
}