package com.disha.hms.service;

import java.util.List;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.TestDetailsResponseDto;

public interface ApiService {

	List<ClientDetailsApiDto> getBusinessDetailsList();
	
	TestDetailsResponseDto getTestbyCustomerId(String customerCode);
	
}
