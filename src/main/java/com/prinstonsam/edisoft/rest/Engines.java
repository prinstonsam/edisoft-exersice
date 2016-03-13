
package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.Engine;
import com.prinstonsam.edisoft.service.EngineServiceImpl;
import com.prinstonsam.edisoft.service.TypeEngineServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/engines")
@Stateless
public class Engines {

    @EJB
    EngineServiceImpl engineService;

    @EJB
    TypeEngineServiceImpl typeEngineService;

    @GET
    @Path("json")
    @Produces("application/json")
    public List<Engine> getEnginesJson() {
        return engineService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Engine getEngine(@PathParam("id") String id) {
        Engine engine = engineService.getById(Integer.parseInt(id));
        return engine != null ? engine : null;
    }

    @GET
    @Path("json/part")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Engine> getEngines(
            @QueryParam("page") int page,
            @QueryParam("countperpage") int coutPerPage) {
        List<Engine> engines = engineService.getPartAll(page, coutPerPage);
        return engines;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Engine> queryFormParams(
            @FormParam("serialnumber") String serialNumber,
            @FormParam("volume") Float volume,
            @FormParam("power") Float power,
            @FormParam("typeengine") Integer typeEngine
    ) throws URISyntaxException {
        engineService.create(new Engine(serialNumber, volume, power, typeEngineService.getById(typeEngine)));
        return getEnginesJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteEngine(@PathParam("id") int id) {
        Engine engine = engineService.getById(id);
        if (engine == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        engineService.delete(engine);
    }
}
