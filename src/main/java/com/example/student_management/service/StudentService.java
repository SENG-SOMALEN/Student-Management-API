package com.example.student_management.service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student_management.dto.CreateStudentRequest;
import com.example.student_management.dto.UpdateStudentRequest;
import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(CreateStudentRequest request) {
        Student student = new Student(
            request.name(),
            request.email(),
            request.age(),
            request.address(),
            request.phone()
        );

        return this.repository.save(student);
    }

    public List<Student> getAll() {
        return this.repository.findAll();
    }

    public Student getById(Long id) {
        return this.repository.findById(id)
                              .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Transactional
    public Optional<Student> update(Long id, UpdateStudentRequest request) {
        return this.repository.findById(id).map(student -> {

            if (request.email() != null
                    && repository.existsByEmailAndIdNot(request.email(), id)) {
                throw new DuplicateFormatFlagsException(request.email());
            }

            if (request.name() != null) student.setName(request.name());
            if (request.email() != null) student.setEmail(request.email());
            if (request.age() != null) student.setAge(request.age());
            if (request.address() != null) student.setAddress(request.address());
            if (request.phone() != null) student.setPhone(request.phone());

            return this.repository.save(student);
        });
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
