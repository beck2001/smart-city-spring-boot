package com.sharibekoff.smartcity.repository;

import com.sharibekoff.smartcity.model.ERole;
import com.sharibekoff.smartcity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
