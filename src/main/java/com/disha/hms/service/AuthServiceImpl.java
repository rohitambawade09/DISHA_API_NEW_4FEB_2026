package com.disha.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disha.hms.repo.AuthRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	AuthRepo authRepo;
	
	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return authRepo.validateUser(username, password);
	}

}
