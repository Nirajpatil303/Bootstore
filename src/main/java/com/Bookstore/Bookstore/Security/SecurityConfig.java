package com.Bookstore.Bookstore.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests("/Category")
                .antMatchers("/owner/**").hasRole("OWNER")
                .antMatchers("/customer/**").hasRole("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("owner")
                .password(passwordEncoder.encode("ownerpass"))
                .roles("OWNER").build());
        manager.createUser(User.withUsername("customer")
                .password(passwordEncoder.encode("customerpass"))
                .roles("CUSTOMER").build());
        return manager;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
