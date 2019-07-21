package com.tutor4me.user.serviceimpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.user.entity.Comment;
import com.tutor4me.user.entity.Request;
import com.tutor4me.user.entity.TutorMaster;
import com.tutor4me.user.repository.CommentRepository;
import com.tutor4me.user.repository.RequestRepository;
import com.tutor4me.user.repository.TutorRepository;
import com.tutor4me.user.service.TutorService;

@Service
public class TutorServiceImpl implements TutorService {

	@Autowired
	private TutorRepository tutorServiceRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private RequestRepository requestRepository;

	@Override
	public void setTutorDetails(TutorMaster tutorMaster) {
		tutorServiceRepository.save(tutorMaster);
	}

	@Override
	public TutorMaster getTutorById(String masterId) {		
		TutorMaster tutorMaster = new TutorMaster();
		Optional<TutorMaster> optionaltutorMaster = tutorServiceRepository.findById(masterId);
		if(optionaltutorMaster.isPresent()) {
			tutorMaster = optionaltutorMaster.get();
		}	
	
		return tutorMaster;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getAllOpenAndTutorRequests(TutorMaster tutorMaster) {		
		Set<Request> tutorRequestSet = new HashSet<>();	
		Map requstMap = new HashMap();
		
		List<Comment> commentsList = commentRepository.findByTutorMaster(tutorMaster);			
		commentsList.forEach(comment-> {
			Request request = comment.getRequest();
			tutorRequestSet.add(request);
		});
		
		List<Request> openRequestList = requestRepository.findByStatus("Open");		
		requstMap.put("tutorRequests", tutorRequestSet);
		requstMap.put("openRequestList", openRequestList);
		requstMap.put("tutorRequestCount", tutorRequestSet.size());
		requstMap.put("openRequestCount", openRequestList.size());		
		
		return requstMap;
	}

}
