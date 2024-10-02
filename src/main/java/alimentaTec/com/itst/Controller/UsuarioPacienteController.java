package alimentaTec.com.itst.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import alimentaTec.com.itst.Model.UsuarioPaciente;
import alimentaTec.com.itst.Service.UsuarioPacienteService;

@RestController
@RequestMapping("UsuariosPaciente")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UsuarioPacienteController {
    @Autowired
    private UsuarioPacienteService UsuarioPacienteService;

    @GetMapping
    public List <UsuarioPaciente> getAll(){
        return UsuarioPacienteService.getAll();
    }

    @GetMapping ("UsuarioPaciente_id")
    public ResponseEntity<UsuarioPaciente> getByUsuarioPaciente_id (@PathVariable Integer UsuarioPaciente_id){
        UsuarioPaciente usuarioPaciente = UsuarioPacienteService.getByUsuarioPaciente_id(UsuarioPaciente_id);
        return new ResponseEntity<UsuarioPaciente>(usuarioPaciente,HttpStatus.OK);
    }

    @PostMapping
	public void registrar(@RequestBody UsuarioPaciente usuarioPaciente) {
		UsuarioPacienteService.save(usuarioPaciente);
	}
    
     
    @PutMapping("{UsuarioPaciente_id}")
	public ResponseEntity<?> update(@RequestBody UsuarioPaciente UsuarioPaciente, @PathVariable Integer UsuarioPaciente_id) {
		try {
			UsuarioPaciente auxUsuarioPaciente = UsuarioPacienteService.getByUsuarioPaciente_id(UsuarioPaciente_id);
			UsuarioPaciente.setUsuarioPaciente_id(auxUsuarioPaciente.getUsuarioPaciente_id());
			UsuarioPacienteService.save(UsuarioPaciente);
			return new ResponseEntity<String>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}


    @DeleteMapping("{UsuarioPaciente_id}")
	public void delete(@PathVariable Integer UsuarioPaciente_id) {
		UsuarioPacienteService.delete(UsuarioPaciente_id);
	}

}