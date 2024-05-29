package com.example.niwemutoniannedivine_ecommerce_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    @NotEmpty
    @Email(message = "{errors.invalid}")
    private String email;

    @NotEmpty
    private String password;

    @Column(nullable = false)
    private String role; // Add a field to store the user's role

    // Constructors, getters, setters, and other methods...

    // Define a default role for new users
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = "USER"; // Default role is "USER"
    }
}
