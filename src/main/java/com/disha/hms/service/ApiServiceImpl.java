package com.disha.hms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.TestDetailsDto;
import com.disha.hms.dto.TestDetailsResponseDto;
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

	@Override
	public TestDetailsResponseDto getTestbyCustomerId(String customerCode) {
		// TODO Auto-generated method stub
		
		TestDetailsResponseDto obj = new TestDetailsResponseDto();
		try {
			
			Map<String, Object> mapObj = apiRepo.getCustomerDetails(customerCode);
			
			Integer customerId = (Integer) mapObj.get("lab_id");
			String customerName = (String) mapObj.get("lab_name");
			Integer unitId = (Integer) mapObj.get("unit_id");
			Integer projectId = (Integer) mapObj.get("project_id");
			
			obj.setCustomerId(customerId);
			obj.setCustomerName(customerName);
			obj.setCustomerCode(customerCode);
			
			String type = apiRepo.getUnitType(unitId);
			
			List<Map<String, Object>> list = new ArrayList<>();
			if(type.equalsIgnoreCase("GOV"))
			{
				list = apiRepo.getTestDetailsforGov(unitId, projectId, customerId);
			} else {
				list = apiRepo.getTestDetailsforOther(unitId);
			}
			
			List<TestDetailsDto> listTestDetailsDto = new ArrayList<>();
			for(Map<String, Object> rs : list)
			{
				Integer subServiceId = (Integer) rs.get("service_id");
				String subServiceCode = (String) rs.get("subservice_code");
				String subServiceName = (String) rs.get("category_name");
				Integer profileId = (Integer) rs.get("profile_id");
				Double b2cCharges = ((Number) rs.get("b2ccharges")).doubleValue();
				Double b2bCharges = ((Number) rs.get("b2bcharges")).doubleValue();
				String sampleTypeName = (String) rs.get("sample_type_name");
				
				TestDetailsDto objTestDetailsDto = new TestDetailsDto();
				
				objTestDetailsDto.setSubServiceId(subServiceId);
				objTestDetailsDto.setSubServiceCode(subServiceCode);
				objTestDetailsDto.setSubServiceName(subServiceName);
				objTestDetailsDto.setProfileId(profileId);
				objTestDetailsDto.setB2cCharges(b2cCharges);
				objTestDetailsDto.setB2bCharges(b2bCharges);
				objTestDetailsDto.setSampleTypeName(sampleTypeName);
				
				listTestDetailsDto.add(objTestDetailsDto);
			}
			
			obj.setListTestDetailsDto(listTestDetailsDto);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return obj;
		
	}

}
