//package org.example.plannerback.api.config;
//
//import lombok.RequiredArgsConstructor;
//import org.example.plannerback.api.services.auth.AuthClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ResponseStatusException;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class AppAuthenticationManager implements ReactiveAuthenticationManager {
//    private final AuthClient authClient;
//
//    @Override
//    public Mono<Authentication> authenticate(Authentication authentication) {
//        if (authentication == null || authentication.getPrincipal() == null) {
//            return Mono.empty();
//        }
//        return Mono.just(authentication.getCredentials().toString())
//                .flatMap(authClient::getValueByToken)
//                .map(accessTokenValue -> {
//                    if (accessTokenValue == null) {
//                        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Неверный токен");
//                    }
//
//                    List<SimpleGrantedAuthority> authorities = accessTokenValue.getScope().stream()
//                            .map(SimpleGrantedAuthority::new)
//                            .toList();
//
//                    return new UsernamePasswordAuthenticationToken(
//                            accessTokenValue,
//                            null,
//                            authorities
//                    );
//                });
//    }
//}