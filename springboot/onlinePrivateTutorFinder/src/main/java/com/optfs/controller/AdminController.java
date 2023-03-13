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

import com.optfs.entities.Admin;
import com.optfs.entities.Parent;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.services.AdminService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to Admin controller";
	}
	
	@PostMapping("/registerAdmin")
	public Admin registerAdmin(@RequestBody Admin admin) throws NullUserFound, NullEmailFoundException {
		return adminService.registerAdmin(admin);
	}
	
	@GetMapping("/allAdmins")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@PostMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) throws NullUserFound {
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteAdmin")
	public String deleteAdmin(@RequestBody Admin admin) throws NullUserFound {
		return adminService.deleteAdmin(admin);
	}
	
	@GetMapping("/loginAdmin/{email}/{password}")
	public Admin loginAdmin(@PathVariable String email, @PathVariable String password ) throws NullUserFound
	{
		
		return adminService.loginAdmin(email, password);
	}
	
}
