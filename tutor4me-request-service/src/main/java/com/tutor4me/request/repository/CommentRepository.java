package com.tutor4me.request.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.request.entity.Comment;
import com.tutor4me.request.entity.TutorMaster;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String>{
	
	public List<Comment> findByTutorMaster(TutorMaster tutorMaster);

}
