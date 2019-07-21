package com.tutor4me.user.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.entity.TutorMaster;
import com.tutor4me.user.entity.UserLogin;
import com.tutor4me.user.model.StudentRegisterData;
import com.tutor4me.user.model.TutorLoginResponseModel;
import com.tutor4me.user.service.StudentService;
import com.tutor4me.user.service.TutorService;
import com.tutor4me.user.service.UserLoginService;
import com.tutor4me.user.util.Tutor4MeUtils;

@RestController
@RequestMapping("/user")
public class UserLoginResource {

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private StudentService StudentService;

	@Autowired
	private TutorService tutorService;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody StudentRegisterData studentRegisterData, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		ResponseEntity<?> responseEntity = null;

		UserLogin userLogin = userLoginService.getUserDetails(studentRegisterData.getUserName(),
				studentRegisterData.getPassword());
		if (userLogin != null) {

			if (userLogin.getMasterType().equalsIgnoreCase("Student")) {
				StudentMaster studentMaster = StudentService.getStudentById(userLogin.getMasterId());
				responseEntity = new ResponseEntity<>(studentMaster, HttpStatus.OK);
			}
			if (userLogin.getMasterType().equalsIgnoreCase("Tutor")) {
				TutorMaster tutorMaster = tutorService.getTutorById(userLogin.getMasterId());
				responseEntity = new ResponseEntity<>(tutorMaster, HttpStatus.OK);
			}

		}
		return responseEntity;
	}

}
