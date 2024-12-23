package org.example.plannerback.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link org.example.plannerback.api.entities.Calendar}
 */
@Data
public class CalendarDto implements Serializable {
    Long id;
    String title;
    String description;
    Long userId;
    List<CalendarEventDto> listEvent;
}