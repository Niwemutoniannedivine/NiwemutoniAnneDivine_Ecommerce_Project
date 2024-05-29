package com.example.niwemutoniannedivine_ecommerce_project.repository;


import com.example.niwemutoniannedivine_ecommerce_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    List<Product> findAllByCategoryId(int id);
    List<Product> findAllByCategory_Id(int id);
}
