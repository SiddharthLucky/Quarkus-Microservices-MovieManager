package com.microservice.Resource;


import com.microservice.Entity.Film;
import com.microservice.Repository.FilmRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.util.Optional;

@Path("/")
public class FilmResource {

    @Inject
    FilmRepository repository;

    @GET
    @Path("/helloworld")
    @RolesAllowed({"admin", "dev", "user", "reviewer"})
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }

    @GET
    @Path("/getFilm/{filmId}")
    @RolesAllowed({"admin", "dev", "user", "reviewer"})
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilm(@PathParam("filmId") Short filmId) {
        Optional<Film> film = repository.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "No Film Found.";
    }
}
