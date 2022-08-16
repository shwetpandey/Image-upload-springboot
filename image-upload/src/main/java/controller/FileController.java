package controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.image.payloads.FileResponse;

import Service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Value("${project.image}")
	private String path;
	
	@Autowired
	private FileService fileService;
	
	
	@PostMapping("/{str}")
	public ResponseEntity<String> hello(@PathVariable String str){
		return new  ResponseEntity<String>(str,HttpStatus.OK);
	}	

	@PostMapping("/upload")
	public ResponseEntity<FileResponse>fileUpload(@RequestParam("image")MultipartFile image){
		String fileName;
		try {
			fileName = this.fileService.uploadImage(path, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(null, "Image is not uploaded due to some error"),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<>(new FileResponse(fileName, "Image is succesfully uploaded"),HttpStatus.OK);
		
	}
}
