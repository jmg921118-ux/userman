package com.example.userman.repository;

import com.example.userman.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    void deleteAllById(Long userId);
}
