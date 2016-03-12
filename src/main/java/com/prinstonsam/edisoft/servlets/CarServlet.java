package com.prinstonsam.edisoft.servlets;

import com.prinstonsam.edisoft.model.Car;
import com.prinstonsam.edisoft.service.CarServiceImpl;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/car")
public class CarServlet extends HttpServlet{
    @EJB
    CarServiceImpl carService;

    public void processRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        List<Car> cars = carService.getAll();

        httpServletRequest.setAttribute("cars", cars);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/car.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        processRequest(httpServletRequest,httpServletResponse);
    }
}
