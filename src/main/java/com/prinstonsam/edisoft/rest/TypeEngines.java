package com.prinstonsam.edisoft.rest;


import com.prinstonsam.edisoft.model.TypeEngine;
import com.prinstonsam.edisoft.service.TypeEngineServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/typeengines")
@Stateless
public class TypeEngines {

    @EJB
    TypeEngineServiceImpl typeEngineService;

    @GET
    @Path("json")
    @Produces("application/json")
    public List<TypeEngine> getTransmissionJson() {
        return typeEngineService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TypeEngine getTypeEngine(@PathParam("id") String id) {
        TypeEngine typeEngine = typeEngineService.getById(Integer.parseInt(id));
        return typeEngine != null ? typeEngine : null;
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public List<TypeEngine> getTypeEnginesJson() {
        return typeEngineService.getAll();
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeEngine> queryFormParams(@FormParam("name") String name) throws URISyntaxException {
        typeEngineService.create(new TypeEngine(name));
        return getTypeEnginesJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteTypeEngine(@PathParam("id") int id) {
        TypeEngine typeEngine = typeEngineService.getById(id);
        if (typeEngine == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        typeEngineService.delete(typeEngine);
    }
}
