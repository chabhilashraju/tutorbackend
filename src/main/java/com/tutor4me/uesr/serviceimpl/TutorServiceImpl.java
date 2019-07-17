package com.tutor4me.uesr.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.uesr.entity.TutorMaster;
import com.tutor4me.uesr.repository.TutorServiceRepository;
import com.tutor4me.uesr.service.TutorService;

@Service
public class TutorServiceImpl implements TutorService {

	@Autowired
	private TutorServiceRepository tutorServiceRepository;

	@Override
	public void setTutorDetails(TutorMaster tutorMaster) {
		tutorServiceRepository.save(tutorMaster);

	}

	@Override
	public Optional<TutorMaster> getTutorById(String masterId) {

		return tutorServiceRepository.findById(masterId);
	}

}
