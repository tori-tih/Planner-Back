package org.example.plannerback.api.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.plannerback.api.dto.CalendarDto;
import org.example.plannerback.api.entities.Calendar;
import org.example.plannerback.api.mappers.CalendarMapper;
import org.example.plannerback.api.repository.CalendarRepository;
import org.example.plannerback.api.services.auth.SecurityContextHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    public CalendarDto create(CalendarDto calendarDto) {
        calendarDto.setUserId(SecurityContextHelper.getCurrentUser().getId());
        calendarDto.setId(null);
        Calendar calendar = calendarRepository.save(calendarMapper.toEntity(calendarDto));
        return calendarMapper.fromEntity(calendar);
    }
    @Transactional
    public CalendarDto update(CalendarDto calendarDto) {
        Calendar calendar = calendarRepository.findById(calendarDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Календарь не найден")
        );
        if (!Objects.equals(SecurityContextHelper.getCurrentUser().getId(),calendar.getUserId())) {
            throw new EntityNotFoundException("Неверный айди пользователя");
        }
        calendar.setTitle(calendarDto.getTitle());
        calendar.setDescription(calendarDto.getDescription());
        return calendarMapper.fromEntity(calendar);
    }

    public void delete(Long id) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Календарь не найден")
        );
        calendarRepository.delete(calendar);
    }
}
