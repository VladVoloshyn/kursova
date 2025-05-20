package org.example.kursova_robota.util;

import org.example.kursova_robota.dao.CurrencyDao;
import org.example.kursova_robota.model.Currency;

import java.time.LocalDate;

public class Database {
    public static void createDatabase(CurrencyDao currencyDao) {

        currencyDao.create(new Currency("USD", 41.4709, LocalDate.now()));
        currencyDao.create(new Currency("EUR", 46.3831, LocalDate.now()));
        currencyDao.create(new Currency("JPY", 0.2840, LocalDate.now()));
        currencyDao.create(new Currency("GBP", 55.0362, LocalDate.now()));
        currencyDao.create(new Currency("CAD", 29.6560, LocalDate.now()));
        currencyDao.create(new Currency("NZD", 24.3600, LocalDate.now()));

        currencyDao.create(new Currency("USD", 41.54, LocalDate.of(2025, 5, 17)));
        currencyDao.create(new Currency("EUR", 46.40, LocalDate.of(2025, 5, 17)));
        currencyDao.create(new Currency("JPY", 0.283, LocalDate.of(2025, 5, 17)));
        currencyDao.create(new Currency("GBP", 55.10, LocalDate.of(2025, 5, 17)));
        currencyDao.create(new Currency("CAD", 29.65, LocalDate.of(2025, 5, 17)));
        currencyDao.create(new Currency("NZD", 24.35, LocalDate.of(2025, 5, 17)));

        currencyDao.create(new Currency("USD", 41.50, LocalDate.of(2025, 5, 16)));
        currencyDao.create(new Currency("EUR", 46.35, LocalDate.of(2025, 5, 16)));
        currencyDao.create(new Currency("JPY", 0.282, LocalDate.of(2025, 5, 16)));
        currencyDao.create(new Currency("GBP", 55.00, LocalDate.of(2025, 5, 16)));
        currencyDao.create(new Currency("CAD", 29.60, LocalDate.of(2025, 5, 16)));
        currencyDao.create(new Currency("NZD", 24.30, LocalDate.of(2025, 5, 16)));

        currencyDao.create(new Currency("USD", 41.48, LocalDate.of(2025, 5, 15)));
        currencyDao.create(new Currency("EUR", 46.30, LocalDate.of(2025, 5, 15)));
        currencyDao.create(new Currency("JPY", 0.281, LocalDate.of(2025, 5, 15)));
        currencyDao.create(new Currency("GBP", 54.90, LocalDate.of(2025, 5, 15)));
        currencyDao.create(new Currency("CAD", 29.55, LocalDate.of(2025, 5, 15)));
        currencyDao.create(new Currency("NZD", 24.25, LocalDate.of(2025, 5, 15)));
    }
}



