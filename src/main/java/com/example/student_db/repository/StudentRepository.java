package com.example.student_db.repository;

import com.example.student_db.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    // SELECT s FROM Student s WHERE s.major = ?1
    List<Student> findByMajor(String major);


    // Find students whose rollNo is less than a given number (e.g., for a 'top' group)
    @Query("SELECT s FROM Student s WHERE s.rollNo < :maxRollNo ORDER BY s.rollNo ASC")
    List<Student> findTopRollNos(Long maxRollNo);

    
    // Find students whose name contains a given keyword
    @Query(value = "SELECT * FROM students WHERE name LIKE %:nameKeyword%", nativeQuery = true)
    List<Student> searchByName(String nameKeyword);
}