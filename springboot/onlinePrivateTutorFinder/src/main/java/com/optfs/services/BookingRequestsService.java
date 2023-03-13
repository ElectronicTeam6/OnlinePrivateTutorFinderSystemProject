package com.optfs.services;

import java.util.List;

import com.optfs.entities.BookingRequests;
import com.optfs.exceptions.NullValuesFoundException;

public interface BookingRequestsService {
	
	public BookingRequests sendBookingRequest(BookingRequests bookTutor) throws NullValuesFoundException;
	
	public List<BookingRequests> getBookingRequestsByTutorId(Integer tid) throws NullValuesFoundException;
	
	public List<BookingRequests> getBookingRequestsByParentId(Integer pid) throws NullValuesFoundException;

	public BookingRequests updateBookingRequest(Integer bookTutor);
	
	public void deleteBookingRequest(BookingRequests b);
	
	public List<BookingRequests> getAllBookings();
}
