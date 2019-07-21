package com.tutor4me.user.model;

import java.util.Set;

import com.tutor4me.user.entity.Comment;
import com.tutor4me.user.entity.Request;
import com.tutor4me.user.entity.TutorMaster;

public class TutorLoginResponseModel {

	private TutorMaster tutorMaster;	
	private Set<Request> openRequestSet;
	private Set<Request> tutorRequestSet;
	

	public TutorLoginResponseModel() {
	}

	public TutorMaster getTutorMaster() {
		return tutorMaster;
	}

	public void setTutorMaster(TutorMaster tutorMaster) {
		this.tutorMaster = tutorMaster;
	}

	public Set<Request> getOpenRequestSet() {
		return openRequestSet;
	}

	public void setOpenRequestSet(Set<Request> openRequestSet) {
		this.openRequestSet = openRequestSet;
	}

	public Set<Request> getTutorRequestSet() {
		return tutorRequestSet;
	}

	public void setTutorRequestSet(Set<Request> tutorRequestSet) {
		this.tutorRequestSet = tutorRequestSet;
	}

}
