//package com.moneyMaster.Money_Master_WebWizard.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")  // Allow all endpoints
//                        .allowedOrigins("http://localhost:5173")  // Allow only from frontend origin
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific methods
//                        .allowCredentials(true);  // Allow cookies or authorization headers
//            }
//        };
//    }
//}
//
