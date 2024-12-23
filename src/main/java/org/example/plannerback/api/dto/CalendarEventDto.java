package org.example.plannerback.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link org.example.plannerback.api.entities.CalendarEvent}
 */
@Data
public class CalendarEventDto implements Serializable {
    private UUID id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String text;
}