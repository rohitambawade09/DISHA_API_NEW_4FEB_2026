package com.disha.hms.repo;

import java.util.List;
import java.util.Map;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.PrePostConsumtionDto;
import com.disha.hms.entity.BillDetailsDto;
import com.disha.hms.entity.PathologySampleWiseMaster;
import com.disha.hms.entity.PathologySampleWiseSuperMaster;

public interface ApiRepo {

	List<ClientDetailsApiDto> getBusinessDetailsList();
	
	Map<String, Object> getCustomerDetails(String customerCode);
	
	String getUnitType(Integer unitId);
	
	List<Map<String, Object>> getTestDetailsforGov(Integer unitId, Integer projectId, Integer customerId);
	
	List<Map<String, Object>> getTestDetailsforOther(Integer unitId);
	
	List<Object[]> getAllUnits();
	
	List<PrePostConsumtionDto> validateClientCreditLimit(PrePostConsumtionDto objres);
	
	List<Map<String, Object>> getCustomerDetails(Integer customerId);
	
	Double getBillConsumedAmount(Integer customerId, Integer cycleId);
	
	Double getConsumeAmount(Integer customerId, Integer cycleId);
	
	Integer getReceiptId(Integer customerId);
	
	String getLastPaymentDate(Integer customerId);
	
	Integer getRecCount(Integer customerId);
	
	List<Map<String, Object>> getListCycle(Integer customerId);
	
	Double getCycleAdvcAmt(Integer customerId, Integer cycleId);
	
	String getPostpaidLastPaymentDate(Integer customerId);
	
	Double getConsumedAmountNew(Integer customerId);
	
	Map<String, Object> getCustomerTypeAndProjectId(Integer customerId);
	
	Integer getMaxCycleId(Integer customerId);
	
	Integer mergeBillDetails(BillDetailsDto obj);
	
	List<Map<String, Object>> getTestDetailsToSendToLab(Integer treatmentId);
	
	String getRunnerBoy(Integer unitId);
	
	List<Map<String, Object>> getProfileMappedDetailsBySubservice(PathologySampleWiseMaster obj, Integer unitId, Integer projectId);
	
	String getCallfromForSubservice(Integer subService);
	
	Integer getDuplicateTestCnt(PathologySampleWiseMaster obj, Integer unitId, PathologySampleWiseMaster master);
	
	Integer updateSndFlagBillDetailsForLab(Integer billDetailsId);
	
	Integer updatePaidFlagForB2B(Integer billDetailsId);
	
	Integer getRowCount(PathologySampleWiseMaster obj, String runnerBoy, PathologySampleWiseMaster master, Integer unitId);
	
	PathologySampleWiseSuperMaster getSuperMasterData(Integer rowCount);
	
	String getAccreditatedFlagForProfile(Integer profileId);
	
	Integer getCountVal(PathologySampleWiseMaster obj, String runnerBoy, Integer unitId);
	
	String getReportFooterFlag(Integer unitId);
	
	String getTemplateWiseValue(Integer profileId);
	
	List<Map<String, Object>> getHistopathTestDetails(PathologySampleWiseMaster obj, Integer projectId, Integer unitId);
	
	PathologySampleWiseSuperMaster mergeSendtoLabData(PathologySampleWiseSuperMaster obj);
	
	Integer closeCampIdForDISHA(String campId);
	
}
