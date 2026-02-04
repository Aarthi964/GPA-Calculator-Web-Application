package com.example.gpacalculator.service;

import com.example.gpacalculator.model.Grade;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    private final List<Grade> grades = new ArrayList<>();

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getAllGrades() {
        return grades;
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;

        double totalPoints = 0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            double gradePoint = convertGradeToPoint(grade.getGrade());
            totalPoints += gradePoint * grade.getCredits();
            totalCredits += grade.getCredits();
        }

        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }

    private double convertGradeToPoint(String grade) {
        return switch (grade.toUpperCase()) {
            case "A+" -> 10.0;
            case "A" -> 9.0;
            case "B+" -> 8.0;
            case "B" -> 7.0;
            case "C" -> 6.0;
            case "D" -> 5.0;
            case "F" -> 0.0;
            default -> 0.0;
        };
    }
}
