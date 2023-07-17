package com.bestbank.productos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Clase de configuración para WebClient, que permite establecer propiedades y 
 * personalizar la configuración del cliente web.
 */

@Configuration
public class WebClientConfig {

  @Bean
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }
  
}