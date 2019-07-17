package com.tutor4me.uesr.service;

import java.util.Optional;

import com.tutor4me.uesr.entity.UserLogin;

public interface UserLoginService {

	public void setUserLogData(UserLogin userLogin);

	public Optional<UserLogin> getUsre(String userName);

}
