package it.objectmethod.jpa_world_query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.objectmethod.jpa_world_query.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
@Query("select r from Review r where r.idcity=?1")
public List<Review> findByIdCity(int idcity);
}

