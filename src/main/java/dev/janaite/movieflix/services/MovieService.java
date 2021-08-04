package dev.janaite.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.janaite.movieflix.dto.MovieDTO;
import dev.janaite.movieflix.entities.Movie;
import dev.janaite.movieflix.repositories.MovieRepository;
import dev.janaite.movieflix.servicesexceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie movie = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(movie);
	}
}
