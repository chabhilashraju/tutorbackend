package com.tutor4me.user.resource;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.entity.TutorMaster;
import com.tutor4me.user.model.TutorRegisterData;
import com.tutor4me.user.service.StudentService;
import com.tutor4me.user.service.TutorService;
import com.tutor4me.user.service.UserLoginService;
import com.tutor4me.user.util.BeanUtil;
import com.tutor4me.user.util.Tutor4MeUtils;

@RestController
@RequestMapping("/tutor")
public class TutorResource {

	@Autowired
	private TutorService tutorService;

	@Autowired
	private StudentService studentService;

	@Autowired
	UserLoginService userLoginService;

	@PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void studentReg(@RequestBody TutorRegisterData tutorRegisterData, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		StudentMaster student = studentService.getStudentById(tutorRegisterData.getStudentMaster().getStudentId());
		if (student.getStudentId() != null) {
			if(userLoginService.isUserExists(tutorRegisterData.getUserName())) {
				String tutorId = Tutor4MeUtils.generateID("TUT");
				tutorService.setTutorDetails(BeanUtil.tutorRegToTutor(tutorRegisterData, tutorId));
				userLoginService.setUserLogData(BeanUtil.tutorRegToUserLog(tutorRegisterData, tutorId));
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping(path = "/getOpenAndTutorRequests/{tutorId}")
	public Map getAllOpenAndTutorRequests(@PathVariable String tutorId,HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		TutorMaster tutorMaster = new TutorMaster();
		tutorMaster.setTutorId(tutorId);		
		Map requestMap = new HashMap();
		requestMap = tutorService.getAllOpenAndTutorRequests(tutorMaster);
		
		return requestMap;
		
	}

}
