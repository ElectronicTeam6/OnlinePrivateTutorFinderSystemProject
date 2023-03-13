package com.optfs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity
public class BookingRequests {

	@Id
	@GeneratedValue
	private Integer bookingId;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Parent parent;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Tutor tutor;
	
	private boolean accepted;

	public BookingRequests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingRequests(Integer bookingId, Parent parent, Tutor tutor, boolean accepted) {
		super();
		this.bookingId = bookingId;
		this.parent = parent;
		this.tutor = tutor;
		this.accepted = accepted;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		return "BookingRequests [bookingId=" + bookingId + ", parent=" + parent + ", tutor=" + tutor + ", accepted="
				+ accepted + "]";
	}

	
	

}
