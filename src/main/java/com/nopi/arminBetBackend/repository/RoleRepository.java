package com.nopi.arminBetBackend.repository;

import com.nopi.arminBetBackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
