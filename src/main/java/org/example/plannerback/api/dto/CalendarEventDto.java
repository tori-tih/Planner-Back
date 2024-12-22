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
    UUID id;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String text;
}