package dev.janaite.movieflix.dto;

import java.io.Serializable;

import dev.janaite.movieflix.entities.Movie;

public class MovieCompleteDTO extends MovieSimpleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String synopsis;
	private GenreDTO genre;

	public MovieCompleteDTO() {
	}

	public MovieCompleteDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis,
			GenreDTO genre) {
		super(id, title, subTitle, year, imgUrl);
		this.synopsis = synopsis;
		this.genre = genre;
	}

	public MovieCompleteDTO(Movie entity) {
		super(entity);
		synopsis = entity.getSynopsis();
		genre = new GenreDTO(entity.getGenre());
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}

}
