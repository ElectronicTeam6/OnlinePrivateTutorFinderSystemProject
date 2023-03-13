package com.optfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optfs.entities.Parent;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	ParentRepository parentRepository;

	@Override
	public Parent registerParent(Parent parent) throws NullUserFound, NullEmailFoundException {
		
		
		if(parent.getEmail() == null || parent.getEmail() == "") {
			throw new NullEmailFoundException("Email id cannot be null");
		}
		
	else if (parent.getFirstName().isEmpty() || parent.getLastName().isEmpty() || parent.getEmail().isEmpty()
				|| parent.getPassword().isEmpty()) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		else if (parent.getFirstName().equals("string") || parent.getLastName().equals("string") || parent.getPassword().equals("string") || parent.getEmail().equals("string") ) {
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		return parentRepository.save(parent);
	}

	@Override
	public List<Parent> getAllParents() {
		
		return parentRepository.findAll();
	}

	@Override
	public Parent getParentById(Integer pid) throws NullUserFound {
		if(pid == 0) {
			throw new NullUserFound("Null value is not excepted");
		}
		
		return parentRepository.getParentById(pid) ;
	}

	@Override
	public Parent updateParent(Parent parent) throws NullUserFound {
		Parent p =  getParentById(parent.getId());
		
		if(p == null) {
			throw new NullUserFound("No Parent Exixts with same this id: "+ parent.getId());
		}
		
		return parentRepository.save(parent);
	}

	@Override
	public String deleteParent(Parent parent) throws NullUserFound {
		Parent p =  getParentById(parent.getId());
		System.out.println("parent: " + parent+ "p:"+p);
		if(p == null) {
			throw new NullUserFound("No Parent Exixts with same this id: "+ parent.getId());
		}
		parentRepository.delete(p);
		return "Parent Deleted Successfully";
	}
	
	@Override
	public Parent loginParent(String email , String password) throws NullUserFound {
		
		if(email.equals("")|| email.equals("string")|| password.equals("")|| password.equals("string")) {
			throw new NullUserFound("Email or Password Cannot be empty");
		}
			
		Parent p =  parentRepository.findParentByEmailPassword(email, password);
		
		if(p == null) {
			throw new NullUserFound("Cant Login Parent Email and Password dont match");
		}
		
		return p;
	}

}
