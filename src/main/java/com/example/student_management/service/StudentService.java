package com.example.student_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.student_management.dto.CreateStudentRequest;
import com.example.student_management.dto.UpdateStudentRequest;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.DuplicateStudentException;
import com.example.student_management.exception.StudentNotFoundException;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Student create(CreateStudentRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new DuplicateStudentException("Email already exists: " + request.email());
        }

        Student student = new Student(
            request.name(),
            request.email(),
            request.age(),
            request.address(),
            request.phone()
        );

        return repository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    @Transactional
    public Student update(Long id, UpdateStudentRequest request) {
        Student student = getById(id);

        if (request.email() != null
                && repository.existsByEmailAndIdNot(request.email(), id)) {
            throw new DuplicateStudentException("Email already exists: " + request.email());
        }

        if (request.name() != null) student.setName(request.name());
        if (request.email() != null) student.setEmail(request.email());
        if (request.age() != null) student.setAge(request.age());
        if (request.address() != null) student.setAddress(request.address());
        if (request.phone() != null) student.setPhone(request.phone());

        return student;
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }
}