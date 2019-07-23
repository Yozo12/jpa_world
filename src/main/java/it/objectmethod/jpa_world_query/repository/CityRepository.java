package it.objectmethod.jpa_world_query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import it.objectmethod.jpa_world_query.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
 
	public List<City> findByCodeCountry(String nazione);

}
