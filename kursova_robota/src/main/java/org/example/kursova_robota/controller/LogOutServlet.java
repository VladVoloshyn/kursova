package org.example.kursova_robota.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.kursova_robota.dao.CurrencyDao;
import org.example.kursova_robota.model.Currency;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "LogOutServlet", urlPatterns = {"/admin/logout"})
public class LogOutServlet extends HttpServlet{
    private CurrencyDao currencyDao;
    @Override
    public void init() throws ServletException {
        super.init();
        currencyDao = (CurrencyDao) getServletContext().getAttribute("currencyDao");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Collection<Currency> currencies = currencyDao.findAll();
        request.getSession().invalidate();
        request.setAttribute("currencies", currencies);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);


    }
}


