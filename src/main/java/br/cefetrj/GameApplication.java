package br.cefetrj;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class GameApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GameApplication.class);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterInit() throws IOException, URISyntaxException, ClassNotFoundException {
        System.out.println("Aplicação iniciada com sucesso!");
    }

    // SOLUÇÃO DE EMERGÊNCIA - Filtro CORS global
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

    config.setAllowCredentials(false);
    // Allow common local origins used during development (no port and explicit 81)
    config.addAllowedOrigin("http://localhost");
    config.addAllowedOrigin("http://localhost:81");
    config.addAllowedOrigin("http://127.0.0.1:81");
    // Also permit any local origin pattern during development. Remove or lock down in production.
    config.addAllowedOriginPattern("*");

    config.addAllowedHeader("*");
    config.addAllowedMethod("*"); // Permite todos os métodos

        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}