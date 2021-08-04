package dev.janaite.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.movieflix.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}
