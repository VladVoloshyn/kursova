package org.example.kursova_robota.web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.example.kursova_robota.dao.CurrencyDao;
import org.example.kursova_robota.dao.MemoryCurrencyDao;
import org.example.kursova_robota.util.Database;
public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        CurrencyDao currencyDao = new MemoryCurrencyDao();
        Database.createDatabase(currencyDao);
        sce.getServletContext().setAttribute("currencyDao", currencyDao);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}

