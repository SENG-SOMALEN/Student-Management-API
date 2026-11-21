package com.example.student_management.repository;

import com.example.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StudentRepository extends JpaRepository<Student, Long>{
    boolean existsByEmailAndIdNot(String email, Long id);
}
