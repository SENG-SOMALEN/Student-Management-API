package com.example.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateStudentRequest(
      @Size (min = 2, max = 100) String name,
      @Email String email,
      @Min (1) @Max (120) Integer age,
      @Size (max = 255) String address,
      @Pattern (regexp = "^\\+?[0-9]{8,15}$") String phone
) {
}
