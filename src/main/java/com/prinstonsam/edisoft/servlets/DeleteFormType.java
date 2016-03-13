package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.service.TypeBodyServiceImpl;
import com.prinstonsam.edisoft.service.TypeEngineServiceImpl;
import com.prinstonsam.edisoft.service.TypeTransmissionServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteformtype")
public class DeleteFormType extends HttpServlet {
    @EJB
    TypeBodyServiceImpl typeBodyService;

    @EJB
    TypeEngineServiceImpl typeEngineService;

    @EJB
    TypeTransmissionServiceImpl typeTransmissionService;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException
    {
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        httpServletRequest.setCharacterEncoding("UTF-8");

        String typeForm = httpServletRequest.getParameter("type");

        String pageResult="/jsp/unknownerror.jsp";

        if (typeForm != null && StringUtils.isNotEmpty(typeForm) && typeForm.equals("typebody")) {

            Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));

            typeBodyService.delete(typeBodyService.getById(id));

            httpServletRequest.setAttribute("typepart","typebody");
            httpServletRequest.setAttribute("typeaction","delete");
            pageResult = "/jsp/pageresult.jsp";
        }

        if (typeForm != null && StringUtils.isNotEmpty(typeForm) && typeForm.equals("typeengine")) {

            Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));

            typeEngineService.delete(typeEngineService.getById(id));

            httpServletRequest.setAttribute("typepart","typeengine");
            httpServletRequest.setAttribute("typeaction","delete");
            pageResult = "/jsp/pageresult.jsp";
        }

        if (typeForm != null && StringUtils.isNotEmpty(typeForm) && typeForm.equals("typetransmission")) {

            Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));

            typeTransmissionService.delete(typeTransmissionService.getById(id));

            httpServletRequest.setAttribute("typepart","typetransmission");
            httpServletRequest.setAttribute("typeaction","delete");
            pageResult = "/jsp/pageresult.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pageResult);
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }


}
