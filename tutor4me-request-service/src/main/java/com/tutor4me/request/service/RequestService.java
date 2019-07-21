package com.tutor4me.request.service;

import java.util.List;

import com.tutor4me.request.entity.Request;                        
import com.tutor4me.request.entity.StudentMaster;

public interface RequestService {

	public void createRequest(Request request);
	public void updateRequest(Request request);
	public void deleteRequest(Request request);
	public List<Request> findByStudent(StudentMaster studentMaster);
	public Request findByRequestId(String requestId);
	public List<Request> findAllRequestsByStatus(String status);
	

}
