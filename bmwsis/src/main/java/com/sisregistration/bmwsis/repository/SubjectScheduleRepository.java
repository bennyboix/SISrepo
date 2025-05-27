package com.sisregistration.bmwsis.repository;

import com.sisregistration.bmwsis.entity.SubjectSchedule;
import com.sisregistration.bmwsis.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubjectScheduleRepository extends JpaRepository<SubjectSchedule, Long> {
    List<SubjectSchedule> findBySubject(Subject subject);
    
    @Query("SELECT ss FROM SubjectSchedule ss WHERE ss.subject.yearLevel <= :yearLevel AND ss.currentEnrolled < ss.maxSlots")
    List<SubjectSchedule> findAvailableSchedulesForYearLevel(@Param("yearLevel") Integer yearLevel);
    
    @Query("SELECT ss FROM SubjectSchedule ss WHERE ss.currentEnrolled < ss.maxSlots")
    List<SubjectSchedule> findAvailableSchedules();
} 