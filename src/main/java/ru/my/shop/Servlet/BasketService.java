package ru.my.shop.Servlet;

import ru.my.shop.Product.Product;

import java.util.List;

public class BasketService {
    public static void removeFromBasket(int id, List<Product> myBasket) {
        if(myBasket !=null) {
            myBasket.remove(id);
        }
    }

            }


