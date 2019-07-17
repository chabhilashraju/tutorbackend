package com.tutor4me.uesr.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.uesr.entity.StudentMaster;
import com.tutor4me.uesr.model.TutorRegisterData;
import com.tutor4me.uesr.service.StudentService;
import com.tutor4me.uesr.service.TutorService;
import com.tutor4me.uesr.service.UserLoginService;
import com.tutor4me.uesr.util.BeanUtil;
import com.tutor4me.uesr.util.Tutor4MeUtils;

@RestController
@RequestMapping("/tutor")
public class TutorServiceResource {

	@Autowired
	private TutorService tutorService;

	@Autowired
	private StudentService studentService;

	@Autowired
	UserLoginService userLoginService;

	@PostMapping(value = "/tutorReg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void studentReg(@RequestBody TutorRegisterData tutorRegisterData) {

		Optional<StudentMaster> student = studentService.getStudentById(tutorRegisterData.getStudentId());
		if (student != null) {
			String tutorId = Tutor4MeUtils.generateID("Tutor");
			tutorService.setTutorDetails(BeanUtil.tutorRegToTutor(tutorRegisterData, tutorId));
			userLoginService.setUserLogData(BeanUtil.tutorRegToUserLog(tutorRegisterData, tutorId));
		}
	}

}
