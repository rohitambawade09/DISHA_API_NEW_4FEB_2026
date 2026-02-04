package com.disha.hms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	
	@GetMapping("/get")
	public ResponseEntity<String> home()
	{
		return ResponseEntity.ok().body("Hello Wold");
	}
}
