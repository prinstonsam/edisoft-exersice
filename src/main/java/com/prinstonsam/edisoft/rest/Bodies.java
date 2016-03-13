package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.Body;
import com.prinstonsam.edisoft.service.BodyServiceImpl;
import com.prinstonsam.edisoft.service.TypeBodyServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/bodies")
@Stateless
public class Bodies {

    @EJB
    BodyServiceImpl bodyService;

    @EJB
    private TypeBodyServiceImpl typeBodyService;

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Body> getBodiesJson() {
        return bodyService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Body getBody(@PathParam("id") String id) {
        Body body = bodyService.getById(Integer.parseInt(id));
        return body != null ? body : null;
    }

    @GET
    @Path("json/part")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Body> getBodies(
            @QueryParam("page") int page,
            @QueryParam("countperpage") int countPerPage) {
        List<Body> bodies = bodyService.getPartAll(page, countPerPage);
        return bodies;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Body> queryFormParams(
            @FormParam("vin") String vin,
            @FormParam("color") String color,
            @FormParam("countdoors") Integer countDoors,
            @FormParam("typebody") Integer typeBody
            ) throws URISyntaxException {
        bodyService.create(new Body(vin, color, countDoors, typeBodyService.getById(typeBody)));
        return getBodiesJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteBody(@PathParam("id") int id) {
        Body body = bodyService.getById(id);
        if (body == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        bodyService.delete(body);
    }
}