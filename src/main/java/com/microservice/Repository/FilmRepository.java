package com.microservice.Repository;

import com.microservice.Entity.Actor;
import com.microservice.Entity.Actor$;
import com.microservice.Entity.Film;
import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.projection.Projection;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class FilmRepository {

    @Inject
    JPAStreamer jpaStreamer;

    public Optional<Film> getFilm(Short filmId) {
        return jpaStreamer.stream(Film.class)
                .filter(film -> Objects.equals(film.getId(), filmId))
                .findFirst();
    }
}
