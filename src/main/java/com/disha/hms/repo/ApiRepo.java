package com.disha.hms.repo;

import java.util.List;
import java.util.Map;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.TestDetailsResponseDto;

public interface ApiRepo {

	List<ClientDetailsApiDto> getBusinessDetailsList();
	
	Map<String, Object> getCustomerDetails(String customerCode);
	
	String getUnitType(Integer unitId);
	
	List<Map<String, Object>> getTestDetailsforGov(Integer unitId, Integer projectId, Integer customerId);
	
	List<Map<String, Object>> getTestDetailsforOther(Integer unitId);
}
