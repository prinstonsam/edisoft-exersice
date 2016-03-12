package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.dao.Dao;
import com.prinstonsam.edisoft.model.TypeBody;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by samsik on 27.02.16.
 */
@WebServlet(urlPatterns = "/show")
public class SimpleServlet extends HttpServlet {
    @EJB
    private Dao<TypeBody> typeBodyDao;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");


        PrintWriter writer = httpServletResponse.getWriter();
        writer.println("before");

        TypeBody typeBody = typeBodyDao.getByName("универсал");

        writer.println("after");

        if (typeBody != null) {
            writer.println(typeBody);
        } else {
            writer.println("error typeBody");
        }
        writer.close();


    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {



    }

}
