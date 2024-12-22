package org.example.plannerback.api.mappers;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseMapper<E, DTO> {
    public abstract DTO fromEntity(E entity);
    public abstract E toEntity(DTO dto);
}
