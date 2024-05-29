package com.example.banking.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
//               .csrf(AbstractHttpConfigurer::disable)
//               .authorizeHttpRequests(auth -> auth
//                       .requestMatchers("/api/users" + "/**").authenticated()
//                       .anyRequest().anonymous())
//               .httpBasic(Customizer.withDefaults())
//               .sessionManagement(AbstractHttpConfigurer::disable)
//               .userDetailsService(userDetailsService)
               .build();
    }
}