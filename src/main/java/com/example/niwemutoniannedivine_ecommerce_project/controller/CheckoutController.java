package com.example.niwemutoniannedivine_ecommerce_project.controller;


import com.example.niwemutoniannedivine_ecommerce_project.dto.GlobalData;
import com.example.niwemutoniannedivine_ecommerce_project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {
    @Autowired
    private EmailService emailService;

    // Assuming GlobalData is a class storing the cart items
//    @PostMapping("/payNow")
//    public String payNow() {
//        // Here, you can add logic to process the payment, update the database, send confirmation emails, etc.
//        // After processing, the cart is cleared using GlobalData.cart.clear().
//        GlobalData.cart.clear();
//        // Redirect the user to the confirmation page
//        return "redirect:/confirmation";
//    }
    @PostMapping("/payNow")
    public String payNow() {
        String userEmail = "ecommerce001@gmail.com";
        String subject = "Thank You for Your Purchase!";
        String text = "Thank you for your purchase comeback please!";
        emailService.sendEmail(userEmail, subject, text);
        GlobalData.cart.clear();

        // Redirect the user to the home page or any other desired page
        return "redirect:/confirmation";
    }

    // Endpoint for displaying the confirmation page
    @GetMapping("/confirmation")
    public String confirmation() {
        // Return the view name for the confirmation page
        return "confirmation";
    }
}
