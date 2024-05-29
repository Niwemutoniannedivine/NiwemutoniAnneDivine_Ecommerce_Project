

package com.example.niwemutoniannedivine_ecommerce_project.dto;


import com.example.niwemutoniannedivine_ecommerce_project.model.Category;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Category category;
    private double price;
    private double weight;
    private String description;
    private String imageName;
}

//}
