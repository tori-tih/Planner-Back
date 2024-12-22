package org.example.plannerback.api.mappers;

import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarEventDto;
import org.example.plannerback.api.entities.CalendarEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalendarEventMapper extends BaseMapper<CalendarEvent, CalendarEventDto> {
    @Override
    public CalendarEventDto fromEntity(CalendarEvent entity) {
        final CalendarEventDto dto = new CalendarEventDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public CalendarEvent toEntity(CalendarEventDto calendarEventDto) {
        final CalendarEvent entity = new CalendarEvent();
        BeanUtils.copyProperties(calendarEventDto, entity);
        return entity;
    }
}
