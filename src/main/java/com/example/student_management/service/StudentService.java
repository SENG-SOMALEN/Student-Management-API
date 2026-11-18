package com.example.student_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {
    
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        return this.repository.save(student);
    }

    public List<Student> getAll() {
        return this.repository.findAll();
    }

    public Student getById(Long id) {
        return this.repository.findById(id)
                              .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student update(Long id, Student student) {
        Student existing = getById(id);

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());

        return this.repository.save(existing);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
