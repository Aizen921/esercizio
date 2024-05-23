package com.example.esercitazione.esercizio.dao;

import com.example.esercitazione.esercizio.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorDAO extends JpaRepository<Tutor,Long> {

}
