package com.web.spring.servicesImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.beans.NewUser;
import com.web.spring.beans.UserDetail;
import com.web.spring.dao.Userdao;
import com.web.spring.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired(required = true)
	private Userdao userdao;

	@Transactional
	public void addUser(NewUser user) {
		userdao.save(user);

	}

	@Override
	@Transactional
	public List<NewUser> getUsers() {
		return userdao.getUsers();
	}

	@Override
	@Transactional
	public List<NewUser> getUserDetail(UserDetail user) {
		return userdao.getUserDetail(user);
	}

}
