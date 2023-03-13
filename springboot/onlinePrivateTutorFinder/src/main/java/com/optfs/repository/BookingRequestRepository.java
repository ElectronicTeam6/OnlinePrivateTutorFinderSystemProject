package com.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.optfs.entities.BookingRequests;

@Repository
public interface BookingRequestRepository extends JpaRepository<BookingRequests, Integer> {

	@Query("from BookingRequests b Inner Join Parent p on p.id = p.id where p.id =:pid")
	public List<BookingRequests> getBookingByParentId(@Param(value="pid")Integer pid);
	
	@Query("from BookingRequests b Inner Join Tutor t on t.id = t.id where t.id =:tid")
	public List<BookingRequests> getBookingByTutorId(@Param(value="tid")Integer tid);
	
	
}
