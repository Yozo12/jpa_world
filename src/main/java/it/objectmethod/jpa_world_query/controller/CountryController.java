package it.objectmethod.jpa_world_query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpa_world_query.repository.CountryRepository;

@RestController
@CrossOrigin

public class CountryController {
	@Autowired CountryRepository countryRepo;
	
 @GetMapping("/continent")
 public List<String>findDistinctContinent(){
	 List<String>listContinent=countryRepo.getAllContinent();
	 return listContinent;
	 
 }
}
