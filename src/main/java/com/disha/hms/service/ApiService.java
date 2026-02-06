package com.disha.hms.service;

import java.util.List;

import com.disha.hms.dto.ClientDetailsApiDto;

public interface ApiService {

	List<ClientDetailsApiDto> getBusinessDetailsList();
	
}
