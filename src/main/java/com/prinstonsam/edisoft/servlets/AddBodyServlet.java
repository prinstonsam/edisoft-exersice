package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.service.TypeBodyServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addbody")
public class AddBodyServlet extends HttpServlet {
    @EJB
    TypeBodyServiceImpl typeBodyService;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setCharacterEncoding("UTF-8");

        List<TypeBody> typeBodies = typeBodyService.getAll();

        httpServletRequest.setAttribute("typebodies", typeBodies);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/addformbody.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
