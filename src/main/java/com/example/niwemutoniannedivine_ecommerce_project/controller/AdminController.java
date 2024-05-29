package com.example.niwemutoniannedivine_ecommerce_project.controller;

//import com.web.ecommerceweb.dto.ProductDTO;
import com.example.niwemutoniannedivine_ecommerce_project.model.Category;
import com.example.niwemutoniannedivine_ecommerce_project.model.Product;
import com.example.niwemutoniannedivine_ecommerce_project.service.CategoryService;
import com.example.niwemutoniannedivine_ecommerce_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
    private final CategoryService categoryService;
    private  final ProductService productService;
    @Autowired
    public AdminController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String addCat(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCat(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String delCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        //HERE
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else {
            return "404";
        }
    }

    // PRODUCTS
    @GetMapping("/admin/products")
    public String getProd(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String addProd(Model model){
        model.addAttribute("productDTO", new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }
    //    @PostMapping("/admin/products/add")
//    public String postProd(@ModelAttribute("productDTO") Product productDTO, @RequestParam("productImage")MultipartFile file,
//                           @RequestParam("imgName")String imgName) throws IOException {
//
//        String imageUUID;
//        if(!file.isEmpty()){
//            imageUUID = file.getOriginalFilename();
//            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
//            Files.write(fileNameAndPath, file.getBytes());
//        }else{
//            imageUUID = imgName;
//        }
//
//        Product product = new Product();
//        product.setId(product.getId());
//        product.setName(product.getName());
//        product.setPrice(product.getPrice());
//        product.setWeight(product.getWeight());
//        product.setDescription(product.getDescription());
//        product.setImageName(imageUUID);
//
////        product1.setCategory(categoryService.getCategoryById(product.getCategoryId()).get());
////        Category category = categoryService.getCategoryById(product.getCategoryId())
////                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
//        Optional<Category> categoryOptional = categoryService.getCategoryById(productDTO.getCategory().getId());
//        if (categoryOptional.isPresent()){
//            Category category = categoryOptional.get();
//            product.setCategory(category);
//            product.setName(product.getName());
//            product.setPrice(product.getPrice());
//            product.setWeight(product.getWeight());
//            product.setDescription(product.getDescription());
//
//            product.setImageName(imageUUID);
//            productService.addProduct(product);
//        }else {
//            throw new IOException("Category with ID " + productDTO.getCategory() + "not found");
//        }
//        return "redirect:/admin/products";
//    }
    @PostMapping("/admin/products/add")
    public String postProd(@ModelAttribute("productDTO") Product productDTO, @RequestParam("productImage")MultipartFile file,
                           @RequestParam("imgName")String imgName) throws IOException {

        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }else{
            imageUUID = imgName;
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());
        product.setImageName(imageUUID);

        Optional<Category> categoryOptional = categoryService.getCategoryById(productDTO.getCategory().getId());
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            product.setCategory(category);
            productService.addProduct(product);
        } else {
            throw new IOException("Category with ID " + productDTO.getCategory().getId() + " not found");
        }
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String delProd(@PathVariable int id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProd(@PathVariable int id, Model model){
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = productService.getProductById(id).get();
            Product productDTO = new Product();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
//        productDTO.setCategory((product.getCategory().getId()));
            productDTO.setCategory(product.getCategory());

            productDTO.setPrice(product.getPrice());
            productDTO.setWeight((product.getWeight()));
            productDTO.setImageName(product.getImageName());
            model.addAttribute("categories", categoryService.getAllCategory());
            model.addAttribute("productDTO", productDTO);
//        if(product.isPresent()){
//            model.addAttribute("ProductDTO", product.get());
            return "productsAdd";
        } else {
            // Handle case where product with the given ID doesn't exist
            return "404"; // Or any other appropriate error page
        }
    }

}
