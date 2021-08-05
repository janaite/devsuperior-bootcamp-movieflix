package dev.janaite.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.movieflix.entities.Genre;
import dev.janaite.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Page<Movie> findAllByGenre(Genre genre, Pageable pageable);

}
