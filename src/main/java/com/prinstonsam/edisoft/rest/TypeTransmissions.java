package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.TypeTransmission;
import com.prinstonsam.edisoft.service.TypeTransmissionServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/typetransmissions")
@Stateless
public class TypeTransmissions {

    @EJB
    TypeTransmissionServiceImpl typeTransmissionService;

    @GET
    @Path("json")
    @Produces("application/json")
    public List<TypeTransmission> getTypeTransmissionJson() {
        return typeTransmissionService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TypeTransmission getTypeTransmission(@PathParam("id") String id) {
        TypeTransmission typeTransmission = typeTransmissionService.getById(Integer.parseInt(id));
        return typeTransmission != null ? typeTransmission : null;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeTransmission> queryFormParams(@FormParam("name") String name) throws URISyntaxException {
        typeTransmissionService.create(new TypeTransmission(name));
        return getTypeTransmissionJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteTypeTransmission(@PathParam("id") int id) {
        TypeTransmission typeTransmission = typeTransmissionService.getById(id);
        if (typeTransmission == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        typeTransmissionService.delete(typeTransmission);
    }
}
