package com.tutor4me.user.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.user.entity.CoreSubjectMaster;
import com.tutor4me.user.repository.SubjectRepository;
import com.tutor4me.user.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectServiceRepository;

	@Override
	public List<CoreSubjectMaster> getSubjects() {

		return subjectServiceRepository.findAll();
	}

}
