package com.optfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optfs.entities.BookingRequests;
import com.optfs.exceptions.NullValuesFoundException;
import com.optfs.repository.BookingRequestRepository;
import com.optfs.repository.ParentRepository;
import com.optfs.repository.TutorRepository;

@Service
public class BookingRequestsServiceImpl implements BookingRequestsService {

	@Autowired
	BookingRequestRepository bookingRepo;
	
	@Autowired
	TutorRepository tutRepo;
	
	@Autowired 
	ParentRepository parentRepo;
	
	@Override
	public BookingRequests sendBookingRequest(BookingRequests bookTutor) throws NullValuesFoundException {
		if (bookTutor == null || bookTutor.getParent() == null || bookTutor.getTutor() == null ) 
		{
			throw new NullValuesFoundException("Can't send Booking Request with null values");
		}
		
			
			return bookingRepo.save(bookTutor);
	}

	@Override
	public List<BookingRequests> getBookingRequestsByTutorId(Integer tid) throws NullValuesFoundException {
		if(tid == 0|| tid == null) {
			throw new NullValuesFoundException("cant get requests for null tutor id");
		}
		return bookingRepo.getBookingByTutorId(tid);
	}

	@Override
	public List<BookingRequests> getBookingRequestsByParentId(Integer pid) throws NullValuesFoundException {
		if(pid == 0|| pid == null) {
			throw new NullValuesFoundException("cant get requests for null tutor id");
		}
		return bookingRepo.getBookingByParentId(pid);
	}

	@Override
	public BookingRequests updateBookingRequest(Integer bookTutor) {
		System.out.println(bookTutor);
		BookingRequests br =  bookingRepo.findById(bookTutor).get();
		br.setAccepted(true);
		return bookingRepo.save(br);
	}

	@Override
	public void deleteBookingRequest(BookingRequests b) {
	 	
		 bookingRepo.delete(b);
	}

	@Override
	public List<BookingRequests> getAllBookings() {
		
		return bookingRepo.findAll();
	}

}
