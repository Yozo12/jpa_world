package it.objectmethod.jpa_world_query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.objectmethod.jpa_world_query.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	@Query("select a from Author a where a.idauthor=?1")
	public Author findByIdAuthor(int id);
}
