package com.optfs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.optfs.entities.Admin;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullEmailFoundException;
import com.optfs.exceptions.NullUserFound;
import com.optfs.repository.AdminRepository;
import com.optfs.repository.TutorRepository;
import com.optfs.services.AdminService;
import com.optfs.services.TutorService;

@SpringBootTest
class AdminTest {
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	AdminService adminService;
	
	
	
	@Test
	void saveAdminWithNoEmail() throws NullEmailFoundException {
		Admin a = new Admin(001,"Test","User","","pass@123");
		
		assertThrows(NullEmailFoundException.class, () -> adminService.registerAdmin(a) );
				
	}
	
	@Test
	void getAdminById() throws NullUserFound {
		
		assertThrows(NullUserFound.class, () -> adminService.getAdminById(0) );
				
	}
	
	@Test
	void updateAdmin() throws NullUserFound {
		Admin a = new Admin(000,"Test","User","","pass@123");
		
		
		assertThrows(NullUserFound.class, () -> adminService.updateAdmin(a));
				
	}
	
	@Test
	void deleteAdmin() throws NullUserFound {
		Admin a = new Admin(001,"Test","User","","pass@123");
		
		
		assertThrows(NullUserFound.class, () -> adminService.deleteAdmin(a));
				
	}
	



}