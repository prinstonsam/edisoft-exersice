package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.service.TypeBodyServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/typebodies")
@Stateless
public class TypeBodies {

    @EJB
    private TypeBodyServiceImpl typeBodyService;

    @GET
    @Path("xml")
    @Produces("application/xml")
    public List<TypeBody> getTypeBodiesXml() {
        return typeBodyService.getAll();
    }

    @GET
    @Path("json")
    @Produces("application/json")
    public List<TypeBody> getTypeBodiesJson() {
        return typeBodyService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TypeBody getTypeBody(@PathParam("id") String id) {
        TypeBody typeBody = typeBodyService.getById(Integer.parseInt(id));
        return typeBody != null ? typeBody : null;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)

    public List<TypeBody> queryFormParams(@FormParam("name") String name) throws URISyntaxException {
        typeBodyService.create(new TypeBody(name));
        return getTypeBodiesJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteTypeBody(@PathParam("id") int id) {
        TypeBody typeBody = typeBodyService.getById(id);
        if (typeBody == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        typeBodyService.delete(typeBody);
    }




    //Example for XML impl
    @GET
    @Path("xml2")
    @Produces(MediaType.APPLICATION_XML)
    public List<TypeBody> getTypeBodiesXml2() {
        return typeBodyService.getAll();
    }
}
