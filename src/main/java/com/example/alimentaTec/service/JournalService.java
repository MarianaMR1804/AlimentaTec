package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import com.example.alimentaTec.model.Journal;
import com.example.alimentaTec.model.Goal;
import com.example.alimentaTec.repository.JournalRepository;
import com.example.alimentaTec.dto.JournalDTO;
import jakarta.transaction.Transactional;
import com.example.alimentaTec.model.Saucer;
import com.example.alimentaTec.model.PhysicalActivity;
import com.example.alimentaTec.model.Login;
import com.example.alimentaTec.repository.SaucerRepository;
import com.example.alimentaTec.repository.PhysicalActivityRepository;
import com.example.alimentaTec.repository.GoalRepository;
import com.example.alimentaTec.repository.LoginRepository;

@Service
@Transactional
public class JournalService {
    @Autowired
    private JournalRepository repo;

    @Autowired
    private SaucerRepository saucerRepo;

    @Autowired
    private PhysicalActivityRepository activityRepo;

    @Autowired
    private GoalRepository goalRepo;

    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<Journal> getAll(){
        return repo.findAll();
    }

    public List<Journal> getAll(int page, int pageSize) {
        PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Journal> journal = repo.findAll(pageReq);
        return journal.getContent();
    }

    public Journal save(Journal journal) {
        return repo.save(journal);
    }

    public Journal save(JournalDTO journalDTO) {
        Journal journal = convertToEntity(journalDTO);
        return repo.save(journal);
    }

    public Journal getIdJournal(Integer idJournal) {
        return repo.findById(idJournal).get();
    }

    public void delete(Integer idJournal) {
        repo.deleteById(idJournal);
    }
    public Journal convertToEntity(JournalDTO journalDTO) {
        Journal journal = modelMapper.map(journalDTO, Journal.class);
        
        // Convertir idGoal a un objeto Goal
        if (journalDTO.getIdGoal() != null) {
            Goal goal = new Goal();
            goal.setIdGoal(journalDTO.getIdGoal());
            journal.setGoal(goal);
        }

        // Convertir idSaucer a un objeto Saucer
        if (journalDTO.getIdSaucer() != null) {
            Saucer saucer = new Saucer();
            saucer.setIdSaucer(journalDTO.getIdSaucer());
            journal.setSaucer(saucer);
        }

        // Convertir idActivity a un objeto PhysicalActivity
        if (journalDTO.getIdActivity() != null) {
            PhysicalActivity physicalActivity = new PhysicalActivity();
            physicalActivity.setIdActivity(journalDTO.getIdActivity());
            journal.setPhysicalActivity(physicalActivity);
        }

        // Convertir idUser a un objeto Login
        if (journalDTO.getIdUser() != null) {
            Login login = new Login();
            login.setIdUser(journalDTO.getIdUser());
            journal.setLogin(login);
        }

        return journal;
    }

    public Saucer getByIdSaucer(Integer idSaucer) {
        return saucerRepo.findById(idSaucer).orElse(null);
    }

    public PhysicalActivity getByIdActivity(Integer idActivity) {
        return activityRepo.findById(idActivity).orElse(null);
    }

    public Goal getByIdGoal(Integer idGoal) {
        return goalRepo.findById(idGoal).orElse(null);
    }

    public Login getByIdLogin(Integer idUser) {
        return loginRepo.findById(idUser).orElse(null);
    }
}