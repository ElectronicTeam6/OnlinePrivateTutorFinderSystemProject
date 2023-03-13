package com.optfs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optfs.entities.BookingRequests;
import com.optfs.entities.Parent;
import com.optfs.entities.Tutor;
import com.optfs.exceptions.NullValuesFoundException;
import com.optfs.repository.ParentRepository;
import com.optfs.repository.TutorRepository;
import com.optfs.services.BookingRequestsService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/bookTutor")
public class BookTutorController {

	@Autowired
	BookingRequestsService bookingService;

	@Autowired
	TutorRepository tutRepo;

	@Autowired
	ParentRepository parentRepo;

	@GetMapping("sendBookingRequest/{tid}/{pid}")
	public BookingRequests sendBookingRequest(@PathVariable Integer pid, @PathVariable Integer tid)
			throws NullValuesFoundException {
		BookingRequests br = new BookingRequests();
		Parent p = parentRepo.getParentById(pid);
		Tutor t = tutRepo.getTutorById(tid);
		br.setTutor(t);
		br.setParent(p);
		return bookingService.sendBookingRequest(br);
	}
	@GetMapping("getBookingsBPID/{pid}")
	public List<BookingRequests> getBookingRequestsByParentId(@PathVariable Integer pid) throws NullValuesFoundException{
		
		return bookingService.getBookingRequestsByParentId(pid);

	}
	
	@GetMapping("getBookingsBTID/{tid}")
	public List<BookingRequests> getBookingRequestsByTutorId(@PathVariable Integer tid) throws NullValuesFoundException{
		
		return bookingService.getBookingRequestsByTutorId(tid);

	}
	
	@GetMapping("updateData/{d}")
	public BookingRequests updateD(@PathVariable Integer d)
	{
		return bookingService.updateBookingRequest(d);
	}
	
	@DeleteMapping("deleteData")
	public void deleteD(@RequestBody BookingRequests d)
	{
		 bookingService.deleteBookingRequest(d);
	}
	
	@GetMapping("all")
	public List<BookingRequests> allB(){
		return bookingService.getAllBookings();
	}
}
