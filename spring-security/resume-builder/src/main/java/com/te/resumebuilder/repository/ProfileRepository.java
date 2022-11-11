package com.te.resumebuilder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	List<Profile> findAllByEmployeeId(String employeeId);
	
	Optional<Profile> findByResumeIdAndEmployeeId(String resumeId,String employeeId);

}
