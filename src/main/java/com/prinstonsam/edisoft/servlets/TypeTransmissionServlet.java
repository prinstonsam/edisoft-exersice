package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.TypeEngine;
import com.prinstonsam.edisoft.model.TypeTransmission;
import com.prinstonsam.edisoft.service.TypeService;
import com.prinstonsam.edisoft.service.TypeTransmissionServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by samsik on 05.03.16.
 */
@WebServlet(urlPatterns = "/typetransmission")
public class TypeTransmissionServlet extends HttpServlet {
    @EJB
//    TypeService<TypeTransmission> typeTransmissionService;
    TypeTransmissionServiceImpl typeTransmissionService;

    protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException{
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        List<TypeTransmission> typeTransmissions = typeTransmissionService.getAll();

        httpServletRequest.setAttribute("typetransmissions", typeTransmissions);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/typetransmission.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        processRequest(httpServletRequest, httpServletResponse);
    }
}
