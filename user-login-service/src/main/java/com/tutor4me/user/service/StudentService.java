package com.tutor4me.user.service;

import java.util.Map;

import com.tutor4me.user.entity.StudentMaster;

public interface StudentService {

	public StudentMaster getStudentById(String studId);
	
	public Map getAllRequestsByStudent(StudentMaster studentMaster);

}
