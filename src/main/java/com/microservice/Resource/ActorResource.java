package com.microservice.Resource;

import com.microservice.Entity.Actor;
import com.microservice.Repository.ActorRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/actor")
public class ActorResource {

    @Inject
    ActorRepository actorRepository;

    @GET
    @Path("/getActor_stream/{actorName}")
    @RolesAllowed({"admin", "dev", "user"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getActors_Stream(@PathParam("actorName") String actorName) {
        Optional<List<Actor>> actorsList = Optional.of(actorRepository.getActors_Stream(actorName));
        return actorsList.orElseGet(ArrayList::new);
    }

    @GET
    @Path("/getActor_projection/{actorName}")
    @RolesAllowed({"admin", "dev", "user"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getActors_Projection(@PathParam("actorName") String actorName) {
        Optional<List<Actor>> actorsList = Optional.of(actorRepository.getActors_Projection(actorName));
        List<String> actorNames = new ArrayList<>();
        for(Actor actor: actorsList.get()) {
            actorNames.add(actor.getFirstName() + " " + actor.getLastName());
        }
        return actorNames;
    }
}
