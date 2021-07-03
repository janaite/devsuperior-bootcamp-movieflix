package dev.janaite.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.movieflix.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
