package com.tutor4me.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor4me.user.entity.StudentMaster;
import com.tutor4me.user.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String> {
	
	public UserLogin findByUserNameAndPassword(String userName, String password);
	
	public UserLogin findByMasterId(String masterId);

}
