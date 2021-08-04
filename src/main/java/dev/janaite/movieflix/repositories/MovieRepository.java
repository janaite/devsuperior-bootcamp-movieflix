package dev.janaite.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
