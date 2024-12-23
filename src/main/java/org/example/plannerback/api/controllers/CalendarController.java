package org.example.plannerback.api.controllers;

import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarDto;
import org.example.plannerback.api.services.CalendarService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public CalendarDto createCalendar(@RequestBody CalendarDto calendarDto) {
        return calendarService.create(calendarDto);
    }

    @PutMapping
    public CalendarDto updateCalendar(@RequestBody CalendarDto calendarDto) {
        return calendarService.update(calendarDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCalendar(@PathVariable Long id) {
        calendarService.delete(id);
    }
}
