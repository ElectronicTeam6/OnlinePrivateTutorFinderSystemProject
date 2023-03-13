package com.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optfs.entities.Admin;
import com.optfs.entities.Parent;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullUserFound;
import com.optfs.repository.UserRepository;
import com.optfs.services.AdminService;
import com.optfs.services.ParentService;
import com.optfs.services.TutorService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/")
public class UserController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ParentService parentService;
	
	@Autowired
	TutorService tutorService;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to User controller";
	}
	

	@GetMapping("/allUsers")
	public List<?> getAllUsers(){
		
		List admins = adminService.getAllAdmins();
		List parents = parentService.getAllParents();
		List tutors = tutorService.getAllTutors();
		
		List users;
		for(Object a:admins) {
			parents.add(a);
		}
		for(Object t:tutors) {
			parents.add(t);
		}

		return parents;
	}
	
	@PostMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) throws NullUserFound {
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteAdmin(@RequestBody Admin admin) throws NullUserFound {
		return adminService.deleteAdmin(admin);
	}
	
	@GetMapping("/loginAdmin")
	public Admin loginAdmin(@RequestBody List<String> credentials) throws NullUserFound
	{
		String email = credentials.get(0);
		String password = credentials.get(1);
		return adminService.loginAdmin(email, password);
	}
	
}
