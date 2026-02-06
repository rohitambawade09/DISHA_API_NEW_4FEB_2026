package com.disha.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.repo.ApiRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiServiceImpl implements ApiService {
	
	@Autowired
	ApiRepo apiRepo;

	@Override
	public List<ClientDetailsApiDto> getBusinessDetailsList() {
		// TODO Auto-generated method stub
		return apiRepo.getBusinessDetailsList();
	}

}
