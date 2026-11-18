package com.example.student_management.entity;

import jakarta.persistence.*;

@Entity // #Database Entity
@Table (name = "students") // #Table name
public class Student {

    @Id // #Primary Key
    @GeneratedValue (strategy = GenerationType.IDENTITY) // #Generate ID
    private Long id;

    private String name;

    private String email;

    private Integer age;

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
