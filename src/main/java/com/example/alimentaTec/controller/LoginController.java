package com.example.alimentaTec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.alimentaTec.model.Login;
import com.example.alimentaTec.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("logins")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })

@Tag(name = "Logins", description = "Types of logins")
public class LoginController {

	@Autowired
	private LoginService service;

	@Operation(summary = "Get all Login")
	@ApiResponse(responseCode = "200", description = "Found Login", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Login.class))) })

	@GetMapping
	public List<Login> getAll() {
		return service.getAll();
	}

	@Operation(summary = "Get a Login by his or her Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Login found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Login.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Id supplied", content = @Content) })
	@GetMapping("{idUser}")
	public ResponseEntity<?> getByIdlogin(@PathVariable Integer idUser) {
		Login login = service.getByIdLogin(idUser);
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

	@Operation(summary = "Register a Login")
	@PostMapping
	public ResponseEntity<?> register(@RequestBody Login login) {
		service.save(login);
		return new ResponseEntity<String>("Saved record", HttpStatus.CREATED);
	}

	@Operation(summary = "Update a Login")
	@PutMapping("{idUser}")
	public ResponseEntity<?> update(@RequestBody Login login, @PathVariable Integer idUser) {
		Login auxLogin = service.getByIdLogin(idUser);
		login.setIdUser(auxLogin.getIdUser());
		service.save(login);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}
}