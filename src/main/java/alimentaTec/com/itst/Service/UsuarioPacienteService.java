package alimentaTec.com.itst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentaTec.com.itst.Model.UsuarioPaciente;
import alimentaTec.com.itst.Repository.UsuarioPacienteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioPacienteService {
     @Autowired
	private UsuarioPacienteRepository repo;

	public List<UsuarioPaciente> getAll() {
		return repo.findAll();
	}

	public void save(UsuarioPaciente UsuarioPaciente) {
		repo.save(UsuarioPaciente);
	}

	public UsuarioPaciente getByUsuarioPaciente_id(Integer UsuarioPaciente_id) {
		return repo.findById( UsuarioPaciente_id).get();
	}

	public void delete(Integer UsuarioPaciente_id) {
		repo.deleteById(UsuarioPaciente_id);
	}
}
