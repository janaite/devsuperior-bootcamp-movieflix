package dev.janaite.movieflix.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.janaite.movieflix.entities.User;
import dev.janaite.movieflix.repositories.UserRepository;

@Service
public class UserDetailsCustomService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(UserDetailsCustomService.class);
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error(String.format("User not found: %s", username));
			throw new UsernameNotFoundException(String.format("User \"%s\" not found", username));
		}
		logger.info(String.format("User found: %s", username));
		return user;
	}
}
