package com.optfs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity
public class DemoRequests {

	@Id
	@GeneratedValue
	private Integer demoId;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Parent parent;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Tutor tutor;
	
	private boolean accepted = false;

	public DemoRequests() {
		super();
	}

	public DemoRequests(Integer demoId, Parent parent, Tutor tutor, boolean accepted) {
		super();
		this.demoId = demoId;
		this.parent = parent;
		this.tutor = tutor;
		this.accepted = accepted;
	}

	public Integer getDemoId() {
		return demoId;
	}

	public void setDemoId(Integer demoId) {
		this.demoId = demoId;
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
		return "DemoRequests [demoId=" + demoId + ", parent=" + parent + ", tutor=" + tutor + ", accepted=" + accepted
				+ "]";
	}

	

	

}
