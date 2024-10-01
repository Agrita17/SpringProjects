package com.api.book.healper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.Box.Filler;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
 public final String UPLOAD_DIR="D:\\Agrita Srivastava\\Job Ready\\JAVA_DECELOPMENT\\INTERMEDIATE\\Projects\\bootrestbook\\src\\main\\resources\\static\\image";
 
 public boolean uploadFile(MultipartFile multipartFile) {
	 
	 boolean f = false;
	 try {
			/*
			 * InputStream is = multipartFile.getInputStream(); byte data[]= new
			 * byte[is.available()]; is.read(data);
			 * 
			 * FileOutputStream fileOutputStream = new
			 * FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			 * fileOutputStream.write(data); fileOutputStream.flush();
			 * fileOutputStream.close();
			 */
		 Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		 f=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return f;
 }
}
