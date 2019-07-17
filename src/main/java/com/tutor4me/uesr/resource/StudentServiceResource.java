package com.tutor4me.uesr.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.uesr.entity.StudentMaster;
import com.tutor4me.uesr.model.StudentRegisterData;
import com.tutor4me.uesr.service.StudentService;
import com.tutor4me.uesr.service.UserLoginService;
import com.tutor4me.uesr.util.BeanUtil;

@RestController
@RequestMapping("/student")
public class StudentServiceResource {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserLoginService userLoginService;

	@GetMapping(path = "/studAuth/{studId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void studAuth(@PathVariable("studId") String studId) {

		Optional<StudentMaster> studentMaster = studentService.getStudentById(studId);
		System.out.println("Mail Id ________" + studentMaster.get().getEmail());
	}

	@PostMapping(value = "/studentReg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void studentReg(@RequestBody StudentRegisterData studentRegisterData) {
		System.out.println("User Name" + studentRegisterData.getUserName());
		Optional<StudentMaster> student = studentService.getStudentById(studentRegisterData.getStudentId());
		if (student != null) {

			userLoginService.setUserLogData(BeanUtil.studentRegToUserLog(studentRegisterData));
		}
	}
}
