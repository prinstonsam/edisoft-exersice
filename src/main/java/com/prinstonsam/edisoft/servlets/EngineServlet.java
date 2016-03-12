package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.Engine;
import com.prinstonsam.edisoft.service.EngineServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/engine")
public class EngineServlet extends HttpServlet {

    @EJB
    EngineServiceImpl engineService;

    protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            ServletException, IOException {
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        List<Engine> engines = engineService.getAll();

        httpServletRequest.setAttribute("engines", engines);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/engine.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest, httpServletResponse);

    }
}
