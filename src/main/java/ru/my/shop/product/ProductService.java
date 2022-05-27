package ru.my.shop.product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private static Map<String, Product> products = new HashMap<>();

    static  {
        products.put("курица", new Product("Курица", 300,  "Мясо" ));
        products.put("сыр", new Product("Российский", 250,   "Сыр"));
        products.put("яблоко", new Product("Яблоки Голден", 95.30,  "Фрукты"));

    }

    public static synchronized Map<String, Product> getAll() {
       return products;
    }

    public static Product get(String name) {

        return null;
    }

    public static Map<String, Product> getByNameAndCategory(String name,  String category) {

        return null;
    }

    public static boolean delete(String name) {

        return false;
    }

    public static synchronized void add(Product product) {
        products.put(product.getName(), product);

    }
}
