package com.pocosoft.csvImport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UploadController {
	
	
	@GetMapping("/")
    public String displayIndexPage()
    {
		return "index";
    }
}
