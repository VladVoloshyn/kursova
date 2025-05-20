package org.example.kursova_robota.controller;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.kursova_robota.dao.CurrencyDao;
import org.example.kursova_robota.model.Currency;

@WebServlet(name = "controller", urlPatterns = {"/controller", "/index.jsp", "/admin/controller"})
public class CurrencyController extends HttpServlet {
    private CurrencyDao currencyDao;
    @Override
    public void init() throws ServletException {
        super.init();
        currencyDao = (CurrencyDao) getServletContext().getAttribute("currencyDao");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String command = request.getParameter("command");
        if (command == null) {
            command = "showTable";
        }
        Collection<Currency> currencies = currencyDao.findAll();
        switch (command) {
            case "edit":
                showEditForm(request, response);
            case "showTable":
                request.setAttribute("currencies", currencies);
                request.getRequestDispatcher("unidentified/dashboard.jsp").forward(request, response);
                break;
            case "showCurrency":
                Integer id = Integer.valueOf(request.getParameter("id"));
                Currency currency = currencyDao.findById(id);
                request.setAttribute("id", id);
                request.setAttribute("currency", currency);
                request.setAttribute("currencies", currencies);
                request.getRequestDispatcher("unidentified/aboutCurrency.jsp").forward(request, response);
            default:
                response.sendError(400, "Command is not found.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            response.sendError(400, "Command is not found.");
            return;
        }
        Collection<Currency> currencies = currencyDao.findAll();
        switch (command) {
            case "create":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "loginAsAdmin":
                request.setAttribute("currencies", currencies);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                break;
            default: response.sendError(400, "Command is not found.");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            currencyDao.deleteById(id);
            Collection<Currency> currencies = currencyDao.findAll();
            request.setAttribute("currencies", currencies);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(400, e.getMessage());
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            Currency currency = currencyDao.findById(id);
            request.setAttribute("editCurrency", currency);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(400, e.getMessage());
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        try {
            String currencyName = request.getParameter("currencyName");
            try {
                Double currencyPrice = Double.valueOf(request.getParameter("currencyPrice"));
                try {
                    LocalDate currencyDate = LocalDate.parse(request.getParameter("currencyDate"));
                    currencyDao.create(new Currency(currencyName, currencyPrice, currencyDate));
                    Collection<Currency> currencies = currencyDao.findAll();
                    request.setAttribute("currencies", currencies);
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                } catch (DateTimeParseException e) {
                    response.sendError(400, e.getMessage());
                }
            } catch (NumberFormatException e) {
                response.sendError(400, e.getMessage());
            }
        } catch (NullPointerException e) {
            response.sendError(400, e.getMessage());
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            String currencyName = request.getParameter("nameEditCurrency");
            try {
                try {
                    Double currencyPrice = Double.valueOf(request.getParameter("priceEditCurrency"));
                    LocalDate currencyDate = LocalDate.parse(request.getParameter("dateEditCurrency"));
                    currencyDao.update(new Currency(id, currencyName, currencyPrice, currencyDate));
                    Collection<Currency> currencies = currencyDao.findAll();
                    request.setAttribute("currencies", currencies);
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                } catch (DateTimeParseException e) {
                    response.sendError(400, e.getMessage());
                }
            } catch (NumberFormatException e) {
                response.sendError(400, e.getMessage());
            }
        } catch (NumberFormatException e) {
            response.sendError(400, e.getMessage());
        }
    }

}



