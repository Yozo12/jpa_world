package it.objectmethod.jpa_world_query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpa_world_query.domain.City;
import it.objectmethod.jpa_world_query.repository.CityRepository;

@RestController
@CrossOrigin
public class CityController {
	@Autowired
	CityRepository cityRepo;

	@GetMapping("/citta/elenco")
	public List<City> cittaByNazioni(@RequestParam("nazione") String nazione) {
		List<City> cityList = cityRepo.findByCodeCountry(nazione);
		return cityList;
	}

	@DeleteMapping("/citta/elimina")
	public ResponseEntity<Integer> delete(@RequestParam("id") int cityid) {
		try {
			City cityById = cityRepo.findById(cityid);
			cityRepo.delete(cityById);
		}

		catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
}
