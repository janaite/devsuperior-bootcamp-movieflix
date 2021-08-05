package dev.janaite.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.janaite.movieflix.dto.MovieCompleteDTO;
import dev.janaite.movieflix.dto.MovieSimpleDTO;
import dev.janaite.movieflix.dto.ReviewDTO;
import dev.janaite.movieflix.entities.Genre;
import dev.janaite.movieflix.entities.Movie;
import dev.janaite.movieflix.entities.Review;
import dev.janaite.movieflix.repositories.GenreRepository;
import dev.janaite.movieflix.repositories.MovieRepository;
import dev.janaite.movieflix.repositories.ReviewRepository;
import dev.janaite.movieflix.servicesexceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Transactional(readOnly = true)
	public MovieCompleteDTO findById(Long id) {
		Movie movie = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieCompleteDTO(movie);
	}

	@Transactional(readOnly = true)
	public Page<MovieSimpleDTO> findAllByGenrePaged(Long genreId, Pageable pageable) {
		// default sort by title
		Sort sort = pageable.getSortOr(Sort.by("title"));
		Pageable newPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

		Page<Movie> pages;
		if (genreId == null || genreId == 0) {
			pages = repository.findAll(newPageable);
		} else {
			Genre genre = genreRepository	.findById(genreId)
											.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
			pages = repository.findAllByGenre(genre, newPageable);
		}

		return pages.map(x -> new MovieSimpleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<ReviewDTO>findAllReviewsByMovieId(Long movieId) {
		Movie movie = repository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
		List<Review> list = reviewRepository.findByMovie(movie);
		return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	}
}
