package com.tutor4me.user.resource;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.model.ResponseJson;
import com.tutor4me.user.model.StudentRegisterData;
import com.tutor4me.user.service.StudentService;
import com.tutor4me.user.service.UserLoginService;
import com.tutor4me.user.util.BeanUtil;
import com.tutor4me.user.util.Tutor4MeUtils;

@RestController
@RequestMapping("/student")
public class StudentResource {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserLoginService userLoginService;

	@GetMapping(path = "/authentication/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseJson studAuth(@PathVariable("studentId") String studentId, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		ResponseEntity<?> responseEntity = null;
		
		ResponseJson responseJson = new ResponseJson();

		StudentMaster studentMaster = studentService.getStudentById(studentId);
		if (studentMaster!= null) {
			String email = studentMaster.getEmail();
			responseJson.setMessage(email);
			responseJson.setStatus("Sucess");			
			System.out.println("email----->" + email);
		} else {
			responseJson.setStatus("Failed");
		}
		return responseJson;
	}

	@PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseStatus(HttpStatus.OK)
	public ResponseJson studentReg(@RequestBody StudentRegisterData studentRegisterData,
			HttpServletResponse response) {
		System.out.println("User Name" + studentRegisterData.getUserName());
		Tutor4MeUtils.setResponseHeader(response);
		ResponseJson responseJson = new ResponseJson();
		String status = "";
		StudentMaster studentMaster = studentService.getStudentById(studentRegisterData.getStudentId());
		if (studentMaster != null) {
			status = userLoginService.setUserLogData(BeanUtil.studentRegToUserLog(studentRegisterData));
			responseJson.setStatus(status);
		} else {			
			responseJson.setStatus("NotExists");
		}
		
		return responseJson;
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(path = "/getStudentRequests/{studentId}")
	public Map getAllRequestsByStudent(@PathVariable String studentId,HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		StudentMaster studentMaster = new StudentMaster();
		studentMaster.setStudentId(studentId);
		
		Map requestMap = studentService.getAllRequestsByStudent(studentMaster);

		return requestMap;

	}
}
