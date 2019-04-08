package com.ab.places;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

 
//RestController pentru upload de file...

@Controller
@RequestMapping("/upload")
public class FileUpload {


// 8x2912 9dw930329dwe 90cw9f0w09w
@PostMapping("/File")
public ResponseEntity<Object> fileUpload(@RequestParam("uploadFile") MultipartFile file)
throws IOException {
	System.out.println("Ajunge in functie FILEPLOAD");
	System.out.println(file.getName());
	// Save file on system
	if (!file.getOriginalFilename().isEmpty()) {
		BufferedOutputStream outputStream = new BufferedOutputStream(
		  new FileOutputStream(new File("C:/Upload", file.getOriginalFilename())));
		         outputStream.write(file.getBytes());
		         outputStream.flush();
		         outputStream.close();
		      }
			else{
		         return new ResponseEntity<>("Invalid file.",HttpStatus.BAD_REQUEST);
		      }
		      return new ResponseEntity<>("File Uploaded Successfully.",HttpStatus.OK);
}
 

}