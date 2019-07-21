package com.tutor4me.user.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.user.entity.Request;
import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.repository.RequestRepository;
import com.tutor4me.user.repository.StudentRepository;
import com.tutor4me.user.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentServiceRepository;
	
	@Autowired
	private RequestRepository requestRepository;

	@Override
	public StudentMaster getStudentById(String studId) {
		StudentMaster studentMaster = new StudentMaster();
		Optional<StudentMaster> subjectOptionalMaster = studentServiceRepository.findById(studId);
		if(subjectOptionalMaster.isPresent()) {
			studentMaster = subjectOptionalMaster.get();
		}		
		return studentMaster;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAllRequestsByStudent(StudentMaster studentMaster) {
		int openCount = 0;
		int scheduleCount=0;
		int inProgressCount=0;
		
		Map<String, Object> requestMap = new HashMap<String, Object>();		
		List<Request> requestList = requestRepository.findByStudentMaster(studentMaster);
		if(!requestList.isEmpty()) {
			for(Request request: requestList){
				String status = request.getStatus();
				if(status.equalsIgnoreCase("Open")) {	
					openCount++;					
				}else if(status.equalsIgnoreCase("Scheduled")) {
					scheduleCount++;
				}else if(status.equalsIgnoreCase("Inprogress")) {
					inProgressCount++;
				}				
			}			
		}
		requestMap.put("totalRequestCount", requestList.size());
		requestMap.put("openCount", openCount);
		requestMap.put("scheduleCount", scheduleCount);
		requestMap.put("inProgressCount", inProgressCount);
		requestMap.put("requestList", requestList);		
		
		return requestMap;
	}

}
