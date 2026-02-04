package com.example.gpacalculator.controller;

import com.example.gpacalculator.model.Grade;
import com.example.gpacalculator.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/grades")
public class GPAController {
    private final GradeService gradeService;

    public GPAController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    // Show the main page
    @GetMapping("/")
    public String showGradesPage(Model model) {
        model.addAttribute("grades", gradeService.getAllGrades());
        model.addAttribute("gpa", gradeService.calculateGPA());
        return "index";  
    }

    // Add a new grade (AJAX)
    @PostMapping("/add")
    @ResponseBody
    public List<Grade> addGrade(@RequestParam String courseName,
                                @RequestParam int credits,
                                @RequestParam String grade) {
        System.out.println("Received: " + courseName + ", " + credits + ", " + grade);
        Grade newGrade = new Grade(courseName, credits, grade);
        gradeService.addGrade(newGrade);
        return gradeService.getAllGrades();  // Return updated grade list
    }

    // Get all grades (AJAX)
    @GetMapping("/all")
    @ResponseBody
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    // Calculate GPA (AJAX)
    @GetMapping("/gpa")
    @ResponseBody
    public double getGPA() {
        return gradeService.calculateGPA();
    }
}
