package org.example.plannerback.api.services.auth;

import org.example.plannerback.api.dto.auth.AccessTokenValue;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthClientImpl implements AuthClient {
    private final WebClient authWebClient;

    public AuthClientImpl(WebClient authWebClient) {
        this.authWebClient = authWebClient;
    }

    @Override
    public Mono<AccessTokenValue> getValueByToken(String jwtToken) {
        Map<String, String> body = new HashMap<>();
        body.put("accessToken", jwtToken);
        return this.authWebClient.post()
                .uri(ub -> ub.path("/access")
                        .build()
                )
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(AccessTokenValue.class)
                .retryWhen(Retry.fixedDelay(2L, Duration.ofSeconds(1)));
    }
}
