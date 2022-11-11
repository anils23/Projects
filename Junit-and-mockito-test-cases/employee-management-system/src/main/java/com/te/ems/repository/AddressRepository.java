package com.te.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ems.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long > {

}
