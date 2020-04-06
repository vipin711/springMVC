package com.web.spring.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.spring.beans.LoginUserDetails;
import com.web.spring.beans.NewUser;
import com.web.spring.beans.UserDetail;
import com.web.spring.dao.Userdao;


@Repository
public class NewUserDaoImp implements Userdao {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public void save(NewUser user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);

	}

	@Override
	public List<NewUser> getUsers() {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from NewUser");
		List<NewUser> list = query.list();
		return list;
	}

	@Override
	public List<NewUser> getUserDetail(UserDetail user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from NewUser  where email=:email and password=:password ");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		List<NewUser> list = query.list();
		return list;
	}

	@Override
	public void saveUserdetails(LoginUserDetails loginUserdetails) {
		sessionFactory.getCurrentSession().persist(loginUserdetails);

	}

}
