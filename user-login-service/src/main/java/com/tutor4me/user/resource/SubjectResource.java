package com.tutor4me.user.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.user.entity.CoreSubjectMaster;
import com.tutor4me.user.service.SubjectService;
import com.tutor4me.user.util.Tutor4MeUtils;

@RestController
@RequestMapping("/subject")
public class SubjectResource {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/getAll")
	public List<CoreSubjectMaster> getSubjects(HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		return subjectService.getSubjects();
	}

}
