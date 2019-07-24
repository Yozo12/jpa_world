package it.objectmethod.jpa_world_query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.jpa_world_query.constants.Constants;
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

	@GetMapping("/citta/load")
	public City cittaLoad(@RequestParam("id") int id) {
		City cityById = null;
		if (id > 0) {
			cityById = cityRepo.findById(id);
		}
		return cityById;
	}

	@PostMapping("/citta")
	public ResponseEntity<Integer> modificaAggiungi(@RequestBody City city) {
		try {
			if (city.getId() > 0) {
				cityRepo.save(city);
			} else if (city.getId() == 0) {
				cityRepo.save(city);
			}
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@GetMapping("/citta")
	public List<City> ordCity(@RequestParam("codNazione") String codNazione, @RequestParam("ord") String ord) {
		List<City> cityList = null;

		if (ord.equals(Constants.AZ)) {
			cityList = cityRepo.findByCodeCountryOrderByNameAsc(codNazione);

		}
		if (ord.equals(Constants.ZA)) {
			cityList = cityRepo.findByCodeCountryOrderByNameDesc(codNazione);
		}
		if (ord.equals(Constants.POPA)) {
			cityList = cityRepo.findByCodeCountryOrderByPopulationAsc(codNazione);

		}
		if (ord.equals(Constants.POPD)) {
			cityList = cityRepo.findByCodeCountryOrderByPopulationDesc(codNazione);

		}
		return cityList;
	}
}
