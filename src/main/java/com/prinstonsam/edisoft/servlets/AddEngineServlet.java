package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.model.TypeEngine;
import com.prinstonsam.edisoft.service.TypeEngineServiceImpl;

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
 * Created by samsik on 07.03.16.
 */
@WebServlet(urlPatterns = "/addengine")
public class AddEngineServlet extends HttpServlet {

    @EJB
    TypeEngineServiceImpl typeEngineService;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");

        List<TypeEngine> typeEngines = typeEngineService.getAll();

        httpServletRequest.setAttribute("typeengines", typeEngines);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/addformengine.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
