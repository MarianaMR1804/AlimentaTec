package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.Nutritionist;
import com.example.alimentaTec.repository.NutritionistRespository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NutritionistService {
    @Autowired
    private NutritionistRespository repo;

		public List<Nutritionist> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Nutritionist> nutritionist = repo.findAll(pageReq);
		return nutritionist.getContent();
	}
    public void save(Nutritionist nutritionist) {
        repo.save(nutritionist);
    }

    public Nutritionist getByIdNutritionist(Integer idNutritionist) {
        return repo.findById(idNutritionist).get();
    }

    public void delete(Integer idNutritionist) {
        repo.deleteById(idNutritionist);
    }
    
    public List<Nutritionist> searchbyNutritionistName(String nutritionistName){
    return repo.searchbyNutritionistName (nutritionistName);
    }
}
