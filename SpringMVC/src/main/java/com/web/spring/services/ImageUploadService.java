package com.web.spring.services;

import java.util.List;

import com.web.spring.beans.ImageUpload;



public interface ImageUploadService {

	public void addImages(ImageUpload images);

	public List<ImageUpload> getImages();
}
