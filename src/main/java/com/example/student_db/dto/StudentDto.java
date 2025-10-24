package com.example.student_db.dto;


import jakarta.validation.constraints.NotBlank;

public class StudentDto {

    @NotBlank
    private String name;

    private String major;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
