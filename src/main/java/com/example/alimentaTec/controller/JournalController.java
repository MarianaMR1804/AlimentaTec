package com.example.alimentaTec.controller;

import org.modelmapper.ModelMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.alimentaTec.dto.JournalDTO;
import com.example.alimentaTec.model.Journal;
import com.example.alimentaTec.service.JournalService;

@Controller
public class JournalController {
	@Autowired
	private JournalService service;
	
    @Autowired
	private ModelMapper modelMapper;
	@QueryMapping
	public List<Journal> journals() {
		return service.getAll();
	}
	
	@QueryMapping
	public Journal journalById(@Argument Integer idJournal) {
		return service.getIdJournal(idJournal);
	}
	
	@MutationMapping
	public Journal createJournal(@Argument(value = "journal") JournalDTO journalDTO) {
		return service.save(convertToEntity(journalDTO));
	}
	
	//@MutationMapping
	//public Journal updateJournal(@Argument Integer idJournal, @Argument(value = "journal") JournalDTO journalDTO) {
	//	Journal existingJournal = service.getIdJournal(idJournal);
	//	journalDTO.setIdJournal(existingJournal.());
	//	return service.save(journal);
	//}
	
	@MutationMapping
	public Boolean deleteJournal(@Argument Integer idJournal) {
		service.delete(idJournal);
		return true;
	}

	public Journal convertToEntity(JournalDTO journalDTO) {
		return modelMapper.map(journalDTO, Journal.class);
	}
}
