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

import alimentaTec.com.itst.Model.Nutriologo;
import alimentaTec.com.itst.Service.NutriologoService;

@RestController
@RequestMapping("Nutriologo")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class NutriologoController {
    @Autowired
    private NutriologoService NutriologoService;

    @GetMapping
    public List <Nutriologo> getAll(){
        return NutriologoService.getAll();
    }

    @GetMapping ("Nutriologo_id")
    public ResponseEntity<Nutriologo> getByNutriologo_id (@PathVariable Integer Nutriologo_id){
        Nutriologo nutriologo = NutriologoService.getByNutriologo_id(Nutriologo_id);
        return new ResponseEntity<Nutriologo>(nutriologo,HttpStatus.OK);
    }

    @PostMapping
	public void registrar(@RequestBody Nutriologo nutriologo) {
		NutriologoService.save(nutriologo);
	}
    
     
    @PutMapping("{Nutriologo_id}")
	public ResponseEntity<?> update(@RequestBody Nutriologo Nutriologo, @PathVariable Integer Nutriologo_id) {
		try {
			Nutriologo auxNutriologo = NutriologoService.getByNutriologo_id(Nutriologo_id);
			Nutriologo.setNutriologo_id(auxNutriologo.getNutriologo_id());
			NutriologoService.save(Nutriologo);
			return new ResponseEntity<String>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}


    @DeleteMapping("{Nutriologo_id}")
	public void delete(@PathVariable Integer Nutriologo_id) {
		NutriologoService.delete(Nutriologo_id);
	}

}