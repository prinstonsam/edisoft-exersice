package com.prinstonsam.edisoft.rest;

import com.prinstonsam.edisoft.model.Car;
import com.prinstonsam.edisoft.service.CarServiceImpl;

import javax.ejb.EJB;
/*import javax.json.Json;
import javax.json.JsonArrayBuilder;*/
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/cars")
public class Cars {
    @EJB
    CarServiceImpl carService;

/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
*/
    @GET
//    @Path("/print/{name}")
    @Produces("application/json")
//    public Response getCars() {
//        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
//
//        for (Car car : carService.getAll()) {
//            jsonArrayBuilder.add(Json.createObjectBuilder()
//                    .add("id", car.getId())
//                    .add("serialnumber", car.getSerialNumber())
//                    .add("body", car.getBody().getId())
//                    .add("transmission", car.getTransmission().getId())
//                    .add("engine", car.getEngine().getId())
//            );
//        }
    public List<Car> getCars() {

        return carService.getAll();
//        return Response.ok(jsonArrayBuilder.build()).build();

    }
}
