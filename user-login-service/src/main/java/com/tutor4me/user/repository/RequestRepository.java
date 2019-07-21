package com.tutor4me.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.user.entity.Request;
import com.tutor4me.user.entity.StudentMaster;

@Repository
public interface RequestRepository extends JpaRepository<Request, String> {
	
	public List<Request> findByStudentMaster(StudentMaster studentMaster);
	
	public List<Request> findByStatus(String status);

}
