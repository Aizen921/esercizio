package com.example.esercitazione.esercizio.dao;

import com.example.esercitazione.esercizio.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {
}
