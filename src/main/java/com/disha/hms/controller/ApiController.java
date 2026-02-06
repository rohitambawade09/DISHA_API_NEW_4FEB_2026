package com.disha.hms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.ResponseOutput;
import com.disha.hms.service.ApiService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "ApiController", description = "APIs for the Application")
public class ApiController {
	
	@Autowired
	ApiService apiService;
	
	@GetMapping("/getBusinessDetailsList")
	public ResponseEntity<ResponseOutput>  getBusinessDetailsList()
	{
		ResponseOutput obj = new ResponseOutput();
		
		List<ClientDetailsApiDto> list = new ArrayList<>();
		list = apiService.getBusinessDetailsList();
		
		obj.setStatus("Success");
		obj.setOutput(list);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello()
	{
		return ResponseEntity.ok().body("Hello World");
	}
	
}
