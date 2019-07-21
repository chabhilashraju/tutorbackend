package com.tutor4me.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor4me.user.entity.DistrictMaster;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictMaster, Integer> {

}
