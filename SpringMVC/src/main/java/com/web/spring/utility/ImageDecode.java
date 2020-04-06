package com.web.spring.utility;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

public class ImageDecode {

	public static void main(String[] args) throws IOException {
		
		BufferedImage image = null;
		byte[] imageByte;

		BASE64Decoder decoder = new BASE64Decoder();
		imageByte = decoder.decodeBuffer("TXlJbWFnZUZpbGUucG5n");
		System.out.println(imageByte);
		ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
		System.out.println(bis);
		
		image = ImageIO.read(bis);
		bis.close();

		// write the image to a file
		File outputfile = new File("image.png");
		ImageIO.write(image, "png", outputfile);
	}

}
