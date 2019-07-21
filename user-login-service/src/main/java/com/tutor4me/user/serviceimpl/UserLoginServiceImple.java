package com.tutor4me.user.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.entity.UserLogin;
import com.tutor4me.user.repository.UserLoginRepository;
import com.tutor4me.user.service.UserLoginService;

@Service
public class UserLoginServiceImple implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginServiceRepository;

	@Override
	public String setUserLogData(UserLogin userLogin) {
		String status = "";
		
		UserLogin chkUserLogin = userLoginServiceRepository.findByMasterId(userLogin.getMasterId());				
		if(chkUserLogin!=null) {
			status = "AlreadyPresent";
		}else {
			userLoginServiceRepository.save(userLogin);
			status = "Secussfull";
		}		
		return status;
	}

	@Override
	public UserLogin getUserDetails(String userName, String password) {
		return userLoginServiceRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public boolean isUserExists(String userName) {
		boolean flag = false;		
		
		Optional<UserLogin> userLogin = userLoginServiceRepository.findById(userName);		
		
		if(!userLogin.isPresent()) {
			flag = true;
		}
		return flag;
	}

}
