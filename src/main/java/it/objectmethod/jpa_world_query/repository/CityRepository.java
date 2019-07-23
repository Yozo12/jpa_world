package it.objectmethod.jpa_world_query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpa_world_query.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
