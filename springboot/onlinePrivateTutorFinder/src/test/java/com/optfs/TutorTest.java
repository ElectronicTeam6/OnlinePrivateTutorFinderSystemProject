package com.optfs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.repository.TutorRepository;
import com.optfs.services.TutorService;

@SpringBootTest
class TutorTest {
	
	@Autowired
	TutorRepository tutorRepo;
	
	@Autowired
	TutorService tutorService;
	
	
	
	@Test
	void saveTutorWithNoEmail() throws NullEmailFoundException {
		Tutor t = new Tutor(001,"Test","User","","pass@123", "Maths", 2, false);
		
		assertThrows(NullEmailFoundException.class, () -> tutorService.registerTutor(t) );
				
	}
	
	@Test
	void getTutorById() throws NullUserFound {
		
		assertThrows(NullUserFound.class, () -> tutorService.getTutorById(0) );
				
	}
	
	@Test
	void updateTutor() throws NullUserFound {
		Tutor t = new Tutor(000,"Test","User","","pass@123", "Maths", 2, false);
		
		
		assertThrows(NullUserFound.class, () -> tutorService.updateTutor(t));
				
	}
	
	@Test
	void deleteTutor() throws NullUserFound {
		Tutor t = new Tutor(001,"Test","User","","pass@123", "Maths", 2, false);
		
		
		assertThrows(NullUserFound.class, () -> tutorService.deleteTutor(t));
				
	}
	



}
