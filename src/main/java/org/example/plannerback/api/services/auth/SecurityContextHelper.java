package org.example.plannerback.api.services.auth;

import org.example.plannerback.api.dto.auth.AccessTokenValue;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextHelper {
    public static AccessTokenValue getCurrentUser() {
        return (AccessTokenValue) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
