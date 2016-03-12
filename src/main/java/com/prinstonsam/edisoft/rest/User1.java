package com.prinstonsam.edisoft.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by samsik on 08.03.16.
 */
@Path("/users")
public class User1
        //extends Application
{

    @GET
    public Response getUsers() {
        return Response.status(200).entity("Hello").build();
    }
}
