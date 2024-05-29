package com.example.niwemutoniannedivine_ecommerce_project.controller;

import com.example.niwemutoniannedivine_ecommerce_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    private UsersService usersService;
//    private AuthenticationManager authenticationManager;
////    private JwtService jwtService;
////    private EmailService emailService;
//    @Autowired
//    public UserController(UsersService usersService, AuthenticationManager authenticationManager) {
//        this.usersService = usersService;
//        this.authenticationManager = authenticationManager;
////        this.jwtService = jwtService;
////        this.emailService = emailService;
//    }
//
//    @PostMapping(value="/register")
//    public ResponseEntity<?> saveUser(@RequestBody User users) {
//        if (users != null) {
//            User user=usersService.findUserbyemail(users.getEmail());
//            if(user!=null){
//                return new ResponseEntity<>("Email is taken",HttpStatus.BAD_REQUEST);
//            }
//            else {
//                usersService.saveUser(users);
//                String subject = "Welcome to our platform";
//                String text = "Thank you for Signing up, your account has been created successfully";
//
////                String userEmail = users.getEmail();
////                if (userEmail != null) {
////                    emailService.sendingEmails(userEmail, subject, text);
////                    return new ResponseEntity<>("User saved and email sent", HttpStatus.OK);
////                } else {
////                    return new ResponseEntity<>("User email is null", HttpStatus.BAD_REQUEST);
////                }
//            }
//
//        }
//        return new ResponseEntity<>("User is null", HttpStatus.BAD_REQUEST);
//    }
//    @GetMapping("/allUsers")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public ResponseEntity<?>allUsers(){
//        List<User>allUsers=usersService.allUsers();
//        if(allUsers!=null) {
//            return new ResponseEntity<>(allUsers, HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
////    @PostMapping("/authentication")
////    public ResponseEntity<?> authReqAndToken(@RequestBody AuthRequest auth){
////        User users=usersService.findUserbyemail(auth.getUsername());
////        if(users!=null) {
////            String roles = users.getRoles().toString();
////            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
////            if (authentication.isAuthenticated()) {
////                String token = jwtService.generateToken(auth.getUsername(), roles);
////                Map<String, String> response = new HashMap<>();
////                response.put("token", token);
////
////                return new ResponseEntity<>(response, HttpStatus.OK);
////
////            } else {
////                throw new UsernameNotFoundException("no user found");
////            }
////        }
////        else{
////            throw new RuntimeException("User is null");
////        }
////
////
////    }
//
//
}
