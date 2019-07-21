package com.tutor4me.user.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor4me.user.entity.DistrictMaster;
import com.tutor4me.user.service.DistrictService;
import com.tutor4me.user.util.Tutor4MeUtils;

@RestController
@RequestMapping("/district")
public class DistrictResource {

	@Autowired
	private DistrictService districtService;

	@GetMapping("/getAll")
	public List<DistrictMaster> getDistricts(HttpServletResponse response) {
		Tutor4MeUtils.setResponseHeader(response);
		return districtService.getDistricts();
	}

}
