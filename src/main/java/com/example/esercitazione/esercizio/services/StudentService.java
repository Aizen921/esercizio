package com.example.esercitazione.esercizio.services;

import com.example.esercitazione.esercizio.dao.StudentDAO;
import com.example.esercitazione.esercizio.dto.StudentDTO;
import com.example.esercitazione.esercizio.entities.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private ModelMapper modelMapper;

    public Student createStudent(Student student){
        Student studentSaved = studentDAO.save(student);
        return  student;
    }
    public List<StudentDTO> getAllStudent(){
        List<Student> studentList = studentDAO.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student : studentList){
            StudentDTO studentDTO = modelMapper.map(student,StudentDTO.class);
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
    public StudentDTO getStudentById(Long id){
        Optional<Student> student = studentDAO.findById(id);
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }
    public void deleteStudentById(Long id){
        studentDAO.deleteById(id);
    }
}
