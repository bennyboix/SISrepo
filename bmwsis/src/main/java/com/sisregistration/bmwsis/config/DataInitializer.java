package com.sisregistration.bmwsis.config;

import com.sisregistration.bmwsis.entity.*;
import com.sisregistration.bmwsis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private FacultyRepository facultyRepository;
    
    @Autowired
    private SubjectScheduleRepository subjectScheduleRepository;
    
    @Autowired
    private EnrollmentPeriodRepository enrollmentPeriodRepository;
    
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create sample students
        if (studentRepository.count() == 0) {
            Student student1 = new Student("2021-0001", "password123", "John", "Doe", 
                                         "john.doe@email.com", "Bachelor of Science in Information Technology", 3);
            Student student2 = new Student("2021-0002", "password123", "Jane", "Smith", 
                                         "jane.smith@email.com", "Bachelor of Science in Information Technology", 2);
            Student student3 = new Student("2022-0001", "password123", "Mike", "Johnson", 
                                         "mike.johnson@email.com", "Bachelor of Science in Information Technology", 2);
            
            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
        }

        // Create sample faculty
        if (facultyRepository.count() == 0) {
            Faculty faculty1 = new Faculty("FAC-001", "Dr. Maria", "Garcia", "maria.garcia@bmw.edu", "Computer Science");
            Faculty faculty2 = new Faculty("FAC-002", "Prof. Robert", "Chen", "robert.chen@bmw.edu", "Information Technology");
            Faculty faculty3 = new Faculty("FAC-003", "Dr. Sarah", "Williams", "sarah.williams@bmw.edu", "Software Engineering");
            Faculty faculty4 = new Faculty("FAC-004", "Prof. David", "Brown", "david.brown@bmw.edu", "Database Systems");
            Faculty faculty5 = new Faculty("FAC-005", "Dr. Lisa", "Anderson", "lisa.anderson@bmw.edu", "Network Security");
            
            facultyRepository.save(faculty1);
            facultyRepository.save(faculty2);
            facultyRepository.save(faculty3);
            facultyRepository.save(faculty4);
            facultyRepository.save(faculty5);
        }

        // Create sample IT subjects
        if (subjectRepository.count() == 0) {
            // First Year Subjects
            Subject prog1 = new Subject("IT-101", "Introduction to Programming", 3, "None", 1);
            Subject webDev1 = new Subject("IT-102", "Web Development Fundamentals", 3, "None", 1);
            Subject compFund = new Subject("IT-103", "Computer Fundamentals", 3, "None", 1);
            Subject math1 = new Subject("IT-104", "Mathematics for IT", 3, "None", 1);
            
            // Second Year Subjects
            Subject prog2 = new Subject("IT-201", "Object-Oriented Programming", 3, "IT-101", 2);
            Subject database1 = new Subject("IT-202", "Database Management Systems", 3, "IT-103", 2);
            Subject webDev2 = new Subject("IT-203", "Advanced Web Development", 3, "IT-102", 2);
            Subject networking = new Subject("IT-204", "Computer Networks", 3, "IT-103", 2);
            Subject dataStruct = new Subject("IT-205", "Data Structures and Algorithms", 3, "IT-101", 2);
            
            // Third Year Subjects
            Subject softEng = new Subject("IT-301", "Software Engineering", 3, "IT-201", 3);
            Subject database2 = new Subject("IT-302", "Advanced Database Systems", 3, "IT-202", 3);
            Subject webFramework = new Subject("IT-303", "Web Application Frameworks", 3, "IT-203", 3);
            Subject mobileDev = new Subject("IT-304", "Mobile Application Development", 3, "IT-201", 3);
            Subject cybersec = new Subject("IT-305", "Cybersecurity Fundamentals", 3, "IT-204", 3);
            Subject systemAnalysis = new Subject("IT-306", "System Analysis and Design", 3, "IT-301", 3);
            
            subjectRepository.save(prog1);
            subjectRepository.save(webDev1);
            subjectRepository.save(compFund);
            subjectRepository.save(math1);
            subjectRepository.save(prog2);
            subjectRepository.save(database1);
            subjectRepository.save(webDev2);
            subjectRepository.save(networking);
            subjectRepository.save(dataStruct);
            subjectRepository.save(softEng);
            subjectRepository.save(database2);
            subjectRepository.save(webFramework);
            subjectRepository.save(mobileDev);
            subjectRepository.save(cybersec);
            subjectRepository.save(systemAnalysis);
        }

        // Create sample schedules
        if (subjectScheduleRepository.count() == 0) {
            Faculty faculty1 = facultyRepository.findByFacultyId("FAC-001").orElse(null);
            Faculty faculty2 = facultyRepository.findByFacultyId("FAC-002").orElse(null);
            Faculty faculty3 = facultyRepository.findByFacultyId("FAC-003").orElse(null);
            Faculty faculty4 = facultyRepository.findByFacultyId("FAC-004").orElse(null);
            Faculty faculty5 = facultyRepository.findByFacultyId("FAC-005").orElse(null);
            
            // Second Year Schedules
            Subject prog2 = subjectRepository.findBySubjectCode("IT-201").orElse(null);
            Subject database1 = subjectRepository.findBySubjectCode("IT-202").orElse(null);
            Subject webDev2 = subjectRepository.findBySubjectCode("IT-203").orElse(null);
            Subject networking = subjectRepository.findBySubjectCode("IT-204").orElse(null);
            Subject dataStruct = subjectRepository.findBySubjectCode("IT-205").orElse(null);
            
            if (prog2 != null && faculty1 != null) {
                SubjectSchedule schedule1 = new SubjectSchedule(prog2, faculty1, "IT201-A", "Monday", 
                                                              LocalTime.of(8, 0), LocalTime.of(11, 0), "Room 101", 30);
                SubjectSchedule schedule2 = new SubjectSchedule(prog2, faculty1, "IT201-B", "Wednesday", 
                                                              LocalTime.of(13, 0), LocalTime.of(16, 0), "Room 102", 30);
                subjectScheduleRepository.save(schedule1);
                subjectScheduleRepository.save(schedule2);
            }
            
            if (database1 != null && faculty4 != null) {
                SubjectSchedule schedule3 = new SubjectSchedule(database1, faculty4, "IT202-A", "Tuesday", 
                                                              LocalTime.of(8, 0), LocalTime.of(11, 0), "Room 201", 25);
                SubjectSchedule schedule4 = new SubjectSchedule(database1, faculty4, "IT202-B", "Thursday", 
                                                              LocalTime.of(13, 0), LocalTime.of(16, 0), "Room 202", 25);
                subjectScheduleRepository.save(schedule3);
                subjectScheduleRepository.save(schedule4);
            }
            
            if (webDev2 != null && faculty2 != null) {
                SubjectSchedule schedule5 = new SubjectSchedule(webDev2, faculty2, "IT203-A", "Monday", 
                                                              LocalTime.of(13, 0), LocalTime.of(16, 0), "Lab 301", 20);
                SubjectSchedule schedule6 = new SubjectSchedule(webDev2, faculty2, "IT203-B", "Friday", 
                                                              LocalTime.of(8, 0), LocalTime.of(11, 0), "Lab 302", 20);
                subjectScheduleRepository.save(schedule5);
                subjectScheduleRepository.save(schedule6);
            }
            
            if (networking != null && faculty5 != null) {
                SubjectSchedule schedule7 = new SubjectSchedule(networking, faculty5, "IT204-A", "Wednesday", 
                                                              LocalTime.of(8, 0), LocalTime.of(11, 0), "Room 401", 28);
                subjectScheduleRepository.save(schedule7);
            }
            
            if (dataStruct != null && faculty3 != null) {
                SubjectSchedule schedule8 = new SubjectSchedule(dataStruct, faculty3, "IT205-A", "Tuesday", 
                                                              LocalTime.of(13, 0), LocalTime.of(16, 0), "Room 501", 25);
                SubjectSchedule schedule9 = new SubjectSchedule(dataStruct, faculty3, "IT205-B", "Thursday", 
                                                              LocalTime.of(8, 0), LocalTime.of(11, 0), "Room 502", 25);
                subjectScheduleRepository.save(schedule8);
                subjectScheduleRepository.save(schedule9);
            }
            
            // Third Year Schedules
            Subject softEng = subjectRepository.findBySubjectCode("IT-301").orElse(null);
            Subject database2 = subjectRepository.findBySubjectCode("IT-302").orElse(null);
            Subject webFramework = subjectRepository.findBySubjectCode("IT-303").orElse(null);
            Subject mobileDev = subjectRepository.findBySubjectCode("IT-304").orElse(null);
            Subject cybersec = subjectRepository.findBySubjectCode("IT-305").orElse(null);
            
            if (softEng != null && faculty3 != null) {
                SubjectSchedule schedule10 = new SubjectSchedule(softEng, faculty3, "IT301-A", "Monday", 
                                                               LocalTime.of(8, 0), LocalTime.of(11, 0), "Room 601", 30);
                subjectScheduleRepository.save(schedule10);
            }
            
            if (database2 != null && faculty4 != null) {
                SubjectSchedule schedule11 = new SubjectSchedule(database2, faculty4, "IT302-A", "Tuesday", 
                                                               LocalTime.of(8, 0), LocalTime.of(11, 0), "Lab 601", 20);
                subjectScheduleRepository.save(schedule11);
            }
            
            if (webFramework != null && faculty2 != null) {
                SubjectSchedule schedule12 = new SubjectSchedule(webFramework, faculty2, "IT303-A", "Wednesday", 
                                                               LocalTime.of(13, 0), LocalTime.of(16, 0), "Lab 602", 22);
                subjectScheduleRepository.save(schedule12);
            }
            
            if (mobileDev != null && faculty1 != null) {
                SubjectSchedule schedule13 = new SubjectSchedule(mobileDev, faculty1, "IT304-A", "Thursday", 
                                                               LocalTime.of(8, 0), LocalTime.of(11, 0), "Lab 603", 25);
                subjectScheduleRepository.save(schedule13);
            }
            
            if (cybersec != null && faculty5 != null) {
                SubjectSchedule schedule14 = new SubjectSchedule(cybersec, faculty5, "IT305-A", "Friday", 
                                                               LocalTime.of(13, 0), LocalTime.of(16, 0), "Room 701", 30);
                subjectScheduleRepository.save(schedule14);
            }
        }

        // Create enrollment period
        if (enrollmentPeriodRepository.count() == 0) {
            EnrollmentPeriod period = new EnrollmentPeriod(
                "1st Semester", 
                "2024-2025", 
                LocalDateTime.now().minusDays(1), 
                LocalDateTime.now().plusDays(30), 
                true
            );
            enrollmentPeriodRepository.save(period);
        }

        // Create sample grades for demonstration
        if (gradeRepository.count() == 0) {
            Student student1 = studentRepository.findByStudentId("2021-0001").orElse(null);
            Faculty faculty1 = facultyRepository.findByFacultyId("FAC-001").orElse(null);
            Subject prog1 = subjectRepository.findBySubjectCode("IT-101").orElse(null);
            Subject webDev1 = subjectRepository.findBySubjectCode("IT-102").orElse(null);
            
            if (student1 != null && faculty1 != null && prog1 != null) {
                Grade grade1 = new Grade(student1, prog1, faculty1, "IT101-A", "1st Semester", "2023-2024");
                grade1.setMidtermGrade(85.0);
                grade1.setFinalGrade(88.0);
                grade1.calculateFinalRating();
                gradeRepository.save(grade1);
            }
            
            if (student1 != null && faculty1 != null && webDev1 != null) {
                Grade grade2 = new Grade(student1, webDev1, faculty1, "IT102-A", "1st Semester", "2023-2024");
                grade2.setMidtermGrade(90.0);
                grade2.setFinalGrade(92.0);
                grade2.calculateFinalRating();
                gradeRepository.save(grade2);
            }
        }
    }
} 