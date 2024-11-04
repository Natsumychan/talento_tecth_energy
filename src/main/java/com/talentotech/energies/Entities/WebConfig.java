package com.talentotech.energies.Entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite todas las rutas
                        .allowedOrigins("http://localhost:4200") // Permite solicitudes solo desde este origen
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                        .allowedHeaders("*") // Permite todos los headers
                        .allowCredentials(true); // Permite el uso de credenciales
            }
        };
    }
}
