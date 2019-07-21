package com.tutor4me.user.util;

import java.util.Date;

import com.tutor4me.user.entity.TutorMaster;
import com.tutor4me.user.entity.UserLogin;
import com.tutor4me.user.model.StudentRegisterData;
import com.tutor4me.user.model.TutorRegisterData;

public class BeanUtil {

	public static TutorMaster tutorRegToTutor(TutorRegisterData tutorRegisterData, String tutorId) {

		TutorMaster tutorMaster = new TutorMaster();
		tutorMaster.setTutorId(tutorId);
		tutorMaster.setFirstName(tutorRegisterData.getFirstName());
		tutorMaster.setLastName(tutorRegisterData.getLastName());
		tutorMaster.setEmail(tutorRegisterData.getEmail());
		tutorMaster.setPhone(tutorRegisterData.getMobile());
		tutorMaster.setTutorType(tutorRegisterData.getTutortype());
		tutorMaster.setBiography(tutorRegisterData.getBiography());
		tutorMaster.setStudentMaster(tutorRegisterData.getStudentMaster());	
		tutorMaster.setSubjectMasterSet(tutorRegisterData.getSubjectMasterSet());
		return tutorMaster;

	}

	public static UserLogin tutorRegToUserLog(TutorRegisterData tutorRegisterData, String tutorId) {

		UserLogin userLogin = new UserLogin();
		userLogin.setUserName(tutorRegisterData.getUserName());
		userLogin.setPassword(tutorRegisterData.getPassword());
		userLogin.setMasterType(tutorRegisterData.getMasterType());
		userLogin.setMasterId(tutorId);
		userLogin.setCreatedDate(new Date());
		return userLogin;

	}

	public static UserLogin studentRegToUserLog(StudentRegisterData studentRegisterData) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName(studentRegisterData.getUserName());
		userLogin.setPassword(studentRegisterData.getPassword());
		userLogin.setMasterType(studentRegisterData.getMasterType());
		userLogin.setMasterId(studentRegisterData.getStudentId());
		userLogin.setCreatedDate(new Date());
		return userLogin;
	}

}
