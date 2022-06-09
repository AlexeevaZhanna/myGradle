package ru.my.shop.Product;

public class Product {
    private String name;
    private double price;
    private String category;
    private String id;

    public Product(String name, double price, String category, String id) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.id = id;

    }

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(String nameProduct, String name, String category) {
        this.name = name;
        this.category = category;
    }


    public Product(String name) {
        this.name = name;
    }

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", id=" + id +
                '}';
    }
}
