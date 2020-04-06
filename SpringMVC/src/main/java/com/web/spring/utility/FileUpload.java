package com.web.spring.utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileUpload {

	 
	 public static boolean uploadImages(String inputImagePath,
	            String outputImagePath, String formatName) throws IOException {
	       
		 	FileInputStream inputStream = new FileInputStream(inputImagePath);
	        FileOutputStream outputStream = new FileOutputStream(outputImagePath);
	         
	        // reads input image from file
	        BufferedImage inputImage = ImageIO.read(inputStream);
	         
	        // writes to the output image in specified format
	        boolean result = ImageIO.write(inputImage, formatName, outputStream);
	         
	        
	        // needs to close the streams
	        outputStream.close();
	        inputStream.close();
	         
	        return result;
	    }
	 
	  public static void main(String[] args) {
	        String inputImage = "C:/Users/CHauhanV/Pictures/Saved Pictures/";
	        String oututImage = "D:/VipinBackup/1234.png";
	        String formatName = "JPG";
	      
	   File file =  new File("C:/Users/CHauhanV/Pictures/Saved Pictures/");
	   File[] listOfFiles = file.listFiles();
       for (File f: listOfFiles) {
           if (f.isFile()) {
               System.out.println("File " + f.getName());
           } 
       }
	       /* try {
	            boolean result = convertFormat(inputImage,
	                    oututImage, formatName);
	            if (result) {
	                System.out.println("Image converted successfully.");
	            } else {
	                System.out.println("Could not convert image.");
	            }
	        } catch (IOException ex) {
	            System.out.println("Error during converting image.");
	            ex.printStackTrace();
	        }*/
	        
	    } 
}
