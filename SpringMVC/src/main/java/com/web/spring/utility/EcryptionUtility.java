package com.web.spring.utility;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;




public class EcryptionUtility {

	 private String inputFilePath = "C:/Users/CHauhanV/Pictures/Camera Roll/vip.jpg";
	    private String outputFilePath = "C:/Users/CHauhanV/Pictures/Camera Roll/test_image_copy.jpg";
	 
	    
	    public void fileToBase64StringConversion() throws IOException {
	        
	        ClassLoader classLoader = getClass().getClassLoader();
	        File inputFile = new File(classLoader.getResource(inputFilePath).getFile());
	 
	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
	        String encodedString = Base64.getEncoder().encodeToString(fileContent);
	 
	        // create output file
	        File outputFile = new File(inputFile.getParentFile().getAbsolutePath() + File.pathSeparator + outputFilePath);
	}
}