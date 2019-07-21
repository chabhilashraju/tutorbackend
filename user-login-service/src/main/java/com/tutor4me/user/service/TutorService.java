package com.tutor4me.user.service;

import java.util.Map;

import com.tutor4me.user.entity.TutorMaster;
import com.tutor4me.user.model.TutorLoginResponseModel;

public interface TutorService {

	public void setTutorDetails(TutorMaster tutorMaster);

	public TutorMaster getTutorById(String masterId);
	
	public Map getAllOpenAndTutorRequests(TutorMaster tutorMaster);

}
