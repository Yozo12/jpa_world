package it.objectmethod.jpa_world_query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
import it.objectmethod.jpa_world_query.domain.Author;
import it.objectmethod.jpa_world_query.domain.City;
import it.objectmethod.jpa_world_query.domain.Review;
import it.objectmethod.jpa_world_query.repository.AuthorRepository;
import it.objectmethod.jpa_world_query.repository.CityRepository;
import it.objectmethod.jpa_world_query.repository.ReviewRepository;

@RestController
@CrossOrigin
public class CityController {
	@Autowired
	CityRepository cityRepo;
	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	AuthorRepository authorRepo;

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

	@GetMapping("/reviewforcity")
	public List<Review> reviewList(@RequestParam("idcity") int idcity) {
		List<Review> reviewList = reviewRepo.findByIdCity(idcity);
		return reviewList;
	}

	@GetMapping("/author")
	public Author findAuthor(@RequestParam("idauthor") int idauthor) {
		Author author = authorRepo.findByIdAuthor(idauthor);
		return author;
	}
	

	@PostMapping("/insertauthor")
	public ResponseEntity<Integer> insertAuthor(@RequestBody Author author) {
		try {
			if (author.getIdauthor() == 0 || author.getIdauthor() != 0) {
				authorRepo.save(author);

			}
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	@PostMapping("/insertreview")
	public ResponseEntity<Integer> insertReview(@RequestBody Review review) {
		try {
			if (review.getIdreview() == 0) {
				reviewRepo.save(review);
			}
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	@GetMapping("/citylike")
	public List<City>findCitybyLike(@RequestParam("name")String name){
		List<City> cityList=cityRepo.findCityLike(name, new PageRequest(0, 10));
		return cityList;
	}
	@GetMapping("/allcities")
	public List <City>allCiteis(){
		List<City>cityList=cityRepo.findAll();
		return cityList;
	}
}
