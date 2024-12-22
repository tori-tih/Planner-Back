package org.example.plannerback.api.controllers;

import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarDto;
import org.example.plannerback.api.services.CalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping()
    public List<CalendarDto> getCalendars() {
        return calendarService.getAllCalendars();
    }
}
