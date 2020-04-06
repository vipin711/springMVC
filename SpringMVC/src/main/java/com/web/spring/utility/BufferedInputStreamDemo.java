package com.web.spring.utility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamDemo {

	public static void main(String[] args) {
		FileInputStream fin = null;
		try {
			
			fin = new FileInputStream("C:/Users/CHauhanV/Pictures/Saved Pictures/vip.jpg");


		BufferedInputStream bin = new BufferedInputStream(fin);

		
		System.out.println("Number of remaining bytes:" + bin.available());

		boolean b = bin.markSupported();
		if (b)
			
				bin.mark(bin.available());


		bin.skip(4);
		System.out.println("FileContents :");

		int ch;
		while ((ch = bin.read()) != -1)
			System.out.print((char) ch);

		bin.reset();
		while ((ch = bin.read()) != -1)
			System.out.print((char) ch);

		fin.close();
	}catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
