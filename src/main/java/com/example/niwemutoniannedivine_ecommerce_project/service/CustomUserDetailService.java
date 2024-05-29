package com.example.niwemutoniannedivine_ecommerce_project.service;//package com.web.ecommerceweb.service;
//
//import com.web.ecommerceweb.model.CustomerUserDetail;
//import com.web.ecommerceweb.model.User;
//import com.web.ecommerceweb.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByEmail(email);
//        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return user.map(CustomerUserDetail::new).get();
//    }
//}
