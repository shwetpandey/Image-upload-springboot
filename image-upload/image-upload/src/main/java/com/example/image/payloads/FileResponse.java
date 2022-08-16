package com.example.image.payloads;

public class FileResponse {
	
	String fileName;
	String message;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FileResponse(String fileName2, String message2) {
		this.fileName = fileName;
		this.message = message;
	}

}
