package com.example.niwemutoniannedivine_ecommerce_project.repository;


import com.example.niwemutoniannedivine_ecommerce_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
