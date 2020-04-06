package com.web.spring.dao;

import java.util.List;

import com.web.spring.beans.ImageUpload;


public interface ImageUploadDao {

	public void save(ImageUpload images);
	
	public List<ImageUpload> getImages();
}
