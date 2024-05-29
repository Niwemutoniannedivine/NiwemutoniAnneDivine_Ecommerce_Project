package com.example.niwemutoniannedivine_ecommerce_project.configuration;//package com.web.ecommerceweb.configuration;
//
//import com.web.ecommerceweb.service.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//
////    @Lazy
//
//
////    public SecurityConfig(UserInfoDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
//
//
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        UserDetails normalUser = User.builder()
////                .username("user")
////                //online bycypt encoder
////                .password("$2a$12$zuQZqapONDTHL6rZ2thwmONbP6L/7SRv05PfY8YDEckYFMyvbN0QG")
////                .roles("USER")
////                .build();
////        UserDetails adminUser = User.builder()
////                .username("admin")
////                //online bycypt encoder
////                .password("$2a$12$zuQZqapONDTHL6rZ2thwmONbP6L/7SRv05PfY8YDEckYFMyvbN0QG")
////                .roles("ADMIN")
////                .build();
////        return new InMemoryUserDetailsManager(normalUser, adminUser);
////    }
//
//
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
////        return configuration.getAuthenticationManager();
////    }
////        @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////    }
////}
//
//
//@Configuration
//@EnableMethodSecurity
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Autowired
//    private UsersService usersService;
//    @Autowired
//    UserDetailsService userDetailsService;
//
////    @Bean
////    public UserDetailsService userDetailsService(){
////
////        return new UserInfoDetailsService();
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(registry -> {
//                    registry.requestMatchers("/login", "/register").permitAll();
//                    registry.requestMatchers("/admin/**", "/index").hasRole("ADMIN");
//                    registry.requestMatchers("/index", "/shop/**", "/addToCart/", "/cart", "/checkout/", "/payNow", "/confirmation", "/users/").hasRole("USER");
//                    registry.anyRequest().authenticated();
//
//                })
//                .formLogin(httpSecurityFormLoginConfigurer ->{
//                        httpSecurityFormLoginConfigurer
//                                .loginPage("/login")
//                                .successHandler(new AuthenticationSuccessHandler())
//                                .permitAll();
//                })
//                .build();
//    }
////
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return userDetailsService();
////    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
