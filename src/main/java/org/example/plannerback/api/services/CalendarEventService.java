package org.example.plannerback.api.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarEventDto;
import org.example.plannerback.api.entities.Calendar;
import org.example.plannerback.api.entities.CalendarEvent;
import org.example.plannerback.api.mappers.CalendarEventMapper;
import org.example.plannerback.api.repository.CalendarEventRepository;
import org.example.plannerback.api.repository.CalendarRepository;
import org.example.plannerback.api.services.auth.SecurityContextHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CalendarEventService {
    private final CalendarEventRepository calendarEventRepository;
    private final CalendarEventMapper calendarEventMapper;
    private final CalendarRepository calendarRepository;

    @Transactional
    public CalendarEventDto create(CalendarEventDto calendarEventDto, Long calendarId) {
        calendarEventDto.setId(null);
        CalendarEvent calendarEvent = calendarEventMapper.toEntity(calendarEventDto);
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(
                () -> new EntityNotFoundException("Calendar not found")
        );
        if (!Objects.equals(SecurityContextHelper.getCurrentUser().getId(),calendar.getUserId())) {
            throw new EntityNotFoundException("User not logged in");
        }
        calendarEvent.setCalendar(calendar);
        return calendarEventMapper.fromEntity(calendarEventRepository.save(calendarEvent));
    }
    @Transactional
    public CalendarEventDto update(CalendarEventDto calendarEventDto) {
        CalendarEvent calendarEvent = calendarEventRepository.findById(calendarEventDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Event not found")
        );
        if (!Objects.equals(SecurityContextHelper.getCurrentUser().getId(), calendarEvent.getCalendar().getUserId())) {
            throw new EntityNotFoundException("User not logged in");
        }
        calendarEvent.setText(calendarEventDto.getText());
        calendarEvent.setStartDate(calendarEventDto.getStartDate());
        calendarEvent.setEndDate(calendarEventDto.getEndDate());
        return calendarEventMapper.fromEntity(calendarEvent);
    }
    @Transactional
    public void delete(UUID id) {
        CalendarEvent calendarEvent = calendarEventRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Event not found")
        );
        if (!Objects.equals(SecurityContextHelper.getCurrentUser().getId(), calendarEvent.getCalendar().getUserId())) {
            throw new EntityNotFoundException("User not logged in");
        }
        calendarEventRepository.delete(calendarEvent);
    }
}
