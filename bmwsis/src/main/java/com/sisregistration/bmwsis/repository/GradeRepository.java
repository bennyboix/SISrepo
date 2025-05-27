package com.sisregistration.bmwsis.repository;

import com.sisregistration.bmwsis.entity.Grade;
import com.sisregistration.bmwsis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudent(Student student);
    List<Grade> findByStudentOrderBySemesterAscAcademicYearAsc(Student student);
} 