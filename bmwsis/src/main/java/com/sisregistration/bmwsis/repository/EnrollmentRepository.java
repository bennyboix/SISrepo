package com.sisregistration.bmwsis.repository;

import com.sisregistration.bmwsis.entity.Enrollment;
import com.sisregistration.bmwsis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findByStudentAndStatus(Student student, String status);
    
    @Query("SELECT e FROM Enrollment e WHERE e.student = :student AND e.status = 'ENROLLED'")
    List<Enrollment> findCurrentEnrollmentsByStudent(@Param("student") Student student);
    
    @Query("SELECT COUNT(e) FROM Enrollment e WHERE e.subjectSchedule.id = :scheduleId AND e.status = 'ENROLLED'")
    Long countEnrolledStudentsBySchedule(@Param("scheduleId") Long scheduleId);
} 