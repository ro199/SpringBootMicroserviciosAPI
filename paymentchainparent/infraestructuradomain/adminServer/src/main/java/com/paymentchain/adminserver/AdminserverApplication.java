package com.paymentchain.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableAdminServer
@EnableAutoConfiguration
@EnableWebSecurity
@EnableDiscoveryClient
public class AdminserverApplication {

    @Configuration
    public static class SecurityPermitAllConfig {

        @Bean
        protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests.anyRequest().permitAll())
                    .csrf().disable().build();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminserverApplication.class, args);
    }

}
