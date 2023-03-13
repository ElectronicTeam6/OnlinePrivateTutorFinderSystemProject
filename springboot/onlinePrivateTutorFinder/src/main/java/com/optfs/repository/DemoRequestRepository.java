package com.optfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.optfs.entities.DemoRequests;

public interface DemoRequestRepository extends JpaRepository<DemoRequests, Integer> {

	@Query("from DemoRequests d Inner Join Parent p on p.id = p.id where p.id =:pid")
	public List<DemoRequests> getDemoRequestByParentId(@Param(value = "pid") Integer pid);

	@Query("from DemoRequests d Inner Join Tutor t on t.id = t.id where t.id =:tid")
	public List<DemoRequests> getDemoRewuestByTutorId(@Param(value = "tid") Integer tid);

}
