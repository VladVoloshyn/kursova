package org.example.kursova_robota.dao;

import org.example.kursova_robota.model.Currency;

import java.util.Collection;
import java.util.TreeMap;
public class MemoryCurrencyDao implements CurrencyDao{
    private TreeMap<Integer, Currency> currencies = new TreeMap<>();
    @Override
    public void create(Currency currency) {
        int id = currencies.isEmpty() ? 1 : currencies.lastKey() + 1;
        currency.setId(id);
        currencies.put(id, currency);
    }
    @Override
    public Currency findById(Integer id) {
        return currencies.get(id);
    }
    @Override
    public Collection<Currency> findAll() {
        return currencies.values();
    }
    @Override
    public void update(Currency currency) {
        currencies.put(currency.getId(), currency);
    }
    @Override
    public void deleteById(Integer id) {
        currencies.remove(id);
    }
}




