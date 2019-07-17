package com.tutor4me.uesr.entity;

import java.io.Serializable;

public class ParentMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3527656851735562926L;
	
	private String parentId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	
	private StudentMaster studentMaster;
	
	public ParentMaster() {}

}
