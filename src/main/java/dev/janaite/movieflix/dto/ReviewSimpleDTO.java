package dev.janaite.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class ReviewSimpleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo requerido")
	private String text;
	
	private Long movieId;
	
	public ReviewSimpleDTO() {
	}

	public ReviewSimpleDTO(String text, Long movieId) {
		super();
		this.text = text;
		this.movieId = movieId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
}
