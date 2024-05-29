package com.example.niwemutoniannedivine_ecommerce_project.controller;



import com.example.niwemutoniannedivine_ecommerce_project.model.Product;
import com.example.niwemutoniannedivine_ecommerce_project.model.User;

import java.util.List;

public class PlaceOrderRequest {
    private User user;
    private List<Product> products;
    private double totalAmount;

    // Constructor, getters, and setters
    public PlaceOrderRequest() {}

    public PlaceOrderRequest(User user, List<Product> products, double totalAmount) {
        this.user = user;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

