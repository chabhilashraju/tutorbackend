package com.tutor4me.uesr.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.uesr.entity.DistrictMaster;
import com.tutor4me.uesr.service.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictServiceResource {

	@Autowired
	private DistrictService districtService;

	@GetMapping("/getDistricts")
	public List<DistrictMaster> getDistricts() {

		return districtService.getDistricts();
	}

}
