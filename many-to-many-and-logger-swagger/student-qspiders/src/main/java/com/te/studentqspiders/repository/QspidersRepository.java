package com.te.studentqspiders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.studentqspiders.entity.Qspiders;

public interface QspidersRepository extends JpaRepository<Qspiders, Integer> {

	public List<Qspiders>  findByQspidersIdIn(List<Integer> ids);

}
