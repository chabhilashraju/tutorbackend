package com.tutor4me.uesr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor4me.uesr.entity.UserLogin;

public interface UserLoginServiceRepository extends JpaRepository<UserLogin, String> {

}
