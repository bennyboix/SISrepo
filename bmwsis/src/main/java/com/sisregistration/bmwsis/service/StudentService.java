package com.sisregistration.bmwsis.service;

import com.sisregistration.bmwsis.entity.*;
import com.sisregistration.bmwsis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private GradeRepository gradeRepository;
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private SubjectScheduleRepository subjectScheduleRepository;
    
    @Autowired
    private EnrollmentPeriodRepository enrollmentPeriodRepository;
    
    public Optional<Student> authenticateStudent(String studentId, String password) {
        return studentRepository.findByStudentIdAndPassword(studentId, password);
    }
    
    public List<Grade> getStudentGrades(Student student) {
        return gradeRepository.findByStudentOrderBySemesterAscAcademicYearAsc(student);
    }
    
    public List<Enrollment> getStudentSchedules(Student student) {
        return enrollmentRepository.findCurrentEnrollmentsByStudent(student);
    }
    
    public List<SubjectSchedule> getAvailableSchedulesForStudent(Student student) {
        return subjectScheduleRepository.findAvailableSchedulesForYearLevel(student.getYearLevel());
    }
    
    public boolean isEnrollmentOpen() {
        Optional<EnrollmentPeriod> activePeriod = enrollmentPeriodRepository.findActiveEnrollmentPeriod();
        return activePeriod.isPresent() && activePeriod.get().isEnrollmentOpen();
    }
    
    public boolean enrollStudent(Student student, Long scheduleId) {
        if (!isEnrollmentOpen()) {
            return false;
        }
        
        Optional<SubjectSchedule> scheduleOpt = subjectScheduleRepository.findById(scheduleId);
        if (scheduleOpt.isEmpty() || !scheduleOpt.get().hasAvailableSlots()) {
            return false;
        }
        
        SubjectSchedule schedule = scheduleOpt.get();
        
        // Create enrollment
        Enrollment enrollment = new Enrollment(
            student, 
            schedule.getSubject(), 
            schedule,
            "1st Semester", // You can make this dynamic
            "2024-2025"     // You can make this dynamic
        );
        
        enrollmentRepository.save(enrollment);
        
        // Update current enrolled count
        schedule.setCurrentEnrolled(schedule.getCurrentEnrolled() + 1);
        subjectScheduleRepository.save(schedule);
        
        return true;
    }
    
    public Student findByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId).orElse(null);
    }
} 