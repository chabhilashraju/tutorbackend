package com.tutor4me.request.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.request.entity.Request;
import com.tutor4me.request.entity.StudentMaster;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
	
	public List<Request> findByStudentMaster(StudentMaster studentMaster);
	
	public List<Request> findByStatus(String status);

}
