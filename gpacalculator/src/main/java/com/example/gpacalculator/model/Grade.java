package com.example.gpacalculator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class Grade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private int credits;
    private String grade;

    //  Default Constructor
    public Grade() {}

    // Parameterized Constructor
    public Grade(String courseName, int credits, String grade) {
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    //  Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
