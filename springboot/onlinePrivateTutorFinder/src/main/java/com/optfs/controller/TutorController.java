package com.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optfs.entities.Parent;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.services.TutorService;

import springfox.documentation.service.CredentialsGrant;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/tutor")
public class TutorController {

	@Autowired
	TutorService tutorService;
	
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to Tutor controller";
	}
	
	@PostMapping("/registerTutor")
	public Tutor registerTutor(@RequestBody Tutor tutor) throws NullUserFound, NullEmailFoundException {
		return tutorService.registerTutor(tutor);
	}
	
	@GetMapping("/allTutors")
	public List<Tutor> getAllTutors(){
		return tutorService.getAllTutors();
	}
	
	@PostMapping("/updateTutor")
	public Tutor updateTutor(@RequestBody Tutor tutor) throws NullUserFound {
		return tutorService.updateTutor(tutor);
	}
	
	@DeleteMapping("/deleteTutor")
	public String deleteTutor(@RequestBody Tutor tutor) throws NullUserFound {
		return tutorService.deleteTutor(tutor);
	}
	
	
	@GetMapping("/loginTutor/{email}/{pass}")
	public Tutor loginTutor(@PathVariable String email, @PathVariable String pass) throws NullUserFound
	{
		return tutorService.loginTutor(email, pass);
	}
}
