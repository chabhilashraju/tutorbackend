package com.tutor4me.uesr.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.uesr.entity.CoreSubjectMaster;
import com.tutor4me.uesr.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectServiceResource {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/getSubjects")
	public List<CoreSubjectMaster> getSubjects() {

		return subjectService.getSubjects();
	}

}
