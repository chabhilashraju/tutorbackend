package com.tutor4me.uesr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.uesr.entity.DistrictMaster;

@Repository
public interface DistrictServiceRepository extends JpaRepository<DistrictMaster, Integer> {

}
