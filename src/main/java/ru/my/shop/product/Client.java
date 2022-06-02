package ru.my.shop.product;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Product> basket;

    public Client(String name) {
        this.name = name;
        basket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    public List<Product> getBasket() {
        return basket;
    }

    public void setBasket(List<Product> basket) {
        this.basket = basket;
    }

}
