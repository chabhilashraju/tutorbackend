package com.tutor4me.uesr.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.uesr.entity.StudentMaster;
import com.tutor4me.uesr.repository.StudentServiceRepository;
import com.tutor4me.uesr.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentServiceRepository studentServiceRepository;

	@Override
	public Optional<StudentMaster> getStudentById(String studId) {

		return studentServiceRepository.findById(studId);
	}

}
