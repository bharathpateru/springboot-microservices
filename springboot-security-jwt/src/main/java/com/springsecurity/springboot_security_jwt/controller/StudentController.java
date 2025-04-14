package com.springsecurity.springboot_security_jwt.controller;

import com.springsecurity.springboot_security_jwt.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private List<Student>  studentsList = new ArrayList<>( List.of(
            new Student(1, "Bharath", 99),
            new Student(1, "Laxman", 95)
    ));
    @GetMapping("/msg")
    public String getWelcomeMessage(){
        return "Welcome to Spring boot Tutorial";
    }

    @GetMapping("/list")
    public List<Student> getStudentsList(){
        return studentsList;
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student){
        Student s = new Student(student.getId(), student.getName(), student.getMarks());
        studentsList.add(s);
        return s;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
