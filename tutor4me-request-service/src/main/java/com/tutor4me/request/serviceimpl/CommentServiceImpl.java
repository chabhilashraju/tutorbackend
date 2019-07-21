package com.tutor4me.request.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.request.entity.Comment;
import com.tutor4me.request.entity.Request;
import com.tutor4me.request.entity.TutorMaster;
import com.tutor4me.request.repository.CommentRepository;
import com.tutor4me.request.repository.RequestRepository;
import com.tutor4me.request.service.CommentService;
import com.tutor4me.request.util.Tutor4MeUtils;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public void createComment(Comment comment) {
		String commentId = Tutor4MeUtils.generateID("COM");
		comment.setCommentId(commentId);
		comment.setCreatedDate(LocalDateTime.now());
		commentRepository.save(comment);

		String requestId = comment.getRequest().getRequestId();
		if (requestId != null) {
			Request request = requestRepository.findById(requestId).get();
			String startTime = comment.getRequest().getStartTime();
			String endTime = comment.getRequest().getEndTime();

			if (startTime != null && endTime != null) {
				request.setStartTime(startTime);
				request.setEndTime(endTime);
			}
			request.setStatus("Scheduled");
			requestRepository.save(request);
		}
	}

	@Override
	public void updateComment(Comment comment) {
		commentRepository.saveAndFlush(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		commentRepository.delete(comment);
	}

	@Override
	public List<Comment> findByTutorMaster(TutorMaster tutorMaster) {
		List<Comment> commentList = commentRepository.findByTutorMaster(tutorMaster);
		return commentList;
	}

	@Override
	public Comment findByCommentId(String commentId) {
		Comment comment = new Comment();
		Optional<Comment> optionalComment = commentRepository.findById(commentId);
		if (optionalComment.isPresent()) {
			comment = optionalComment.get();
		}
		return comment;
	}

}
