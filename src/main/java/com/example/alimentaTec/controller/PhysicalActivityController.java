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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.alimentaTec.model.PhysicalActivity;
import com.example.alimentaTec.service.PhysicalActivityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("physicalActivities")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@Tag(name = "Physical Activities", description = "Various physical activities")
public class PhysicalActivityController {

	@Autowired
	private PhysicalActivityService service;

	@Operation(summary = "Get all accounts with pagination")
	@GetMapping(value = "pagination", params = { "page", "size" })
	public List<PhysicalActivity> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int 
	page,
	
	@RequestParam(value = "size", defaultValue = "10", required = false) int pageSize) {
		List<PhysicalActivity> physicalActivities = service.getAll(page, pageSize);
		return physicalActivities;
	}


	@Operation(summary = "Get a physical activities by his or her Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Activity found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PhysicalActivity.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid activity", content = @Content),
			@ApiResponse(responseCode = "404", description = "Activity not found", content = @Content) })

	@GetMapping("{idActivity}")
	public ResponseEntity<?> getByIdActivity(@PathVariable Integer idActivity) {
		PhysicalActivity physicalActivity = service.getByIdActivity(idActivity);
		return new ResponseEntity<PhysicalActivity>(physicalActivity, HttpStatus.OK);
	}

	@Operation(summary = "Create a physical activities")
	@PostMapping()
	public ResponseEntity<?> createActivity(@RequestBody PhysicalActivity activity) {
		service.save(activity);
		return new ResponseEntity<String>("Activity created", HttpStatus.CREATED);
	}

	@Operation(summary = "Update a physical activities")
	@PutMapping("{idActivity}")
	public ResponseEntity<?> update(@RequestBody PhysicalActivity physicalActivity, @PathVariable Integer idActivity) {
		PhysicalActivity auxStudent = service.getByIdActivity(idActivity);
		physicalActivity.setIdActivity(auxStudent.getIdActivity());
		service.save(physicalActivity);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

}
