package com.optfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optfs.entities.Admin;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.repository.TutorRepository;

@Service
public class TutorServiceImpl implements TutorService {

	@Autowired
	TutorRepository tutorRepository;

	@Override
	public Tutor registerTutor(Tutor Tutor) throws NullUserFound, NullEmailFoundException {
	
		if(Tutor.getEmail() == "" || Tutor.getEmail() == null) {
			throw new NullEmailFoundException("Email cannot be null");
		}
		else if (Tutor.getFirstName().isEmpty() || Tutor.getLastName().isEmpty() || Tutor.getEmail().isEmpty()
				|| Tutor.getPassword().isEmpty()) {
			throw new NullUserFound("Error: Null value is not accepted.");
		} else if (Tutor.getFirstName().equals("string") || Tutor.getLastName().equals("string")
				|| Tutor.getPassword().equals("string") || Tutor.getEmail().equals("string")
				|| Tutor.getSubject().equals("string"))		
		{
			throw new NullUserFound("Error: Null value is not accepted.");
		}
		return tutorRepository.save(Tutor);
	}

	@Override
	public List<Tutor> getAllTutors() {

		return tutorRepository.findAll();
	}

	@Override
	public Tutor getTutorById(Integer pid) throws NullUserFound {
		if (pid == 0) {
			throw new NullUserFound("Null value is not excepted");
		}

		return tutorRepository.getTutorById(pid);
	}

	@Override
	public Tutor updateTutor(Tutor Tutor) throws NullUserFound {
		Tutor p = getTutorById(Tutor.getId());

		if (p == null) {
			throw new NullUserFound("No Tutor Exixts with same this id: " + Tutor.getId());
		}

		return tutorRepository.save(Tutor);
	}

	@Override
	public String deleteTutor(Tutor Tutor) throws NullUserFound {
		Tutor p = getTutorById(Tutor.getId());

		if (p == null) {
			throw new NullUserFound("No Tutor Exixts with same this id: " + Tutor.getId());
		}
		tutorRepository.delete(p);
		return "Tutor Deleted Successfully";
	}
	
	@Override
	public Tutor loginTutor(String email , String password) throws NullUserFound {
		
		if(email.equals("")|| email.equals("string")|| password.equals("")|| password.equals("string")) {
			throw new NullUserFound("Email or Password Cannot be empty");
		}
			
		Tutor t =  tutorRepository.findTutorByEmailPassword(email, password);
		
		if(t == null) {
			throw new NullUserFound("Cant Login tutor Email and Password dont match");
		}
		
		return t;
	}

}
