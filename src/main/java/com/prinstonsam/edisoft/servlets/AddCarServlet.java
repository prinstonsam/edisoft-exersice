package com.prinstonsam.edisoft.servlets;


import com.prinstonsam.edisoft.model.Body;
import com.prinstonsam.edisoft.model.Engine;
import com.prinstonsam.edisoft.model.Transmission;
import com.prinstonsam.edisoft.service.BodyServiceImpl;
import com.prinstonsam.edisoft.service.EngineServiceImpl;
import com.prinstonsam.edisoft.service.TransmissionServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addcar")
public class AddCarServlet extends HttpServlet {
    @EJB
    TransmissionServiceImpl trasmissionService;

    @EJB
    BodyServiceImpl bodyService;

    @EJB
    EngineServiceImpl engineService;


    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");

        List<Transmission> transmissions = trasmissionService.getFreeTransmission();

        List<Engine> engines = engineService.getFreeEngine();

        List<Body> bodies = bodyService.getFreeBody();


        httpServletRequest.setAttribute("transmissions", transmissions);
        httpServletRequest.setAttribute("engines", engines);
        httpServletRequest.setAttribute("bodies", bodies);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/addformcar.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
