package org.example.kursova_robota.model;

import java.time.LocalDate;
public class Currency {
    Integer id;
    String name;
    Double price;
    LocalDate date;
    public Currency(String name, Double price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }
    public Currency(Integer id, String name, Double price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}



