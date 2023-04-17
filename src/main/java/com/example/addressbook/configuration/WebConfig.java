package com.example.addressbook.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") //replace "/api/**" with your API endpoint
                .allowedOrigins("*") //replace "*" with your allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE") //replace with your allowed HTTP methods
                .allowedHeaders("*"); //replace with your allowed headers
    }
}
