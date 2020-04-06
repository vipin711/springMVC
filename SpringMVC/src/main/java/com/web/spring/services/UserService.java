package com.web.spring.services;

import java.util.List;

import com.web.spring.beans.NewUser;
import com.web.spring.beans.UserDetail;

public interface UserService {

	public void addUser(NewUser user);

	public List<NewUser> getUsers();

	public List<NewUser> getUserDetail(UserDetail user);

}
