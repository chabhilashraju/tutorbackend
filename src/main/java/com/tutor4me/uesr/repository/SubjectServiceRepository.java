package com.tutor4me.uesr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.uesr.entity.CoreSubjectMaster;

@Repository
public interface SubjectServiceRepository extends JpaRepository<CoreSubjectMaster, Integer> {

}
