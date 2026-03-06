package com.disha.hms.repo;

import java.util.Date;
import java.util.List;

import com.disha.hms.entity.BillMasterDto;
import com.disha.hms.entity.RegistrationDto;
import com.disha.hms.entity.TokenDto;
import com.disha.hms.entity.TreatmentDto;

public interface RegPatientRepo {
	
	Integer saveTreatmentDetails(TreatmentDto treatmentDto, String queryType);
	
	String getHospitalInitials();
	
	Integer getMaxPatientId();
	
	Long getTotalPatientCountByUnitId(Integer unitId);
	
	Integer getUnitIdbyPatientId(Integer patientId);
	
	Integer mergePatient(RegistrationDto obj);
	
	int maxCountOfColumn(@SuppressWarnings("rawtypes") Class className, String columnName);
	
	long getDeptCount(int deptId);
	
	List<Integer> getTreatmentCount(Date date);
	
	List<String> getUnitNamebyUnitId(Integer unitId);
	
	Integer mergeTratment(TreatmentDto treatmentDto);
	
	Integer getTokenCount(TreatmentDto treatmentDto, Date date, Integer loopCnt);
	
	Integer mergeToken(TokenDto tn);
	
	Integer savePatientBMIDeatils(TreatmentDto treatmentDto, String dt, Integer a);
	
	Integer maxCountOfBilling(@SuppressWarnings("rawtypes") Class className,
            String columnName , int paramName);
	
	Integer mergeBillMaster(BillMasterDto billMasterDto);
	
	Integer generateOpdCount(int userId,int treatId, int deptId);
	
}
