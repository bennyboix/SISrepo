package com.sisregistration.bmwsis.controller;

import com.sisregistration.bmwsis.entity.*;
import com.sisregistration.bmwsis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "student-login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String studentId, 
                       @RequestParam String password,
                       HttpSession session,
                       RedirectAttributes redirectAttributes) {
        
        Optional<Student> studentOpt = studentService.authenticateStudent(studentId, password);
        
        if (studentOpt.isPresent()) {
            session.setAttribute("loggedInStudent", studentOpt.get());
            return "redirect:/student/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid student ID or password");
            return "redirect:/student/login";
        }
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/student/login";
        }
        
        model.addAttribute("student", student);
        return "student-dashboard";
    }
    
    @GetMapping("/grades")
    public String viewGrades(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/student/login";
        }
        
        List<Grade> grades = studentService.getStudentGrades(student);
        model.addAttribute("student", student);
        model.addAttribute("grades", grades);
        return "student-grades";
    }
    
    @GetMapping("/schedule")
    public String viewSchedule(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/student/login";
        }
        
        List<Enrollment> enrollments = studentService.getStudentSchedules(student);
        model.addAttribute("student", student);
        model.addAttribute("enrollments", enrollments);
        return "student-schedule";
    }
    
    @GetMapping("/enroll")
    public String showEnrollmentPage(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/student/login";
        }
        
        boolean enrollmentOpen = studentService.isEnrollmentOpen();
        List<SubjectSchedule> availableSchedules = studentService.getAvailableSchedulesForStudent(student);
        
        model.addAttribute("student", student);
        model.addAttribute("enrollmentOpen", enrollmentOpen);
        model.addAttribute("availableSchedules", availableSchedules);
        return "student-enrollment";
    }
    
    @PostMapping("/enroll")
    public String enrollInSubject(@RequestParam Long scheduleId,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/student/login";
        }
        
        boolean success = studentService.enrollStudent(student, scheduleId);
        
        if (success) {
            redirectAttributes.addFlashAttribute("success", "Successfully enrolled in the subject!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Failed to enroll. Either enrollment is closed or the class is full.");
        }
        
        return "redirect:/student/enroll";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/student/login";
    }
} 