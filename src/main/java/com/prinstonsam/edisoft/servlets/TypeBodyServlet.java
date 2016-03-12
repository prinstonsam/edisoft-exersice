package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.service.TypeBodyService;
import org.apache.commons.lang3.StringUtils;

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
 * Created by samsik on 29.02.16.
 */
@WebServlet(urlPatterns = "/typebody")
public class TypeBodyServlet extends HttpServlet {

    @EJB
    TypeBodyService typeBodyService;

    protected void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException{
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        List<TypeBody> typeBodies = typeBodyService.getAll();

        httpServletRequest.setAttribute("typebodies", typeBodies);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/typebody.jsp");
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
