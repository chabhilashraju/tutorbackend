package com.tutor4me.request.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.request.entity.Request;
import com.tutor4me.request.entity.StudentMaster;
import com.tutor4me.request.exception.ResourceNotFoundException;
import com.tutor4me.request.service.RequestService;
import com.tutor4me.request.util.Tutor4MeUtils;

@RestController
@RequestMapping("/request")
public class RequestResource {

	@Autowired
	private RequestService requestService;

	@PostMapping(value = "/create" , consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void createRequest(@RequestBody Request request, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		//DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.mmm'Z'");
		
		Tutor4MeUtils.setResponseHeader(response);
		if (request == null) {
			new ResourceNotFoundException("Not a valid request");
		} else {
			requestService.createRequest(request);
		}
	}

	@PutMapping("/update")
	public void udpateRequest(@RequestBody Request request, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		if (request == null) {
			new ResourceNotFoundException("Not a valid request");
		} else {
			requestService.updateRequest(request);
		}
	}

	@SuppressWarnings("null")
	@DeleteMapping("/delete/{requestId}")
	public void deleteRequest(@PathVariable String requestId, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		if (requestId == null && requestId.equalsIgnoreCase("")) {
			new ResourceNotFoundException("Not a valid request Id :: " + requestId);
		} else {
			Request request = new Request();
			request.setRequestId(requestId);
			requestService.deleteRequest(request);
		}
	}

    @GetMapping("/findById/{requestId}")
	public Request findByRequestId(@PathVariable String requestId,HttpServletResponse response) {
    	Tutor4MeUtils.setResponseHeader(response);
		Request request = requestService.findByRequestId(requestId);
		return request;
	}
	
	@SuppressWarnings("null")
	@GetMapping("/findByStudent/{studentId}")
	public List<Request> findByStudent(@PathVariable String studentId, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		List<Request> requestList = new ArrayList<Request>();
		if (studentId == null && studentId.equalsIgnoreCase("")) {
			new ResourceNotFoundException("Not a valid student Id :: " + studentId);
		} else {
			StudentMaster studentMaster = new StudentMaster();
			studentMaster.setStudentId(studentId);
			Tutor4MeUtils.setResponseHeader(response);
			requestList = requestService.findByStudent(studentMaster);

			if (requestList == null && requestList.size() <= 0) {
				new ResourceNotFoundException("No request found for :: " + studentId);
			}
		}
		return requestList;
	}

	@SuppressWarnings("null")
	@GetMapping("/findByStatus/{status}")
	public List<Request> findAllRequestsByStatus(@PathVariable String status, HttpServletResponse response) {
		List<Request> openRequestList = new ArrayList<>();
		if (status == null && status.equalsIgnoreCase("")) {
			new ResourceNotFoundException("Not a valid status :: " + status);
		} else {
			openRequestList = requestService.findAllRequestsByStatus(status);
			Tutor4MeUtils.setResponseHeader(response);
			if (openRequestList == null && openRequestList.size() <= 0) {
				new ResourceNotFoundException("No request found with this status :: " + status);
			}
		}
		return openRequestList;
	}

}
