package com.example.esercitazione.esercizio.controllers;

import com.example.esercitazione.esercizio.dto.StudentDTO;
import com.example.esercitazione.esercizio.entities.Student;
import com.example.esercitazione.esercizio.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/list")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
    StudentDTO studentDTO = studentService.getStudentById(id);
    return ResponseEntity.ok().body(studentDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        System.out.println("elemento eliminato con successo");
    }
}
