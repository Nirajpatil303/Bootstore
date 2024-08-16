//package com.Bookstore.Bookstore.Security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfig {
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    public  SecurityConfig(CustomUserDetailsService customUserDetailsService){
//        this.customUserDetailsService=customUserDetailsService;
//    }
//
//
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/Book/**", "/Category/**", "/User/**").hasAnyRole("USER", "OWNER") // Allows access to these endpoints for both roles
//                        .requestMatchers(HttpMethod.POST, "/Book/**", "/Category/**").hasRole("OWNER") // Only OWNER can POST
//                        .requestMatchers(HttpMethod.PUT, "/Book/**", "/Category/**").hasRole("OWNER")  // Only OWNER can PUT
//                        .requestMatchers(HttpMethod.DELETE, "/Book/**", "/Category/**").hasRole("OWNER") // Only OWNER can DELETE
//                        .anyRequest().authenticated() // All other requests need authentication
//                )
//                .formLogin(withDefaults()) // Enables form-based login with default settings
//                .httpBasic(withDefaults())
//                .csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return (UserDetailsService) customUserDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
