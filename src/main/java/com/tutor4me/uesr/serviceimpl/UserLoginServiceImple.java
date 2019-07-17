package com.tutor4me.uesr.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.uesr.entity.UserLogin;
import com.tutor4me.uesr.repository.UserLoginServiceRepository;
import com.tutor4me.uesr.service.UserLoginService;

@Service
public class UserLoginServiceImple implements UserLoginService {

	@Autowired
	private UserLoginServiceRepository userLoginServiceRepository;

	@Override
	public void setUserLogData(UserLogin userLogin) {
		userLoginServiceRepository.save(userLogin);

	}

	@Override
	public Optional<UserLogin> getUsre(String userName) {

		return userLoginServiceRepository.findById(userName);
	}

}
