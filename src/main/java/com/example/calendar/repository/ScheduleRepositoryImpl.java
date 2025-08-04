//package com.example.calendar.repository;
//
//import com.example.calendar.dto.ScheduleResponseDto;
//import com.example.calendar.entity.Schedule;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class ScheduleRepositoryImpl implements ScheduleRepository {
//
//    private final Map<Long, Schedule> scheduleList = new HashMap<>();
//
//    @Override
//    public Schedule saveSchedule(Schedule schedule) {
//
//        // schedule 식별자 자동 생성
//        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
//
//        scheduleList.put(scheduleId, schedule);
//
//        return schedule;
//    }
//
//    @Override
//    public List<ScheduleResponseDto> findAllSchedules() {
//
//        // List 초기화
//        List<ScheduleResponseDto> allSchedules = new ArrayList<>();
//
//        // HashMap<Schedule> -> List<ScheduleResponseDto>
//        for (Schedule schedule : scheduleList.values()) {
//            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
//            allSchedules.add(responseDto);
//        }
//
//        return allSchedules;
//    }
//
//    @Override
//    public Schedule findScheduleById(Long id) {
//        return scheduleList.get(id);
//    }
//
//    @Override
//    public void deleteSchedule(Long id) {
//        scheduleList.remove(id);
//    }
//}
