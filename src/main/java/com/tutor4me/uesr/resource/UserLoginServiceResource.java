package com.tutor4me.uesr.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.uesr.entity.StudentMaster;
import com.tutor4me.uesr.entity.TutorMaster;
import com.tutor4me.uesr.entity.UserLogin;
import com.tutor4me.uesr.model.StudentRegisterData;
import com.tutor4me.uesr.service.StudentService;
import com.tutor4me.uesr.service.TutorService;
import com.tutor4me.uesr.service.UserLoginService;

@RestController
@RequestMapping("/userLogin")
public class UserLoginServiceResource {

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private StudentService StudentService;

	@Autowired
	private TutorService tutorService;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody StudentRegisterData studentRegisterData) {

		ResponseEntity<?> responseEntity = null;
		Optional<UserLogin> UserLogin = userLoginService.getUsre(studentRegisterData.getUserName());
		if (UserLogin != null) {
			if (isValiedUser(UserLogin, studentRegisterData)) {
				if (UserLogin.get().getMasterType().equalsIgnoreCase("Student")) {
					Optional<StudentMaster> studentMaster = StudentService
							.getStudentById(UserLogin.get().getMasterId());
					responseEntity = new ResponseEntity<>(studentMaster, HttpStatus.OK);
				}
				if (UserLogin.get().getMasterType().equalsIgnoreCase("Tutor")) {
					Optional<TutorMaster> TutorMaster = tutorService.getTutorById(UserLogin.get().getMasterId());
					responseEntity = new ResponseEntity<>(TutorMaster, HttpStatus.OK);
				}
			}
		}
		return responseEntity;
	}

	private boolean isValiedUser(Optional<UserLogin> userLogin, StudentRegisterData studentRegisterData) {
		boolean flag = false;
		if (userLogin.get().getPassword().equalsIgnoreCase(studentRegisterData.getPassword()))
			flag = true;
		return flag;
	}

}
