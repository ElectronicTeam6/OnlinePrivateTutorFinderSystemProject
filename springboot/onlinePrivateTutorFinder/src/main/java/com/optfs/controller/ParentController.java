package com.optfs.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.services.ParentService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/parent")
public class ParentController {

	@Autowired
	ParentService parentService;
	
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to Parent controller";
	}
	
	@PostMapping("/registerParent")
	public Parent registerParent(@RequestBody Parent parent) throws NullUserFound, NullEmailFoundException {
		return parentService.registerParent(parent);
	}
	
	@GetMapping("/allParents")
	public List<Parent> getAllParents(){
		return parentService.getAllParents();
	}
	
	@PostMapping("/updateParent")
	public Parent updateParent(@RequestBody Parent parent) throws NullUserFound {
		return parentService.updateParent(parent);
	}
	
	@DeleteMapping("/deleteParent")
	public String deleteParent(@RequestBody Parent parent) throws NullUserFound {
		return parentService.deleteParent(parent);
	}
	
	@GetMapping("/loginParent/{email}/{password}")
	public Parent loginParent(@PathVariable String email, @PathVariable String password) throws NullUserFound
	{
		return parentService.loginParent(email, password);
	}
}
