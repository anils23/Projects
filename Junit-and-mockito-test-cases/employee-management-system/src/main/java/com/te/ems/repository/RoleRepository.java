package com.te.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.ems.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

}
