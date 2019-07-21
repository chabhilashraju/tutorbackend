package com.tutor4me.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.user.entity.CoreSubjectMaster;

@Repository
public interface SubjectRepository extends JpaRepository<CoreSubjectMaster, Integer> {

}
