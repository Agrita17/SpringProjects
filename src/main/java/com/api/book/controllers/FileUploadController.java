package com.api.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.healper.FileUploadHelper;

@RestController
public class FileUploadController {
	@Autowired
	private FileUploadHelper fileUploadHelper;
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile image)
	{
		try {
			System.out.print(image.getOriginalFilename());
			if(image.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
			}
			if(!image.getContentType().equals("image/jpeg"))
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File should be of JPEG type");
			}
				//file upload code..
			boolean f =	fileUploadHelper.uploadFile(image);
			if(f)
			{
				return ResponseEntity.ok("File uploaded successfully");
			}
				
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upoad is not successfull..");
		
	}
}
