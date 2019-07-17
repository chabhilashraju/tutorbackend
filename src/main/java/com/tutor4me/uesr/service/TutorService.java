package com.tutor4me.uesr.service;

import java.util.Optional;

import com.tutor4me.uesr.entity.TutorMaster;

public interface TutorService {

	public void setTutorDetails(TutorMaster tutorMaster);

	public Optional<TutorMaster> getTutorById(String masterId);

}
