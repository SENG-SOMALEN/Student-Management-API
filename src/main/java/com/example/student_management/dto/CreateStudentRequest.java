package com.example.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateStudentRequest(

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50,
          message = "Name must be 3-50 characters")
    String name,

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email,

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must not exceed 60")
    Integer age,

    @NotBlank(message = "Address is required")
    String address,

    @NotBlank(message = "Phone is required")
    @Size(min = 9, max = 15,
          message = "Phone must be 9-15 characters")
    String phone

) {
}