package com.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.optfs.entities.Admin;

public interface UserRepository extends JpaRepository<Admin, Integer> {

	@Query("select a,t,p from Parent p, Tutor t, Admin a")
	public List<Object> getAllUsers(); 
}
