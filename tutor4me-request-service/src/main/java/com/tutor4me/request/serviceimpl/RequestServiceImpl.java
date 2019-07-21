package com.tutor4me.request.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.request.entity.Request;
import com.tutor4me.request.entity.StudentMaster;
import com.tutor4me.request.repository.RequestRepository;
import com.tutor4me.request.service.RequestService;
import com.tutor4me.request.util.Tutor4MeUtils;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public void createRequest(Request request) {		
		String requestId = Tutor4MeUtils.generateID("REQ");
		request.setRequestId(requestId);
		request.setStatus("OPEN");
		request.setCreatedDate(LocalDateTime.now());		
		requestRepository.save(request);
	}

	@Override
	public void updateRequest(Request request) {
		requestRepository.save(request);
	}

	@Override
	public void deleteRequest(Request request) {
		requestRepository.delete(request);
	}

	@Override
	public List<Request> findByStudent(StudentMaster studentMaster) {
		List<Request> requestList = requestRepository.findByStudentMaster(studentMaster);
		return requestList;
	}

	@Override
	public Request findByRequestId(String requestId) {
		Optional<Request> request = requestRepository.findById(requestId);
		return request.get();
	}

	@Override
	public List<Request> findAllRequestsByStatus(String status) {
		List<Request> openRequestList = requestRepository.findByStatus(status);
		return openRequestList;
	}

}
