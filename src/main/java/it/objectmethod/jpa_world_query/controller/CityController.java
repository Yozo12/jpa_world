package it.objectmethod.jpa_world_query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpa_world_query.domain.City;
import it.objectmethod.jpa_world_query.repository.CityRepository;

@RestController
@CrossOrigin
public class CityController {
	@Autowired CityRepository cityRepo;
	
	@GetMapping("/citta/elenco")
	public List<City> cittaByNazioni(@RequestParam("nazione") String nazione){
		List<City> cityList=cityRepo.findByCodeCountry(nazione);
		return cityList;
	}

}
