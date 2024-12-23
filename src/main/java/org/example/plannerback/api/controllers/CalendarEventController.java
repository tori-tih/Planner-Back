package org.example.plannerback.api.controllers;

import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarEventDto;
import org.example.plannerback.api.services.CalendarEventService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class CalendarEventController {
    private final CalendarEventService calendarEventService;

    @PostMapping
    public CalendarEventDto create(@RequestBody CalendarEventDto calendarEventDto,
                                   @RequestParam Long calendarId) {
        return calendarEventService.create(calendarEventDto, calendarId);
    }

    @PutMapping
    public CalendarEventDto update(@RequestBody CalendarEventDto calendarEventDto){
        return calendarEventService.update(calendarEventDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        calendarEventService.delete(id);
    }
}
