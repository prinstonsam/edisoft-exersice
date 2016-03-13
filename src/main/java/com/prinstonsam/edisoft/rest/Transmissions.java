package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.Transmission;
import com.prinstonsam.edisoft.service.TransmissionServiceImpl;
import com.prinstonsam.edisoft.service.TypeTransmissionServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/transmissions")
@Stateless
public class Transmissions {
    @EJB
    TransmissionServiceImpl transmissionService;

    @EJB
    TypeTransmissionServiceImpl typeTransmissionService;

    @GET
    @Path("json")
    @Produces("application/json")
    public List<Transmission> getTransmissionsJson() {
        return transmissionService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Transmission getTransmission(@PathParam("id") String id) {
        Transmission transmission = transmissionService.getById(Integer.parseInt(id));
        return transmission != null ? transmission : null;
    }

    @GET
    @Path("json/part")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transmission> getTransmissions(
            @QueryParam("page") int page,
            @QueryParam("countperpage") int coutPerPage) {
        List<Transmission> transmissions = transmissionService.getPartAll(page, coutPerPage);
        return transmissions;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transmission> queryFormParams(
            @FormParam("typetransmission") Integer typeTransmission,
            @FormParam("serialnumber") String serialNumber
     ) throws URISyntaxException {
        transmissionService.create(new Transmission(serialNumber, typeTransmissionService.getById(typeTransmission)));
        return getTransmissionsJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteTransmission(@PathParam("id") int id) {
        Transmission transmission = transmissionService.getById(id);
        if (transmission == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        transmissionService.delete(transmission);
    }
}
