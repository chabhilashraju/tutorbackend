package com.tutor4me.request.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.request.entity.Comment;
import com.tutor4me.request.entity.TutorMaster;
import com.tutor4me.request.exception.ResourceNotFoundException;
import com.tutor4me.request.service.CommentService;
import com.tutor4me.request.util.Tutor4MeUtils;

@RestController
@RequestMapping("/comment")
public class CommentResource {

	@Autowired
	private CommentService commentService;

	@PostMapping(value ="/create" , consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void createComment(@RequestBody Comment comment, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		if (comment == null) {
			new ResourceNotFoundException("Not a valid request");
		} else {
			commentService.createComment(comment);
		}
	}

	@PutMapping("/update")
	public void updateComment(@RequestBody Comment comment, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		commentService.updateComment(comment);
	}

	@DeleteMapping("/delete/{commentId}")
	public void deleteComment(@PathVariable String commentId, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		Comment comment = new Comment();
		comment.setCommentId(commentId);
		commentService.deleteComment(comment);
	}

	@GetMapping("/findByTutor/{tutorId}")
	public List<Comment> findByTutorMaster(@PathVariable String tutorId,  HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		TutorMaster tutorMaster = new TutorMaster();
		tutorMaster.setTutorId(tutorId);
		List<Comment> commentList = commentService.findByTutorMaster(tutorMaster);
		Tutor4MeUtils.setResponseHeader(response);
		return commentList;
	}

	@GetMapping("/findById/{commentId}")
	public Comment findByCommentId(@PathVariable String commentId, HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		Comment comment = commentService.findByCommentId(commentId);
		Tutor4MeUtils.setResponseHeader(response);
		return comment;
	}

}
