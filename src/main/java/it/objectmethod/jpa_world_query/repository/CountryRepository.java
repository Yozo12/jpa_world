package it.objectmethod.jpa_world_query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpa_world_query.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query("select distinct continent  from Country")
	public List<String> getAllContinent();

	public List<Country> findByContinent(String continent);


}