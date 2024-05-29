package com.example.niwemutoniannedivine_ecommerce_project.configuration;//package com.web.ecommerceweb.configuration;
//
//import com.web.ecommerceweb.model.User;
//import com.web.ecommerceweb.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserInfoDetailsService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userRepo.findByEmail(email);
//        user.orElseThrow(() ->  new UsernameNotFoundException("User not found with email " + email));
//        return user.map(UserInfoDetails::new).get();
//    }
//}