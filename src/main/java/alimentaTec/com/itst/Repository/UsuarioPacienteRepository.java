package alimentaTec.com.itst.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alimentaTec.com.itst.Model.UsuarioPaciente;
@Repository
public interface UsuarioPacienteRepository extends JpaRepository<UsuarioPaciente, Integer> {
    
}
