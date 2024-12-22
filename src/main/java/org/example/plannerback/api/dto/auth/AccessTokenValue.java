package org.example.plannerback.api.dto.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class AccessTokenValue {
    private Long id;
    private String name;
    private String type;
    private Set<String> scope;
}
