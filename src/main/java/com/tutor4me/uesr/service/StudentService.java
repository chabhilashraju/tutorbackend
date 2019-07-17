package com.tutor4me.uesr.service;

import java.util.Optional;

import com.tutor4me.uesr.entity.StudentMaster;

public interface StudentService {

	public Optional<StudentMaster> getStudentById(String studId);

}
