package com.pocosoft.csvImport.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.pocosoft.csvImport.model.EmployeeDetails;
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
		if(file.isEmpty())
			return new ResponseEntity<String>("Please select a CSV file",HttpStatus.OK);
		if(!file.getOriginalFilename().endsWith(".csv"))
			return new ResponseEntity<String>("Please select a CSV file",HttpStatus.OK);
		
		try(Reader csvReader = new BufferedReader(new InputStreamReader(file.getInputStream())))
		{
			CsvToBean<EmployeeDetails> csvBeans = new CsvToBeanBuilder(csvReader).withType(EmployeeDetails.class).withIgnoreLeadingWhiteSpace(true).build();
			//get List of EmployeeDetails
			List <EmployeeDetails> empDetails = csvBeans.parse();
			
			// save list of employee details to Database
			empDetailsRepo.saveAll(empDetails);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<String>("Error processing selected file",HttpStatus.OK);
		}
		return new ResponseEntity<String>("File successfully loaded to database",HttpStatus.OK);
	}
}
