package dev.janaite.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.janaite.movieflix.dto.GenreDTO;
import dev.janaite.movieflix.repositories.GenreRepository;

@Service
public class GenreService {
	@Autowired
	private GenreRepository repository;

	@Transactional(readOnly = true)
	public List<GenreDTO> getAllGenres() {
		return repository.findAll().stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
	}
}
