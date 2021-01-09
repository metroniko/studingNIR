package com.example.studing.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
class CorsConfig {

    @Value("${frontUrl}")
    private String frontUrl;
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedOrigin("http://localhost:4200/angular");
        config.addAllowedOrigin("http://142.93.130.144/angular");
        config.addAllowedOrigin("http://localhost:4200/");
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Accept");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("OPTIONS");
        config.setMaxAge(3600L);
        // source.registerCorsConfiguration("/oauth/token", config); // Add "/oauth/token" explicitly
        source.registerCorsConfiguration("/**", config); // Global for all paths

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}