package com.prinstonsam.edisoft.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


@Path("/users")
public class User1
{

    @GET
    public Response getUsers() {
        return Response.status(200).entity("Hello").build();
    }

    public User1() {
    }
}
