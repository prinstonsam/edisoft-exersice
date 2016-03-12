package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.Body;
import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.service.BodyServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/body")
public class BodyServlet extends HttpServlet {

    @EJB
    BodyServiceImpl bodyService;

    public void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        List<Body> bodies = bodyService.getAll();

        httpServletRequest.setAttribute("bodies", bodies);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/body.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        processRequest(httpServletRequest,httpServletResponse);
    }
}
