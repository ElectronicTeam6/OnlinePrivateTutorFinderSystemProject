package com.optfs.services;

import java.util.List;

import com.optfs.entities.Parent;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;

public interface ParentService {
	
	public Parent registerParent(Parent parent) throws NullUserFound, NullEmailFoundException;
	
	public List<Parent> getAllParents();
	
	public Parent getParentById(Integer pid) throws NullUserFound;
	
	public Parent updateParent(Parent parent) throws NullUserFound;
	
	public String deleteParent(Parent parent) throws NullUserFound;
	
	public Parent loginParent(String email, String password) throws NullUserFound;

}
