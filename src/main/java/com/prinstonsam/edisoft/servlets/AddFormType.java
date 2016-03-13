package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.*;
import com.prinstonsam.edisoft.service.*;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addformtype")
public class AddFormType extends HttpServlet {

    @EJB
    TypeBodyServiceImpl typeBodyService;

    @EJB
    TypeEngineServiceImpl typeEngineService;

    @EJB
    TypeTransmissionServiceImpl typeTransmissionService;

    @EJB
    BodyServiceImpl bodyService;

    @EJB
    EngineServiceImpl engineService;

    @EJB
    TransmissionServiceImpl transmissionService;

    @EJB
    CarServiceImpl carService;

    @Override
    protected void doPost(HttpServletRequest  httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        httpServletRequest.setCharacterEncoding("UTF-8");

        String typeForm = httpServletRequest.getParameter("addformtype");

        if (typeForm != null && typeForm.equals("typebody")) {
            typeBodyService.create(new TypeBody(httpServletRequest.getParameter("name")));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/typebody");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

        if (typeForm != null && typeForm.equals("typeengine")) {
            typeEngineService.create(new TypeEngine(httpServletRequest.getParameter("name")));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/typeengine");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

        if (typeForm != null && typeForm.equals("typetransmission")) {
            typeTransmissionService.create(new TypeTransmission(httpServletRequest.getParameter("name")));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/typetransmission");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

        if (typeForm != null && typeForm.equals("body")) {
            Body body = new Body();
            body.setColor(httpServletRequest.getParameter("color"));
            body.setCountDoors(Integer.parseInt(httpServletRequest.getParameter("countdoors")));
            body.setVin(httpServletRequest.getParameter("vin"));
            body.setTypeBody(typeBodyService.getById(
                    Integer.parseInt(httpServletRequest.getParameter("idtypebody"))));

            bodyService.create(body);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/body");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

        if (typeForm != null && typeForm.equals("engine")) {
            Engine engine = new Engine();
            engine.setSerialNumber(httpServletRequest.getParameter("serialnumber"));
            engine.setVolume(Float.parseFloat(httpServletRequest.getParameter("volume")));
            engine.setPower(Float.parseFloat(httpServletRequest.getParameter("power")));
            engine.setTypeEngine(typeEngineService.getById(
                    Integer.parseInt(httpServletRequest.getParameter("idtypeengine"))));

            engineService.create(engine);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/engine");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

        if (typeForm != null && typeForm.equals("transmission")) {
            Transmission transmission = new Transmission();
            transmission.setSerialNumber(httpServletRequest.getParameter("serialnumber"));
            transmission.setTypeTransmission(typeTransmissionService.getById(
                    Integer.parseInt(httpServletRequest.getParameter("idtypetransmission"))));

            transmissionService.create(transmission);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transmission");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

        if (typeForm != null && typeForm.equals("car")) {
            Car car = new Car();
            car.setSerialNumber(httpServletRequest.getParameter("serialnumber"));
            car.setEngine(engineService.getById(
                    Integer.parseInt(httpServletRequest.getParameter("idengine"))));
            car.setBody(bodyService.getById(
                    Integer.parseInt(httpServletRequest.getParameter("idbody"))));
            car.setTransmission(transmissionService.getById(
                    Integer.parseInt(httpServletRequest.getParameter("idtransmission"))));

            carService.create(car);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/car");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        }

    }
}
