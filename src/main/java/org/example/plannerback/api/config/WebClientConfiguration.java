package org.example.plannerback.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfiguration {
    @Value("${auth.baseUrl:http://localhost:8081}")
    private String baseUrl;

    @Bean
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient authWebClient() {
        return loadBalancedWebClientBuilder()
                .baseUrl(baseUrl)
                .build();
    }
}
