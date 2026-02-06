package com.disha.hms.repo;

import java.util.List;

import com.disha.hms.dto.ClientDetailsApiDto;

public interface ApiRepo {

	List<ClientDetailsApiDto> getBusinessDetailsList();
	
}
