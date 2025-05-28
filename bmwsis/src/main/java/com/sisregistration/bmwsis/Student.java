package com.sisregistration.bmwsis;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Student_LastName")
    private String last_name;

    @Column(name = "Student_FirstName")
    private String first_name;

    @Column(name = "Student_ID")
    private String student_id;

    @Column(name = "Student_Program")
    private String program;

    @Column(name = "Student_Gender")
    private String gender;

    @Column(name = "Student_PhoneNumber")
    private String phone_number;

    @Column(name = "Student_DateOfBirth")
    private String date_of_birth;

    @Column(name = "Student_Email")
    private String email;

    @Column(name = "Student_Address")
    private String address;

    public Student() {
        // JPA requires a no-arg constructor
    }

    public Student(String first_name, String last_name, String student_id, String program, String gender,
            String phone_number, String date_of_birth, String email, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.student_id = student_id;
        this.program = program;
        this.gender = gender;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.address = address;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLast_name() {
        return first_name;
    }

    public void setLast_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return last_name;
    }

    public void setFirst_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
