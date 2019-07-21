package com.tutor4me.user.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.user.entity.DistrictMaster;
import com.tutor4me.user.repository.DistrictRepository;
import com.tutor4me.user.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepository districtServiceRepository;

	@Override
	public List<DistrictMaster> getDistricts() {

		return districtServiceRepository.findAll();
	}

}
