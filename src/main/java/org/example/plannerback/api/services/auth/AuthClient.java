package org.example.plannerback.api.services.auth;

import org.example.plannerback.api.dto.auth.AccessTokenValue;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface AuthClient {
    Mono<AccessTokenValue> getValueByToken(String jwtToken);
}
