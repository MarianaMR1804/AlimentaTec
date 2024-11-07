package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.Goal;

import com.example.alimentaTec.repository.GoalRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GoalService {
    @Autowired
    private GoalRepository repo;

    public List<Goal> getAll(){
        return repo.findAll();
    }

    public void save(Goal goal) {
		repo.save(goal);
	}

	public Goal getByIdGoal(Integer idGoal) {
		return repo.findById(idGoal).get();
	}

	public void delete(Integer idGoal) {
		repo.deleteById(idGoal);
	}

	public List<Goal> buscarPorNombre(String nameGoal) {
        return repo.buscarPorNombre(nameGoal);
    }
}
