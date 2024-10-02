package alimentaTec.com.itst.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alimentaTec.com.itst.Model.Nutriologo;
@Repository
public interface NutriologoRepository extends JpaRepository<Nutriologo, Integer> {
    
}
