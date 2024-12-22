package org.example.plannerback.api.services;

import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarDto;
import org.example.plannerback.api.mappers.CalendarMapper;
import org.example.plannerback.api.repository.CalendarRepository;
import org.example.plannerback.api.services.auth.SecurityContextHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {
    private final CalendarRepository calendarRepository;
    private final CalendarMapper calendarMapper;

    public List<CalendarDto> getAllCalendars() {
        System.out.println("{EQEQ");
        return calendarRepository.findAllByUserId(SecurityContextHelper.getCurrentUser().getId())
                .stream()
                .map(calendarMapper::fromEntity)
                .toList();
    }
}
