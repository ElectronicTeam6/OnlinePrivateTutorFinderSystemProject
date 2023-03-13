package com.optfs;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.optfs.entities.DemoRequests;
import com.optfs.entities.Parent;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullValuesFoundException;
import com.optfs.services.DemoRequestService;

@SpringBootTest
public class DemoRequestTest {
	
	@Autowired
	DemoRequestService demoService;
	
	Parent p = new Parent(null,"Test","Parent","testparent@gmail.com","123");
	Tutor t = new Tutor(null,"Test","Tutor","testtutor@gmail.com","123", "Physics", 7, true);
	DemoRequests d = new DemoRequests(null, p, t, false);
	
	@Test
	void addRequest() throws NullValuesFoundException {
		
		assertThrows(NullValuesFoundException.class, () -> demoService.addDemoRequests(d));
	}
	
	@Test
	void getParentById() throws NullValuesFoundException {
		
		assertThrows(NullValuesFoundException.class, () -> demoService.getDemoRequestsByParentId(0) );
				
	}
	
	@Test
	void getTutorById() throws NullValuesFoundException {
		
		assertThrows(NullValuesFoundException.class, () -> demoService.getDemoRequestsByTutorId(0) );
				
	}
	
	@Test
	void updateDemo() throws NullValuesFoundException{
		
		assertThrows(NullValuesFoundException.class, () -> demoService.updateDemoRequest(null));
				
	}
	
	@Test
	void deleteDemo() throws NullValuesFoundException {
		
		assertThrows(NullValuesFoundException.class, () -> demoService.deleteDemoRequest(d));
				
	}


}
