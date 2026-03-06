package com.disha.hms.service;

import java.util.List;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.PatientRegistrationDto;
import com.disha.hms.dto.PrePostConsumtionDto;
import com.disha.hms.dto.TestDetailsResponseDto;
import com.disha.hms.dto.UnitMasterDataDto;

public interface ApiService {

	List<ClientDetailsApiDto> getBusinessDetailsList();
	
	TestDetailsResponseDto getTestbyCustomerId(String customerCode);
	
	List<UnitMasterDataDto> getAllUnits();
	
	List<PrePostConsumtionDto> validateClientCreditLimit(PrePostConsumtionDto objres);
	
	Integer registerPatientFromHMIS(PatientRegistrationDto patientObj);
	
	Integer closeCampIdForDISHA(String campId);
	
}
