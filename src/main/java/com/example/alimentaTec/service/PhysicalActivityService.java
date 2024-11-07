package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.PhysicalActivity;
import com.example.alimentaTec.repository.PhysicalActivityRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PhysicalActivityService {
    @Autowired
    private PhysicalActivityRepository repo;

    public List<PhysicalActivity> getAll(){
        return repo.findAll();
    }

    public void save(PhysicalActivity physicalActivity) {
		repo.save(physicalActivity);
	}

	public PhysicalActivity getByIdActivity(Integer idActivity) {
		return repo.findById(idActivity).get();
	}

	public void delete(Integer idActivity) {
		repo.deleteById(idActivity);
	}
}