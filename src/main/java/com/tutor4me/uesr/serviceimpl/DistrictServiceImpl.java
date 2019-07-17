package com.tutor4me.uesr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.uesr.entity.DistrictMaster;
import com.tutor4me.uesr.repository.DistrictServiceRepository;
import com.tutor4me.uesr.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictServiceRepository districtServiceRepository;

	@Override
	public List<DistrictMaster> getDistricts() {

		return districtServiceRepository.findAll();
	}

}
