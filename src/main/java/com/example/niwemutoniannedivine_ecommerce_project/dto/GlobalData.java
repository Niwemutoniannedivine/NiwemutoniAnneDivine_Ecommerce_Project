package com.example.niwemutoniannedivine_ecommerce_project.dto;



import com.example.niwemutoniannedivine_ecommerce_project.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
