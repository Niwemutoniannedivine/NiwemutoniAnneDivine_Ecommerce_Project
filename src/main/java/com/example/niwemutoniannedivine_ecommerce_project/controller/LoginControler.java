package com.example.niwemutoniannedivine_ecommerce_project.controller;

import com.example.niwemutoniannedivine_ecommerce_project.dto.GlobalData;
import com.example.niwemutoniannedivine_ecommerce_project.model.User;
import com.example.niwemutoniannedivine_ecommerce_project.repository.UserRepository;
import com.example.niwemutoniannedivine_ecommerce_project.service.EmailService;
import com.example.niwemutoniannedivine_ecommerce_project.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Optional;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginControler {
    //    @Autowired

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    EmailService emailService;

    //
    @GetMapping("/login")
    public String login() {
        GlobalData.cart.clear();
        return "login";
    }

    //
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("User", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user) {
        // Check if the user already exists
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "redirect:/login?error=user-exists";
        } else {
            // Set the default role for the user
            user.setRole("USER");

            // Save the user to the database
            usersService.saveUser(user);

            // Send a registration confirmation email
            String subject = "Welcome to Our Thriving IRADUKUNDA E-commerce Community";
            String text = "Thank you for signing up on our Ecommerce! Your account has been created successfully" +
                    " Your Journey Begins!";
            emailService.sendEmail(user.getEmail(), subject, text);
            return "redirect:/login?registrationSuccess=true";


        }
    }



    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User loginUser, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("Attempting login for user with email: " + loginUser.getEmail());

        // Find user by email
        User user = usersService.findUserbyemail(loginUser.getEmail());

        if (user != null) {
            System.out.println("User found in the database.");
            // Log the user's credentials
            System.out.println("User credentials - Email: " + loginUser.getEmail() + ", Password: " + loginUser.getPassword());

            // Check if the entered password matches the stored password
            if (loginUser.getPassword().equals(user.getPassword())) {
                System.out.println("Login successful.");

                // Redirect based on user role
                if (user.getRole().equals("ADMIN")) {
                    redirectAttributes.addFlashAttribute("message", "Welcome Admin!");
                    return "redirect:/admin"; // Assuming admin dashboard URL
                } else {
                    redirectAttributes.addFlashAttribute("message", "Welcome User!");
                    return "redirect:/"; // Default redirection for regular users
                }
            } else {
                System.out.println("Invalid password entered.");
                // Password incorrect, add error message
                model.addAttribute("error", "Invalid username or password.");
                return "login";
            }
        } else {
            System.out.println("User not found in the database.");
            // User not found, add error message
            model.addAttribute("error", "User not found. Please register an account.");
            return "login";
        }
    }

}

