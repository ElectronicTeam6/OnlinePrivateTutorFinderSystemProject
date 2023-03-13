package com.optfs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optfs.entities.DemoRequests;
//import com.optfs.entities.Parent;
//import com.optfs.exceptions.NullUserFound;
import com.optfs.exceptions.NullValuesFoundException;
import com.optfs.repository.DemoRequestRepository;

@Service
public class DemoRequestServiceImpl implements DemoRequestService {
	
	@Autowired
	DemoRequestRepository demoReqRepo;

	@Override
	public DemoRequests addDemoRequests(DemoRequests d) throws NullValuesFoundException {
		
		if(d == null || d.getParent().getId() == null || d.getParent().getId() == 0 || d.getTutor().getId() == null || d.getTutor().getId() == 0 ) {
			throw new NullValuesFoundException("Cannot Add Demo Request! Null entries in ParentId or UserId.");
		}
		return demoReqRepo.save(d);
	}

	@Override
	public List<DemoRequests> getDemoRequestsByTutorId(Integer tId) throws NullValuesFoundException {
		if(tId == 0 || tId == null) {
			throw new NullValuesFoundException("Can't get demo request for null tutor.");
		}
		return demoReqRepo.getDemoRewuestByTutorId(tId);
	}

	@Override
	public List<DemoRequests> getDemoRequestsByParentId(Integer pId) throws NullValuesFoundException {
		if(pId == 0 || pId == null) {
			throw new NullValuesFoundException("Can't get demo request for null parent.");
		}

		return demoReqRepo.getDemoRequestByParentId(pId);
	}

	@Override
	public DemoRequests updateDemoRequest(Integer d) throws NullValuesFoundException{
		
		if(d==null) {
			throw new NullValuesFoundException("No Demo Request Found: ");
		}
		DemoRequests dem = demoReqRepo.findById(d).get();
		dem.setAccepted(true);
		
		return demoReqRepo.save(dem);
	}

	@Override
	public void deleteDemoRequest(DemoRequests d) throws NullValuesFoundException{
		
		d.getParent().setId(1);
		if(d.getDemoId() == null) {
		throw new NullValuesFoundException("No Demo Request Found: " + d.getParent());
	}
		demoReqRepo.save(d);
		demoReqRepo.delete(d);
	}

}
