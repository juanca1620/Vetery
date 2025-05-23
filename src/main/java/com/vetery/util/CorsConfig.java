package com.vetery.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // habilitar todos los endpoints
                .allowedOrigins("*")
                .allowCredentials(false) // o simplemente lo eliminas

                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // qué métodos permites
                        .allowedHeaders("*"); 
            }
        };
    }
}
