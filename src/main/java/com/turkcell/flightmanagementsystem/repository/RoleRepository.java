package com.turkcell.flightmanagementsystem.repository;

import com.turkcell.flightmanagementsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findAllByNameIn(List<String> names);

}
