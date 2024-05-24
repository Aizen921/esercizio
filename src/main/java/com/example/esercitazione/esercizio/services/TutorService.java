package com.example.esercitazione.esercizio.services;

import com.example.esercitazione.esercizio.dao.TutorDAO;
import com.example.esercitazione.esercizio.dto.TutorDTO;
import com.example.esercitazione.esercizio.entities.Tutor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorService {
    @Autowired
    private TutorDAO tutorDAO;
    @Autowired
    private ModelMapper modelMapper;
    public Tutor createTutor(Tutor tutor){
        Tutor tutorSaved = tutorDAO.save(tutor);
        return tutor;
    }

    public List<TutorDTO> getTutorDTOList(){
        List<Tutor> tutorList = tutorDAO.findAll();
        List<TutorDTO> tutorDTOList = new ArrayList<TutorDTO>();
        for(Tutor tutor: tutorList) {
            TutorDTO tutorDTO = modelMapper.map(tutor, TutorDTO.class);
            tutorDTOList.add(tutorDTO);
        }
        return tutorDTOList;
    }
    public TutorDTO getTutorById(Long id){
        Optional<Tutor> tutor = tutorDAO.findById(id);
        TutorDTO tutorDTO = modelMapper.map(tutor,TutorDTO.class);
        return tutorDTO;
    }
    public void deleteById(Long id){
        tutorDAO.deleteById(id);
    }
}
