package dev.janaite.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.movieflix.entities.Movie;
import dev.janaite.movieflix.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByMovie(Movie movie);

}
