package org.example.plannerback.api.dto;

import lombok.Builder;

public record Message(
        String id,
        String content,
        String timestamp
){
    @Builder
    public Message {
    }
}