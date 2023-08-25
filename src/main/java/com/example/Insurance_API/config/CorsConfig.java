package com.example.Insurance_API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from any origin, you can specify specific origins if needed
        config.addAllowedOrigin("*");

        // Allow specific HTTP methods (GET, POST, etc.)
        config.addAllowedMethod("*");

        // Allow specific headers
        config.addAllowedHeader("*");

        // Allow credentials (cookies, authentication)
        ///config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

