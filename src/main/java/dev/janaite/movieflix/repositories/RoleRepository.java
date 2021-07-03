package dev.janaite.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.movieflix.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
