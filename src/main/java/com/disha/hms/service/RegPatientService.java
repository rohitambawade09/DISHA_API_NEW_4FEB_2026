package com.disha.hms.service;

import com.disha.hms.entity.BillMasterDto;
import com.disha.hms.entity.RegistrationDto;
import com.disha.hms.entity.TreatmentDto;

public interface RegPatientService {

	Integer savePatientRegDetails(RegistrationDto registrationDto2, String queryType, Integer appointmentId);
	
	Integer saveTreatmentDetails(TreatmentDto treatmentDto, String queryType);
	
	Integer saveBillMaster(BillMasterDto billMasterDto2, String queryType);
	
}
