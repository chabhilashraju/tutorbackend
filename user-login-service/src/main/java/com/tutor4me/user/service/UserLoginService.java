package com.tutor4me.user.service;

import com.tutor4me.user.entity.UserLogin;

public interface UserLoginService {

	public String setUserLogData(UserLogin userLogin);

	public UserLogin getUserDetails(String userName, String password);

	public boolean isUserExists(String userName);

}
