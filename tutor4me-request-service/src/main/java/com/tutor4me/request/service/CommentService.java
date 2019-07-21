package com.tutor4me.request.service;

import java.util.List;

import com.tutor4me.request.entity.Comment;
import com.tutor4me.request.entity.TutorMaster;

public interface CommentService {
	
	public void createComment(Comment comment);
	public void updateComment(Comment comment);
	public void deleteComment(Comment comment);
	public List<Comment> findByTutorMaster(TutorMaster tutorMaster);
	public Comment findByCommentId(String commentId);

}
