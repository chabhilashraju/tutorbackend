package com.tutor4me.uesr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.uesr.entity.StudentMaster;

@Repository
public interface StudentServiceRepository extends JpaRepository<StudentMaster, String> {

}