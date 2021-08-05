package dev.janaite.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.janaite.movieflix.dto.MovieCompleteDTO;
import dev.janaite.movieflix.dto.MovieSimpleDTO;
import dev.janaite.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService service;

	@GetMapping
	public ResponseEntity<Page<MovieSimpleDTO>> findAllByGenre(Pageable pageable,
			@RequestParam(name = "genreId", defaultValue = "0", required = false) Long genreId) {
		Page<MovieSimpleDTO> page = service.findAllByGenrePaged(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieCompleteDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
}
