package com.example.alimentaTec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;


@Configuration
public class SecurityConfig {

      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
            auth -> auth.requestMatchers("/login", "/signin", "/signup").permitAll()
                    .requestMatchers("/nutritionist/**").hasRole("NUTRIOLOGO")
                    .requestMatchers("/patient/**").hasRole("PACIENTE")
                    .anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .rememberMe(Customizer.withDefaults())
            .logout(logout -> logout.logoutUrl("/signout").permitAll());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}