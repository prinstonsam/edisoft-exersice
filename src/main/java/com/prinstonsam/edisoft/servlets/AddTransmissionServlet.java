package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.TypeTransmission;
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

@WebServlet(urlPatterns = "/addtransmission")
public class AddTransmissionServlet extends HttpServlet {

    @EJB
    TypeTransmissionServiceImpl typeTrasmissionService;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");

        List<TypeTransmission> typeTransmissions = typeTrasmissionService.getAll();

        httpServletRequest.setAttribute("typetransmissions", typeTransmissions);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/addformtransmission.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
