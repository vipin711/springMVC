package com.web.spring.dao;

import java.util.List;

import com.web.spring.beans.LoginUserDetails;
import com.web.spring.beans.NewUser;
import com.web.spring.beans.UserDetail;


public interface Userdao {

	public void save(NewUser user);

	public List<NewUser> getUsers();
	
	public List<NewUser> getUserDetail(UserDetail user);
	
	public void saveUserdetails(LoginUserDetails loginUserdetails);
}
