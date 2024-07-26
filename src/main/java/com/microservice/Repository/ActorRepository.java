package com.microservice.Repository;

import com.microservice.Entity.Actor;
import com.microservice.Entity.Actor$;
import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.projection.Projection;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ActorRepository {

    @Inject
    JPAStreamer jpaStreamer;

    public List<Actor> getActors_Stream(String actorFirstName) {
        StreamConfiguration<Actor> actors = StreamConfiguration.of(Actor.class)
                .joining(Actor$.films);

        return jpaStreamer.stream(actors)
                .filter(Actor$.firstName.equalIgnoreCase(actorFirstName)).toList();
    }

    public List<Actor> getActors_Projection(String actorFirstName) {
        return jpaStreamer.stream(Projection.select(Actor$.id, Actor$.firstName, Actor$.lastName))
                .filter(Actor$.firstName.equalIgnoreCase(actorFirstName)).toList();
    }
}
