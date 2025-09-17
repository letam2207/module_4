package com.codegym.c0525g1.controller;

import com.codegym.c0525g1.entity.Student;
import com.codegym.c0525g1.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.findAll();
//        Phân biệt Model, ModelMap và ModelAndView
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/create")
    public String createStudent(ModelMap model) {
        return "student/create";
    }

    @PostMapping("/create")
    public String createStudent() {
        return "student/list";
    }
}
