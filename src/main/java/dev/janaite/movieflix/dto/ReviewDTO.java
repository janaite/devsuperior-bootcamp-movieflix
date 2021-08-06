package dev.janaite.movieflix.dto;

import java.io.Serializable;

import dev.janaite.movieflix.entities.Review;

public class ReviewDTO extends ReviewSimpleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private UserDTO user;

	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text, Long movieId, UserDTO user) {
		super(text, movieId);
		this.id = id;
		this.user = user;
	}

	public ReviewDTO(Review entity) {
		this(entity.getId(), entity.getText(), entity.getMovie().getId(), new UserDTO(entity.getUser()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
