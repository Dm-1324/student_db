package com.example.student_db.service;


import com.example.student_db.dto.StudentDto;
import com.example.student_db.entity.Student;
import com.example.student_db.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(StudentDto dto) {
        Student s = new Student(dto.getName(), dto.getMajor());
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(Long rollNo) {
        return repo.findById(rollNo);
    }

    public void updateStudent(Long rollNo, StudentDto dto) {
        Student student = repo.findById(rollNo)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + rollNo));

        student.setName(dto.getName());
        student.setMajor(dto.getMajor());

        repo.save(student);
    }

    public void deleteStudent(Long rollNo) {
        repo.deleteById(rollNo);
    }

}
