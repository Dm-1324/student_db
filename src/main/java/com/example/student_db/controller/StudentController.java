package com.example.student_db.controller;

import com.example.student_db.dto.StudentDto;
import com.example.student_db.entity.Student;
import com.example.student_db.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto dto) {
        Student newStudent = service.addStudent(dto);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long rollNo) {
        Optional<Student> student = service.getStudentById(rollNo);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{rollNo}")
    public ResponseEntity<String> updateStudent(@PathVariable Long rollNo, @RequestBody StudentDto dto) {
        try {
            service.updateStudent(rollNo, dto);
            return ResponseEntity.ok("Student details updated successfully!");
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long rollNo) {
        service.deleteStudent(rollNo);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}