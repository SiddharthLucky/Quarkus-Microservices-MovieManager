package com.microservice.Resource;


import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;

@Path("/")
public class FilmResource {

    @GET
    @Path("/helloworld")
    @RolesAllowed({"admin", "dev", "user", "reviewer"})
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }
}
