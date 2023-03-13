package com.optfs.services;

import java.util.List;

import com.optfs.entities.Admin;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;

public interface TutorService {
	
	public Tutor registerTutor(Tutor tutor) throws NullUserFound, NullEmailFoundException;
	
	public List<Tutor> getAllTutors();
	
	public Tutor getTutorById(Integer pid) throws NullUserFound;
	
	public Tutor updateTutor(Tutor tutor) throws NullUserFound;
	
	public String deleteTutor(Tutor tutor) throws NullUserFound;
	
	public Tutor loginTutor(String email, String password) throws NullUserFound;

	
	
}
