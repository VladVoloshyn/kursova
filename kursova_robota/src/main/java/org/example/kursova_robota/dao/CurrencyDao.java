package org.example.kursova_robota.dao;
import org.example.kursova_robota.model.Currency;

import java.util.Collection;

public interface CurrencyDao {
    void create(Currency currency);
    Currency findById(Integer id);
    Collection<Currency> findAll();
    void update(Currency currency);
    void deleteById(Integer id);
}


