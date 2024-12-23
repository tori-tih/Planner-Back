package org.example.plannerback.api.mappers;

import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarDto;
import org.example.plannerback.api.entities.Calendar;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalendarMapper extends BaseMapper<Calendar, CalendarDto> {
    private final CalendarEventMapper calendarMapper;

    @Override
    public CalendarDto fromEntity(Calendar entity) {
        final CalendarDto dto = new CalendarDto();
        BeanUtils.copyProperties(entity, dto);

        if (entity.getCalendarEvents() != null) {
            dto.setListEvent(entity.getCalendarEvents()
                    .stream()
                    .map(calendarMapper::fromEntity)
                    .toList()
            );
        }

        return dto;
    }

    @Override
    public Calendar toEntity(CalendarDto calendarDto) {
        final Calendar calendar = new Calendar();
        BeanUtils.copyProperties(calendarDto, calendar);
        if (calendarDto.getListEvent() != null) {
            calendar.setCalendarEvents(calendarDto.getListEvent()
                    .stream()
                    .map(calendarMapper::toEntity)
                    .toList()
            );
        }
        return calendar;
    }
}
