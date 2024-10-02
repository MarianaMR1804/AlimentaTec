package alimentaTec.com.itst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentaTec.com.itst.Model.Nutriologo;
import alimentaTec.com.itst.Repository.NutriologoRepository;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class NutriologoService {
         @Autowired
	private NutriologoRepository repo;

	public List<Nutriologo> getAll() {
		return repo.findAll();
	}

	public void save(Nutriologo Nutriologo) {
		repo.save(Nutriologo);
	}

	public Nutriologo getByNutriologo_id(Integer Nutriologo_id) {
		return repo.findById( Nutriologo_id).get();
	}

	public void delete(Integer Nutriologo_id) {
		repo.deleteById(Nutriologo_id);
	}
}
