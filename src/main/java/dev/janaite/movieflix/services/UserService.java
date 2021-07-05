package dev.janaite.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.janaite.movieflix.dto.UserDTO;
import dev.janaite.movieflix.entities.User;

@Service
public class UserService {
	@Autowired
	private AuthService authService;

	public UserDTO getProfileForCurrentUser() {
		User user = authService.getCurrentUserAuthenticated();
		UserDTO dto = new UserDTO(user);
		return dto;
	}
}
