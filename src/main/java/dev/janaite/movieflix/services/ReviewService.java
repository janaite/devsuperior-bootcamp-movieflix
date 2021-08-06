package dev.janaite.movieflix.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.janaite.movieflix.dto.ReviewDTO;
import dev.janaite.movieflix.dto.ReviewSimpleDTO;
import dev.janaite.movieflix.entities.Movie;
import dev.janaite.movieflix.entities.Review;
import dev.janaite.movieflix.entities.User;
import dev.janaite.movieflix.repositories.MovieRepository;
import dev.janaite.movieflix.repositories.ReviewRepository;
import dev.janaite.movieflix.servicesexceptions.ResourceNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private AuthService authService;

	@Transactional
	public ReviewDTO insert(ReviewSimpleDTO dto) {
		try {
			Review entity = new Review();

			Movie movie = movieRepository.getOne(dto.getMovieId()); // getOne do not access database until you save the
																	// entity

//			Movie movie = movieRepository	.findById(dto.getMovieId())
//											.orElseThrow(() -> new ResourceNotFoundException(
//													String.format("Movie ID not found [%d]", dto.getMovieId())));
			User currentUser = authService.getCurrentUserAuthenticated();

			entity.setText(dto.getText());
			entity.setMovie(movie);
			entity.setUser(currentUser);
			entity = repository.save(entity);

			return new ReviewDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(String.format("Movie ID not found [%d]", dto.getMovieId()));
		}
	}

}
