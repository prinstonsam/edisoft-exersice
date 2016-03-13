package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.Car;
import com.prinstonsam.edisoft.service.BodyServiceImpl;
import com.prinstonsam.edisoft.service.CarServiceImpl;
import com.prinstonsam.edisoft.service.EngineServiceImpl;
import com.prinstonsam.edisoft.service.TransmissionServiceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("/cars")
@Stateless
public class Cars {
    @EJB
    CarServiceImpl carService;

    @EJB
    TransmissionServiceImpl trasmissionService;

    @EJB
    BodyServiceImpl bodyService;

    @EJB
    EngineServiceImpl engineService;

    @GET
    @Path("json")
    @Produces("application/json")
    public List<Car> getCarsJson() {
        return carService.getAll();
    }

    @GET
    @Path("json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") String id) {
        Car car = carService.getById(Integer.parseInt(id));
        return car != null ? car : null;
    }

    @GET
    @Path("json/part")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars(
            @QueryParam("page") int page,
            @QueryParam("countperpage") int coutPerPage) {
        List<Car> cars = carService.getPartAll(page, coutPerPage);
        return cars;
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> queryFormParams(
            @FormParam("serialnumber") String serialNumber,
            @FormParam("body") Integer bodyId,
            @FormParam("engine") Integer engineId,
            @FormParam("transmission") Integer tranmsissionId
    ) throws URISyntaxException {
        carService.create(new Car(
                serialNumber,
                trasmissionService.getById(tranmsissionId),
                engineService.getById(engineId),
                bodyService.getById(bodyId)));
        return getCarsJson();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteCar(@PathParam("id") int id) {
        Car car = carService.getById(id);
        if (car == null) throw new WebApplicationException(Response.Status.NOT_FOUND);
        carService.delete(car);
    }
}
