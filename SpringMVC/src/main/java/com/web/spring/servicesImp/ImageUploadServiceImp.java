package com.web.spring.servicesImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.beans.ImageUpload;
import com.web.spring.dao.ImageUploadDao;
import com.web.spring.services.ImageUploadService;

@Service
@Transactional
public class ImageUploadServiceImp implements ImageUploadService {

	@Autowired(required = true)
	private ImageUploadDao imagedao;

	@Override
	public void addImages(ImageUpload images) {
		imagedao.save(images);

	}

	@Override
	public List<ImageUpload> getImages() {

		return imagedao.getImages();
	}

}
