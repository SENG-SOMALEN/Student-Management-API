package com.example.student_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;

@RestController
@RequestMapping ("/v1/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return this.service.create(student);
    }

    //READ ALL
    @GetMapping
    public List<Student> getAll() {
        return this.service.getAll();
    }

    //READ ONLY
    @GetMapping ("/{id}")
    public Student getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    //UPDATE
    @PutMapping ("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return this.service.update(id, student);
    }

    //DELETE
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable Long id) {
        this.service.delete(id);

        return "Student deleted successfullt!";
    }
}
