package com.web.spring.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.spring.beans.ImageUpload;
import com.web.spring.dao.ImageUploadDao;


@Repository
public class ImageUploadDaoImp implements ImageUploadDao {

	@Autowired(required=true)
	   private SessionFactory sessionFactory;
	
	@Override
	public void save(ImageUpload images) {
		sessionFactory.getCurrentSession().persist(images);
	}

	@Override
	public List<ImageUpload> getImages() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from images_upload ");
		
		List<ImageUpload> list = query.list();
		return list;
	}

}
