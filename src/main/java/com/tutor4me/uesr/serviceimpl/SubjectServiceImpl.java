package com.tutor4me.uesr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.uesr.entity.CoreSubjectMaster;
import com.tutor4me.uesr.repository.SubjectServiceRepository;
import com.tutor4me.uesr.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectServiceRepository subjectServiceRepository;

	@Override
	public List<CoreSubjectMaster> getSubjects() {

		return subjectServiceRepository.findAll();
	}

}
