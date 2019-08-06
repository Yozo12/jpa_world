package it.objectmethod.jpa_world_query.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpa_world_query.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	public List<City> findByCodeCountry(String nazione);

	public City findById(int cityid);

	public List<City> findByCodeCountryOrderByNameAsc(String codNazione);

	public List<City> findByCodeCountryOrderByNameDesc(String codNazione);

	public List<City> findByCodeCountryOrderByPopulationAsc(String codNazione);

	public List<City> findByCodeCountryOrderByPopulationDesc(String codNazione);
	@Query("Select c from City c where c.name like concat(?1,'%')")
	public List<City>findCityLike(String name ,Pageable pageble);
	

//	@Query("UPDATE City SET city.name =?1, city.population=?2, city.codeCountry =?3 where city.id= ?4")
//	public City modCity(City city);
//
//	@Query("INSERT INTO City(name, population, codeCountry) VALUES (?1 , ?2 , ?3)")
//	public City addCity(City city);
//__________________________le query sopra si sostituiscono con Repo.save(City)______________________________
}