package com.disha.hms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disha.hms.config.JwtUtil;
import com.disha.hms.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password) {

    	boolean checkLogin = validateUser(username, password);
    	
        //if ("admin".equals(username) && "admin".equals(password)) {
    	if(checkLogin) {
            String token = jwtUtil.generateToken(username);
            
            Map<String, String> response = new HashMap<>();
            response.put("response", token);
            
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    
    private boolean validateUser(String username, String password)
    {
    	boolean res = false;
    	try {
    		
    		res = authService.validateUser(username, password);
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return res;
    }
}
