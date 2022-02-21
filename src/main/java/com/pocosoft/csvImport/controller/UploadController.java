package com.pocosoft.csvImport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pocosoft.csvImport.repository.EmployeeDetailsRepository;

@Controller
public class UploadController {
	
	@Autowired
	EmployeeDetailsRepository empDetailsRepo;
	
	@GetMapping("/")
    public String displayIndexPage()
    {
		return "index";
    }
	
	
	@PostMapping("/process/csv/upload")
	public ResponseEntity<String> processUploadedCSV (@RequestParam("csv_file") MultipartFile file)
	{
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
