package com.disha.hms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.PatientRegistrationDto;
import com.disha.hms.dto.PrePostConsumtionDto;
import com.disha.hms.dto.TestDetailsDto;
import com.disha.hms.dto.TestDetailsForRegistrationDto;
import com.disha.hms.dto.TestDetailsResponseDto;
import com.disha.hms.dto.UnitMasterDataDto;
import com.disha.hms.entity.BillDetailsDto;
import com.disha.hms.entity.BillMasterDto;
import com.disha.hms.entity.BusinessCustMasterDto;
import com.disha.hms.entity.PathologySampleWiseMaster;
import com.disha.hms.entity.PathologySampleWiseSlave;
import com.disha.hms.entity.PathologySampleWiseSuperMaster;
import com.disha.hms.entity.RegistrationDto;
import com.disha.hms.entity.TreatmentDto;
import com.disha.hms.repo.ApiRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ApiServiceImpl implements ApiService {
	
	@Value("${pathologyId}")
	private Integer pathologyId;
	
	@Value("${packageID}")
	private Integer packageId;

	@Value("${CovidReportProfileId}")
	private Integer covidProfileId1;
	
	@Value("${SARSCOV2ANTIGEN}")
	private Integer covidProfileId2;
	
	@Value("${COVID19RNAAMPLIFICATION}")
	private Integer covidProfileId3;
	
	@Value("${REALTIMEHEPATITISCVIRUSHCV}")
	private Integer covidProfileId4;
	
	@Value("${REALTIMETRUENAT}")
	private Integer covidProfileId5;
	
	@Autowired
	ApiRepo apiRepo;
	
	@Autowired
	RegPatientService regPatientService;

	java.util.Calendar currentDate = java.util.Calendar.getInstance();
	
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String collectionDate = dateFormat.format(currentDate.getTime());

    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:ss");
	String collectionTime = timeFormat.format(currentDate.getTime());
	
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
			if (type.equalsIgnoreCase("GOV")) {
				list = apiRepo.getTestDetailsforGov(unitId, projectId, customerId);
			} else {
				list = apiRepo.getTestDetailsforOther(unitId);
			}

			List<TestDetailsDto> listTestDetailsDto = new ArrayList<>();
			for (Map<String, Object> rs : list) {
				Integer subServiceId = (Integer) rs.get("sub_service_id");
				String subServiceCode = (String) rs.get("subservice_code");
				String subServiceName = (String) rs.get("category_name");
				Integer profileId = (Integer) rs.get("profile_id");
				Double b2cCharges = ((Number) rs.get("b2ccharges")).doubleValue();
				Double b2bCharges = ((Number) rs.get("b2bcharges")).doubleValue();
				String sampleTypeName = (String) rs.get("sample_type_name");
				Integer sampleTypeId = (Integer) rs.get("sample_type_id");
				String templateWise = (String) rs.get("template_wise");
				Integer serviceId = (Integer) rs.get("service_id");

				TestDetailsDto objTestDetailsDto = new TestDetailsDto();

				objTestDetailsDto.setSubServiceId(subServiceId);
				objTestDetailsDto.setSubServiceCode(subServiceCode);
				objTestDetailsDto.setSubServiceName(subServiceName);
				objTestDetailsDto.setProfileId(profileId);
				objTestDetailsDto.setB2cCharges(b2cCharges);
				objTestDetailsDto.setB2bCharges(b2bCharges);
				objTestDetailsDto.setSampleTypeName(sampleTypeName);
				objTestDetailsDto.setSampleTypeId(sampleTypeId);
				objTestDetailsDto.setTemplateWise(templateWise);
				objTestDetailsDto.setServiceId(serviceId);

				listTestDetailsDto.add(objTestDetailsDto);
			}

			obj.setListTestDetailsDto(listTestDetailsDto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;

	}

	@Override
	public List<UnitMasterDataDto> getAllUnits() {

		List<UnitMasterDataDto> list = new ArrayList<>();

		try {

			List<Object[]> reslist = apiRepo.getAllUnits();

			for (Object[] rs : reslist) {
				UnitMasterDataDto obj = new UnitMasterDataDto();

				Integer unitId = (Integer) rs[0];
				String unitName = ((String) rs[1]).trim();

				obj.setUnitId(unitId);
				obj.setUnitName(unitName);

				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<PrePostConsumtionDto> validateClientCreditLimit(PrePostConsumtionDto objres) {

		List<PrePostConsumtionDto> lstPrePostConsumtionDto = new ArrayList<PrePostConsumtionDto>();

		try {

			int customerId = objres.getCustomerId();
			int receiptId = 0;
			double prepaidAmount = 0, prepaidSmsPer = 0, prepaidBlockPer = 0;
			double prepaidDays = 0, prepaidSmsOnDay = 0, prepaidBlockOnDay = 0;
			double postpaidAmount = 0, postpaidSmsPer = 0, postpaidBlockPer = 0;
			double postpaidCreditDay = 0, postpaidSmsOnDay = 0, postpaidBlockOnDay = 0;
			double billConsumeAmount = 0, consumeAmount = 0, billRemainAmount = 0, remainAmount = 0;
			double bulkSettlementAmount = 0;
			double totalCustomerAmount = 0;
			String paymentFlag = "";
			String customerTypeName = "";
			String customerName = "";
			String lastPaymentDate = "-";
			String parentBalanceUtilization = "";
			String pre_to_date = "";
			String post_to_date = "";
			String parentFlag = "";
			Integer parentId = 0;
			double usableAmt = 0;

			int currentRecId = 0, carryRecId = 0, cycleId = -1;
			double carryAmount = 0, cycleRefundAmt = 0, cycleRemainAmt = 0, carryFwdAmt = 0, availableAmount = 0;
			double cycleAdvcAmt = 0, consumedAmountNew = 0.0;
			String cycleRecIds = "", cycleDate = "";
			long daysDiff = 0;

			java.util.Calendar currentDate = java.util.Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String todayDate = formatter.format(currentDate.getTime());

			BusinessCustMasterDto objCustomerDetails = getCustomerDetails(customerId);

			Integer unitId = objCustomerDetails.getBusinessMasterDto().get(0).getUnitId();

			for (BusinessCustMasterDto objMaster : objCustomerDetails.getBusinessMasterDto()) {

				paymentFlag = objMaster.getPaymentFlag();
				customerName = objMaster.getName();
				customerTypeName = objMaster.getCustomerTypeName();
				parentFlag = objMaster.getParentBalanceUtilization();
				parentId = objMaster.getParentId();
				parentBalanceUtilization = objMaster.getParentBalanceUtilization();

				receiptId = apiRepo.getReceiptId(customerId);

				if (paymentFlag.equals("prepaid")) {

					prepaidAmount = objMaster.getAdvanceAmount();
					prepaidDays = objMaster.getPrePaidDay();
					prepaidSmsPer = objMaster.getReminderOnPercentagePrepaid();
					prepaidSmsOnDay = objMaster.getReminderOnPrepaidDay();
					prepaidBlockPer = objMaster.getBlockOnpercentagePrepaid();
					prepaidBlockOnDay = objMaster.getBlockOnPrepaidDay();
					pre_to_date = objMaster.getPreToDate();

					lastPaymentDate = apiRepo.getLastPaymentDate(customerId);
					Integer recCount = apiRepo.getRecCount(customerId);

					if (recCount > 0) {

						List<Map<String, Object>> listCycle = apiRepo.getListCycle(customerId);

						for (Map<String, Object> row : listCycle) {

							cycleId = ((Number) row.get("cycleid")).intValue();
							// cycleAdvcAmt = (Double) row.get("AdvcAmt");
							cycleRefundAmt = (Double) row.get("refundamt");
							cycleDate = (String) row.get("cycledate");
							cycleRecIds = (String) row.get("receiptids");
							carryFwdAmt = (Double) row.get("carryfwdamt");
							cycleRemainAmt = (Double) row.get("remainamt");
						}

						cycleAdvcAmt = apiRepo.getCycleAdvcAmt(customerId, cycleId);

						String inputString1 = cycleDate;
						String inputString2 = todayDate;

						try {
							Date date1 = formatter.parse(inputString1);
							Date date2 = formatter.parse(inputString2);
							long diff = date2.getTime() - date1.getTime();
							daysDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

						} catch (ParseException e) {
							e.printStackTrace();
						}
					}

					if (cycleRemainAmt > 0 && daysDiff > objMaster.getBlockOnPrepaidDay()) {

						carryAmount = cycleRemainAmt;
					}

					consumeAmount = apiRepo.getConsumeAmount(customerId, cycleId);

					System.err.println("consumedAmount*** " + consumeAmount);

					consumedAmountNew = apiRepo.getConsumedAmountNew(customerId);

					System.err.println("consumedAmountNew*** " + consumedAmountNew);

					billConsumeAmount = apiRepo.getBillConsumedAmount(customerId, cycleId);

					System.err.println("billConsumedAmount*** " + billConsumeAmount);

					availableAmount = (cycleAdvcAmt + carryFwdAmt) - cycleRefundAmt;// here 0 replace with carry
																					// forwarded amount
					usableAmt = (availableAmount * prepaidBlockPer) / 100;
					remainAmount = availableAmount - consumeAmount;

					billRemainAmount = availableAmount - billConsumeAmount;

				} else {

					postpaidAmount = objMaster.getCredithAmount();
					postpaidCreditDay = objMaster.getCreditDay();
					postpaidSmsPer = objMaster.getReminderOnPercentagePostPaid();
					postpaidSmsOnDay = objMaster.getReminderOnCreditDay();
					postpaidBlockPer = objMaster.getBlockOnpercentagePostPaid();
					postpaidBlockOnDay = objMaster.getBlockOnCreditDay();
					post_to_date = objMaster.getPostToDate();

					lastPaymentDate = apiRepo.getPostpaidLastPaymentDate(customerId);

					usableAmt = (postpaidAmount * postpaidBlockPer) / 100;
					billRemainAmount = usableAmt - billConsumeAmount;
					remainAmount = postpaidAmount - consumeAmount;
				}

				System.err.println("billRemainAmount*** " + billRemainAmount);

				objres.setCustomerTypeName(customerTypeName);
				objres.setCustomerName(customerName);
				objres.setPaymentFlag(paymentFlag);
				objres.setLastPaymentDate(lastPaymentDate);
				// For Prepaid
				objres.setPrepaidAmount(prepaidAmount);
				objres.setPrepaidDays(prepaidDays);
				objres.setPrepaidBlockPer(prepaidBlockPer);
				objres.setPrepaidBlockOnDay(prepaidBlockOnDay);
				objres.setPrepaidSmsPer(prepaidSmsPer);
				objres.setPrepaidSmsOnDay(prepaidSmsOnDay);
				objres.setPreToDate(pre_to_date);
				objres.setCarryAmount(carryAmount);
				// For Postpaid
				objres.setPostpaidAmount(postpaidAmount);
				objres.setPostpaidCreditDays(postpaidCreditDay);
				objres.setPostpaidSmsPer(postpaidSmsPer);
				objres.setPostpaidSmsOnDay(postpaidSmsOnDay);
				objres.setPostpaidBlockPer(postpaidBlockPer);
				objres.setPostpaidBlockOnDay(postpaidBlockOnDay);
				objres.setPostToDate(post_to_date);

				objres.setBillConsumeAmount(billConsumeAmount);
				objres.setBillRemainAmount(billRemainAmount);
				objres.setConsumeAmount(consumeAmount);
				objres.setRemainAmount(remainAmount);
				objres.setPrepaidReceiptId(receiptId);
				objres.setParentFlag(parentFlag);
				objres.setParentId(parentId);

				lstPrePostConsumtionDto.add(objres);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lstPrePostConsumtionDto;
	}
	
	private BusinessCustMasterDto getCustomerDetails(Integer customerId)
	{
		BusinessCustMasterDto obj = new BusinessCustMasterDto();

		double prepaidAmount = 0, prepaidSmsPer = 0, prepaidBlockPer = 0;
		double prepaidDays = 0, prepaidSmsOnDay = 0, prepaidBlockOnDay = 0;
		double postpaidAmount = 0, postpaidSmsPer = 0, postpaidBlockPer = 0;
		double postpaidCreditDay = 0, postpaidSmsOnDay = 0, postpaidBlockOnDay = 0;
		String paymentFlag = "";
		String customerTypeName = "";
		String customerName = "";
		String parentBalanceUtilization = "";
		String pre_to_date = "";
		String post_to_date = "";
		Integer parentId = 0, unitId = 0;

		try {

			List<BusinessCustMasterDto> lstInhouseLab = new ArrayList<BusinessCustMasterDto>();

			List<Map<String, Object>> list = apiRepo.getCustomerDetails(customerId);

			for (Map<String, Object> rs : list) {
				paymentFlag = (String) rs.get("payment_flag");
				customerName = (String) rs.get("lab_name");
				customerTypeName = (String) rs.get("customer_type_name");
				parentId = (Integer) rs.get("parent_id");
				parentBalanceUtilization = (String) rs.get("parent_balance_utilization");

				prepaidAmount = (Double) rs.get("advance_amount");
				prepaidDays = (Double) rs.get("prepaid_day");
				prepaidSmsPer = (Double) rs.get("reminder_on_percentage_prepaid");
				prepaidSmsOnDay = (Double) rs.get("reminder_on_prepaid_day");
				prepaidBlockPer = (Double) rs.get("block_percentage_prepaid");
				prepaidBlockOnDay = (Double) rs.get("block_on_prepaid_day");
				pre_to_date = (String) rs.get("pre_to_date");

				postpaidAmount = (Double) rs.get("credit_amount");
				postpaidCreditDay = (Double) rs.get("credit_day");
				postpaidSmsPer = (Double) rs.get("reminder_on_percentage_postpaid");
				postpaidSmsOnDay = (Double) rs.get("reminder_on_credit_day");
				postpaidBlockPer = (Double) rs.get("block_percentage_postpaid");
				postpaidBlockOnDay = (Double) rs.get("block_on_credit_day");
				post_to_date = (String) rs.get("post_to_date");
				unitId = (Integer) rs.get("unit_id");

				BusinessCustMasterDto objfinal = new BusinessCustMasterDto();

				objfinal.setPaymentFlag(paymentFlag);
				objfinal.setName(customerName);
				objfinal.setCustomerTypeName(customerTypeName);
				objfinal.setParentId(parentId);
				objfinal.setParentBalanceUtilization(parentBalanceUtilization);

				objfinal.setAdvanceAmount(prepaidAmount);
				objfinal.setPrePaidDay(prepaidDays);
				objfinal.setReminderOnPercentagePrepaid(prepaidSmsPer);
				objfinal.setReminderOnPrepaidDay(prepaidSmsOnDay);
				objfinal.setBlockOnpercentagePrepaid(prepaidBlockPer);
				objfinal.setBlockOnPrepaidDay(prepaidBlockOnDay);
				objfinal.setPreToDate(pre_to_date);

				objfinal.setCredithAmount(postpaidAmount);
				objfinal.setCreditDay(postpaidCreditDay);
				objfinal.setReminderOnPercentagePostPaid(postpaidSmsPer);
				objfinal.setReminderOnCreditDay(postpaidSmsOnDay);
				objfinal.setBlockOnpercentagePostPaid(postpaidBlockPer);
				objfinal.setBlockOnCreditDay(postpaidBlockOnDay);
				objfinal.setPostToDate(post_to_date);
				objfinal.setUnitId(unitId);

				lstInhouseLab.add(objfinal);

			}

			obj.setBusinessMasterDto(lstInhouseLab);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public Integer registerPatientFromHMIS(PatientRegistrationDto patientObj) {

		Integer treatmentId = 0;
		try {
			
			// validate customer remaining amount
			PrePostConsumtionDto objres = new PrePostConsumtionDto();
			objres.setCustomerId(patientObj.getCustomerId());
			List<PrePostConsumtionDto> listCustDetails = validateClientCreditLimit(objres);
			
			Double remainAmount = listCustDetails.get(0).getBillRemainAmount();
			Double substrRemainAmount = remainAmount - patientObj.getTotalAmount();
			log.info("remainAmount***** " + remainAmount);
			log.info("substrRemainAmount***** " + substrRemainAmount);
			
			if(substrRemainAmount <= 0)
				return -1;

			log.info("patient info***** " + patientObj);
			System.out.println("patient info***** " + patientObj);

			int billId = 0;
			int AppId = 0;
			int userId = patientObj.getCreatedBy();
			int unitId = patientObj.getUnitId();
			int appointmentId = 0;
			String visitCode = patientObj.getVisitCode();
			String campId = patientObj.getCampId();

			String queryType = "";
			if (patientObj.getPatientId() != null && patientObj.getPatientId() == 0) {
				queryType = "insert";
			} else {
				queryType = "markvisit";
			}

			Map<String, Object> getMap = apiRepo.getCustomerTypeAndProjectId(patientObj.getCustomerId());
			Integer customerType = (Integer) getMap.get("customer_type");
			Integer projectId = (Integer) getMap.get("project_id");
			String paymentFlag = (String) getMap.get("payment_flag");

			// ====================== For ehat_patient table DTO
			// ============================
			RegistrationDto registrationDto2 = new RegistrationDto();

			if (patientObj.getPatientId() != 0)
				registrationDto2.setPatientId(patientObj.getPatientId());

			registrationDto2.setPrefix(patientObj.getTitle());
			registrationDto2.setfName(patientObj.getFname().trim().toUpperCase());
			registrationDto2.setmName(patientObj.getMname().trim().toUpperCase());
			registrationDto2.setlName(patientObj.getLname().trim().toUpperCase());
			registrationDto2.setGender(patientObj.getGender());
			registrationDto2.setMobile(patientObj.getMobile());
			registrationDto2.setAge(patientObj.getAgeYears());
			registrationDto2.setAgeMonths(patientObj.getAgeMonth());
			registrationDto2.setAgeDays(patientObj.getAgeDay());
			registrationDto2.setAddress(patientObj.getAddress());
			registrationDto2.setEmailId(patientObj.getEmail());
			registrationDto2.setUnitId(unitId);
			registrationDto2.setCreatedBy(userId);

			registrationDto2.setCountryId(0);
			registrationDto2.setAreaCode(0);
			registrationDto2.setStateId(1);
			registrationDto2.setTownId(0);
			registrationDto2.setDistrictId(0);
			registrationDto2.setTalukaId(0);
			registrationDto2.setEmergency("N");
			registrationDto2.setExternal("N");
			registrationDto2.setPramoEmail("N");
			registrationDto2.setPramoSMS("N");
			registrationDto2.setTransEmail("Y");
			registrationDto2.setTransSMS("Y");
			registrationDto2.setBlockFlag("N");
			registrationDto2.setRelationId(0);
			registrationDto2.setPerareaCode(0);
			registrationDto2.setPercountryId(1);
			registrationDto2.setPerdistrictId(0);
			registrationDto2.setStateId(0);
			registrationDto2.setPertalukaId(0);
			registrationDto2.setPertownId(0);
			registrationDto2.setOldPatientId("0");
			registrationDto2.setAnnualIncomeId(0);
			registrationDto2.setBloodGroupId(0);
			registrationDto2.setEducation(0);
			registrationDto2.setIdentityProofId(0);
			registrationDto2.setLanguageId(0);
			registrationDto2.setMaritalStatusId(0);
			registrationDto2.setNationalityId(199);
			registrationDto2.setReligionId(0);
			registrationDto2.setBlockUserId1(0);
			registrationDto2.setBlockUserId2(0);
			registrationDto2.setBlockUserId3(0);
			registrationDto2.setPerstateId(0);

			registrationDto2.setBlockUserName1("-");
			registrationDto2.setBlockUserName2("-");
			registrationDto2.setBlockUserName3("-");

			registrationDto2.setNoOfChildren(0);
			registrationDto2.setRelativeNationalityId(0);
			registrationDto2.setLookupDetIdTtl(19);
			registrationDto2.setCountry(1);
			registrationDto2.setCountryCode(1);

			if (queryType.equalsIgnoreCase("insert")) {
				registrationDto2.setCreatedBy(userId);
				registrationDto2.setCreatedDateTime(new Date());
				registrationDto2.setDeleted("N");
			} else if (queryType.equalsIgnoreCase("update") || queryType.equalsIgnoreCase("markvisit")) {
				registrationDto2.setUpdatedBy(userId);
				registrationDto2.setUpdatedDateTime(new Date(new java.util.Date().getTime()));
				registrationDto2.setDeleted("N");
			}

			// Save patient details
			int patId = regPatientService.savePatientRegDetails(registrationDto2, queryType, appointmentId);

			// ====================== For ehat_treatment table DTO
			// ============================

			// set last inserted pid into treatment
			TreatmentDto treatmentDto2 = new TreatmentDto();
			treatmentDto2.setPatientId(patId);
			treatmentDto2.setDepartmentId(1);
			treatmentDto2.setCreatedBy(userId);
			treatmentDto2.setAppointmentId(appointmentId);
			treatmentDto2.setDoctorIdList("");
			treatmentDto2.setBusinessType(1);
			treatmentDto2.setUnitId(unitId);
			treatmentDto2.setReferredBy("-");
			treatmentDto2.settFlag("Y");
			
			// API flags for the HMIS
			treatmentDto2.setHmisApiFlag("Y");
			treatmentDto2.setVisitCode(visitCode);
			treatmentDto2.setCampId(campId);
			treatmentDto2.setCampCloseFlag("N");

			treatmentDto2.setCustomerId(patientObj.getCustomerId());
			treatmentDto2.setCustomerType(customerType);

			if (patientObj.getCollectedDate().equalsIgnoreCase("")
					&& patientObj.getCollectedTime().equalsIgnoreCase("")) {
				treatmentDto2.setCollectionDate(collectionDate);
				treatmentDto2.setCollectionTime(collectionTime);
			} else {
				treatmentDto2.setCollectionDate(patientObj.getCollectedDate());
				treatmentDto2.setCollectionTime(patientObj.getCollectedTime());
			}

			treatmentDto2.setHeight(patientObj.getHeight());
			treatmentDto2.setWeight(patientObj.getWeight());
			// treatmentDto2.setUrineVol(patientObj.getUrineVolume());
			// treatmentDto2.setLmpDate(patientObj.getLmpDate());

			String s1 = "0.00";
			String s2 = "0.00";
			String s3 = "0.00";
			double bmi = Double.valueOf(s1);
			double bsa = Double.valueOf(s2);
			double hcim = Double.valueOf(s3);

			if (queryType.equalsIgnoreCase("insert") || queryType.equalsIgnoreCase("markvisit")) {
				treatmentDto2.setBMI(bmi);
				treatmentDto2.setBSA(bsa);
				treatmentDto2.setHCIM(hcim);
				treatmentDto2.setCreatedBy(userId);
				treatmentDto2.setCreatedDateTime(new Date(new java.util.Date().getTime()));
				treatmentDto2.setDeleted("N");

			} else if (queryType.equalsIgnoreCase("update")) {
				treatmentDto2.setBMI(bmi);
				treatmentDto2.setBSA(bsa);
				treatmentDto2.setHCIM(hcim);
				treatmentDto2.setUpdatedBy(userId);
				treatmentDto2.setUpdatedDateTime(new Date(new java.util.Date().getTime()));
				treatmentDto2.setDeleted("N");
			}

			int treatId = regPatientService.saveTreatmentDetails(treatmentDto2, queryType);

			if (treatId > 0) {
				BillMasterDto billMasterDto2 = new BillMasterDto();
				billMasterDto2.setPatienttId(patId);
				billMasterDto2.setTreatmentId(treatId);
				billMasterDto2.setDepartmentId(1);
				billMasterDto2.setUnitId(unitId);
				billMasterDto2.setCreatedBy(userId);

				if (queryType.equalsIgnoreCase("insert") || queryType.equalsIgnoreCase("markvisit")) { // To Insert
																										// Record

					billMasterDto2.setCreatedBy(userId);
					billMasterDto2.setCreatedDateTime(new Date(new java.util.Date().getTime()));
					billMasterDto2.setDeleted("N");

				} else if (queryType.equalsIgnoreCase("update")) {// To Update Record

					billMasterDto2.setUpdatedBy(userId);
					billMasterDto2.setUpdatedDateTime(new Date(new java.util.Date().getTime()));
					billMasterDto2.setDeleted("N");
				}

				billId = regPatientService.saveBillMaster(billMasterDto2, queryType);

			}

			Integer cycleId = apiRepo.getMaxCycleId(patientObj.getCustomerId());

			for (TestDetailsForRegistrationDto rs : patientObj.getListTestDetails()) {
				System.out.println(rs);

				BillDetailsDto billDetailsDto2 = new BillDetailsDto();
				billDetailsDto2.setPatienttId(patId);
				billDetailsDto2.setTreatmentId(treatId);
				billDetailsDto2.setBillId(billId);
				billDetailsDto2.setDepartmentId(1);
				billDetailsDto2.setCreatedBy(userId);
				billDetailsDto2.setUnitId(unitId);
				billDetailsDto2.setSponsorId(0);
				billDetailsDto2.setChargesSlaveId(0);
				billDetailsDto2.setCreatedDateTime(new Date(new java.util.Date().getTime()));
				billDetailsDto2.setSampleTypeId(rs.getSampleTypeId());
				billDetailsDto2.setServiceId(11);
				billDetailsDto2.setSubServiceId(rs.getSubServiceId());
				billDetailsDto2.setRate(rs.getAmount());
				billDetailsDto2.setAmount(rs.getAmount());
				billDetailsDto2.setCoPay(rs.getAmount());
				billDetailsDto2.setOtherRate(rs.getAmount());
				billDetailsDto2.setOtherAmount(rs.getAmount());
				billDetailsDto2.setOtherPay(rs.getAmount());
				billDetailsDto2.setCollectionDate(patientObj.getCollectedDate());
				billDetailsDto2.setCollectionTime(patientObj.getCollectedTime());

				billDetailsDto2.setBusinessType(1);
				billDetailsDto2.setCustomerType(customerType);
				billDetailsDto2.setCustomerId(patientObj.getCustomerId());
				billDetailsDto2.setBarCode(rs.getBarCode());
				billDetailsDto2.setPrepaidReceiptId(cycleId);
				billDetailsDto2.setProjectId(projectId);

				apiRepo.mergeBillDetails(billDetailsDto2);
			}

			sendToLabB2B(userId, unitId, treatId, patId, 1, projectId, paymentFlag);

			treatmentId = treatId;
			
		} catch (Exception e) {
			log.info("Patient Registration error**** " + e.getMessage());
			e.printStackTrace();
			treatmentId = 0;
		}

		return treatmentId;
	}
	
	public void sendToLabB2B(Integer userId, Integer unitId, Integer treatmentId, Integer patient_id, Integer dept_id, 
			Integer projectId, String paymentFlag)
	{
		List<PathologySampleWiseMaster> servicesList = new ArrayList<>();
		PathologySampleWiseMaster master = new PathologySampleWiseMaster();

		try {
			master.setPatientId(patient_id);
			master.setTreatmentId(treatmentId);
			master.setDepartmentId(dept_id);
			master.setUnitId(unitId);

			List<Map<String, Object>> subServicesList = apiRepo.getTestDetailsToSendToLab(treatmentId);
			for (Map<String, Object> row : subServicesList) {
				PathologySampleWiseMaster dto = new PathologySampleWiseMaster();
				dto.setBilDetId((Integer) row.get("bill_details_id"));
				dto.setServiceId((Integer) row.get("service_id"));
				dto.setSubServiceId((Integer) row.get("sub_service_id"));
				dto.setRefdocid((Integer) row.get("reg_ref_doc_id"));
				dto.setGender((String) row.get("gender"));
				dto.setSampleTypeId((Integer) row.get("sample_type_id"));
				dto.setInOutHouse((Integer) row.get("in_out_house"));
				dto.setBarCode((String) row.get("bar_code"));
				dto.setBusinessType((Integer) row.get("business_type"));
				dto.setCustomerId((Integer) row.get("customer_id"));
				dto.setCustomerType((Integer) row.get("customer_type"));
				dto.setCollectionDate((String) row.get("collection_date"));
				dto.setCollectionTime((String) row.get("collection_time"));

				master.setGender((String) row.get("gender"));

				servicesList.add(dto);
			}

			sendToPhlebotomyB2B(master, servicesList, userId, unitId, "other", projectId, paymentFlag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Integer sendToPhlebotomyB2B(PathologySampleWiseMaster master, List<PathologySampleWiseMaster> servicesList, 
			Integer userId, Integer unitId, String registeredAt, Integer projectId, String paymentType) {

		Integer[] array = { covidProfileId1, covidProfileId2, covidProfileId3, covidProfileId4, covidProfileId5 };
		List<Integer> covidProfileIds = Arrays.asList(array);

		try {

			Integer serviceId = 0;
			String runnerBoy = apiRepo.getRunnerBoy(unitId);

			String reportFooterFlag = apiRepo.getReportFooterFlag(unitId);

			for (PathologySampleWiseMaster obj : servicesList) {

				String callfrom = apiRepo.getCallfromForSubservice(obj.getSubServiceId());

				serviceId = obj.getServiceId();

				if (callfrom != null) {

					Integer count2 = apiRepo.getDuplicateTestCnt(obj, unitId, master);
					if (count2 > 0)
						return -1;

					int result = apiRepo.updateSndFlagBillDetailsForLab(obj.getBilDetId());

					if (obj.getBusinessType() == 1 && paymentType.equalsIgnoreCase("prepaid")) {
						apiRepo.updatePaidFlagForB2B(obj.getBilDetId());
					}

					int superCount = 0;
					int count = 0;

					List<Map<String, Object>> list = apiRepo.getProfileMappedDetailsBySubservice(obj, unitId,
							projectId);

					PathologySampleWiseSuperMaster superMaster = new PathologySampleWiseSuperMaster();
					List<PathologySampleWiseMaster> masterList = new ArrayList<>();
					List<PathologySampleWiseSlave> slaveList = new ArrayList<>();
					if (callfrom.equalsIgnoreCase("Histopath")) {

						List<Map<String, Object>> list1 = apiRepo.getHistopathTestDetails(obj, projectId, unitId);
						for (Map<String, Object> row : list1) {

							PathologySampleWiseSlave slave = new PathologySampleWiseSlave();
							String sqlRef = "";
							if (superCount == 0) {

								Integer rowCount = apiRepo.getRowCount(obj, runnerBoy, master, unitId);

								if (rowCount == null) {
									rowCount = 0;
								}

								if (rowCount > 0) {

									PathologySampleWiseSuperMaster superMaster1 = apiRepo.getSuperMasterData(rowCount);

									masterList.addAll(superMaster1.getPathologySampleWiseMaster());

									superMaster.setSampleWiseSuperMasterId(rowCount);
									superMaster.setProfileId((Integer) row.get("profileid"));
									superMaster.setSampleTypeId((Integer) row.get("sampleid"));
									superMaster.setContainerId((Integer) row.get("containerid"));

									if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
										superMaster.setTeststatus((Integer) (112));
										superMaster.setPhleboteststatus("R");
									} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {
										superMaster.setTeststatus((Integer) (2));
									} else {
										superMaster.setTeststatus((Integer) (1));
									}

									superMaster.setServiceId((Integer) (obj.getServiceId()));
									superMaster.setSubServiceId((Integer) (obj.getSubServiceId()));
									superMaster.setUnitId((Integer) (unitId));
									superMaster.setBilDetId((Integer) (obj.getBilDetId()));
									superMaster.setBarCode((String) (obj.getBarCode()));
									superMaster.setSampleTypeId((Integer) (obj.getSampleTypeId()));
									superMaster.setInOutHouse((Integer) (obj.getInOutHouse()));
									superMaster.setBusinessType((Integer) (obj.getBusinessType()));
									superMaster.setCollectionDate((String) (obj.getCollectionDate()));
									superMaster.setCollectionTime((String) (obj.getCollectionTime()));

									superMaster.setCustomerType((Integer) (obj.getCustomerType()));
									superMaster.setCustomerId((Integer) (obj.getCustomerId()));

									superMaster.setPatientId((Integer) (master.getPatientId()));
									superMaster.setTreatmentId((Integer) (master.getTreatmentId()));
									superMaster.setRefdocid(obj.getRefdocid());
									superMaster.setRegRefDocId(master.getRegRefDocId());
									superMaster.setPackageId(obj.getPackageId());
								} else {
									superMaster.setProfileId((Integer) row.get("profileid"));
									superMaster.setSampleTypeId((Integer) row.get("sampleid"));
									superMaster.setContainerId((Integer) row.get("containerid"));

									if (((Integer) obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
										superMaster.setTeststatus((Integer) (112));
										superMaster.setPhleboteststatus("R");
									} else if (((Integer) obj.getBusinessType()) == 1
											&& runnerBoy.equalsIgnoreCase("NRRB")) {
										master.setTeststatus((Integer) (2));

									} else {
										superMaster.setTeststatus((Integer) (1));
									}

									superMaster.setServiceId((Integer) (obj.getServiceId()));
									superMaster.setSubServiceId((Integer) (obj.getSubServiceId()));
									superMaster.setUnitId((Integer) (unitId));
									superMaster.setBilDetId((Integer) (obj.getBilDetId()));
									superMaster.setBarCode((String) (obj.getBarCode()));
									superMaster.setSampleTypeId((Integer) (obj.getSampleTypeId()));
									superMaster.setInOutHouse((Integer) (obj.getInOutHouse()));
									superMaster.setBusinessType((Integer) (obj.getBusinessType()));
									superMaster.setCollectionDate((String) (obj.getCollectionDate()));
									superMaster.setCollectionTime((String) (obj.getCollectionTime()));

									superMaster.setCustomerType((Integer) (obj.getCustomerType()));
									superMaster.setCustomerId((Integer) (obj.getCustomerId()));

									superMaster.setPatientId((Integer) (master.getPatientId()));
									superMaster.setTreatmentId((Integer) (master.getTreatmentId()));
									superMaster.setRefdocid(obj.getRefdocid());
									superMaster.setRegRefDocId(master.getRegRefDocId());
									superMaster.setPackageId(obj.getPackageId());
								}

								if (count == 0) {

									String nablHeaderFlag = apiRepo
											.getAccreditatedFlagForProfile((Integer) row.get("profileid"));

									System.out.println("nablHeaderFlag****** " + nablHeaderFlag);

									Integer countVal = apiRepo.getCountVal(obj, runnerBoy, unitId);

									Integer profId = (Integer) row.get("profileid");
									String templateWiseValue = apiRepo.getTemplateWiseValue(profId);

									master.setProfileId((Integer) row.get("profileid"));
									master.setSampleTypeId((Integer) row.get("sampleid"));
									master.setContainerId((Integer) row.get("containerid"));

									if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
										master.setTeststatus((112));
										master.setPhleboteststatus("R");
									} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {
										master.setTeststatus((2));
									} else {
										master.setTeststatus((1));
									}

									master.setServiceId((Integer) (obj.getServiceId()));
									master.setSubServiceId((Integer) (obj.getSubServiceId()));
									master.setUnitId((Integer) (unitId));
									master.setBilDetId((Integer) (obj.getBilDetId()));
									master.setBarCode((String) (obj.getBarCode()));
									master.setSampleTypeId((Integer) (obj.getSampleTypeId()));
									master.setInOutHouse((Integer) (obj.getInOutHouse()));
									master.setBusinessType((Integer) (obj.getBusinessType()));
									master.setCollectionDate((String) (obj.getCollectionDate()));
									master.setCollectionTime((String) (obj.getCollectionTime()));

									master.setTemplateWise(templateWiseValue);

									master.setCustomerType((Integer) (obj.getCustomerType()));
									master.setCustomerId((Integer) (obj.getCustomerId()));

									master.setSampleCount((Integer) (countVal));
									master.setCreatedBy((Integer) (userId));
									master.setRefdocid(obj.getRefdocid());
									master.setRegRefDocId(master.getRegRefDocId());
									master.setPackageId(obj.getPackageId());

									master.setNablChk((String) row.get("nabl"));
									master.setFooterAddressFlag(reportFooterFlag);

									master.setNablHeaderFlag(nablHeaderFlag);
									master.setProjectId(projectId);
									master.setRegUnitId((Integer) (unitId));

									master.setMultilabFlag("A");
									master.setPrintCountPdf(master.getTreatmentId());

									masterList.add(master);
								}
							}

							slave.setProfileId((Integer) row.get("profileid"));
							slave.setSampleTypeId((Integer) row.get("sampleid"));
							slave.setTestid((Integer) row.get("testid"));
							slave.setProfileName((String) row.get("profilename"));
							slave.setPatientId(master.getPatientId());
							slave.setTreatmentId(master.getTreatmentId());
							slave.setUnitId((unitId));
							slave.setBarCode((obj.getBarCode()));
							slave.setInOutHouse((obj.getInOutHouse()));
							slave.setCollectionDate((obj.getCollectionDate()));
							slave.setCollectionTime((obj.getCollectionTime()));
							slave.setRegRefDocId(master.getRegRefDocId());
							slave.setPackageId(obj.getPackageId());

							slave.setNabl((String) row.get("nabl"));

							slaveList.add(slave);

							superCount++;
							count++;

						}
					} else {
						for (Map<String, Object> row : list) {
							PathologySampleWiseSlave slave = new PathologySampleWiseSlave();
							String sqlRef = "";
							if (superCount == 0) {
								Integer profile = (Integer) row.get("profileid");

								Integer rowCount = apiRepo.getRowCount(obj, runnerBoy, master, unitId);

								if (rowCount == null) {
									rowCount = 0;
								}

								if (rowCount > 0) {

									PathologySampleWiseSuperMaster superMaster1 = apiRepo.getSuperMasterData(rowCount);

									masterList.addAll(superMaster1.getPathologySampleWiseMaster());

									superMaster.setSampleWiseSuperMasterId(rowCount);
									superMaster.setProfileId((Integer) row.get("profileid"));
									superMaster.setSampleTypeId((Integer) row.get("sampleid"));
									superMaster.setContainerId((Integer) row.get("containerid"));

									if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
										superMaster.setTeststatus((Integer) (112));
										superMaster.setPhleboteststatus("R");
									} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {
										superMaster.setTeststatus((Integer) (2));
									} else {
										superMaster.setTeststatus((Integer) (1));
									}

									superMaster.setServiceId((Integer) (obj.getServiceId()));
									superMaster.setSubServiceId((Integer) (obj.getSubServiceId()));
									superMaster.setUnitId((Integer) (unitId));
									superMaster.setBilDetId((Integer) (obj.getBilDetId()));
									superMaster.setBarCode((String) (obj.getBarCode()));
									superMaster.setSampleTypeId((Integer) (obj.getSampleTypeId()));
									superMaster.setInOutHouse((Integer) (obj.getInOutHouse()));
									superMaster.setBusinessType((Integer) (obj.getBusinessType()));
									superMaster.setCollectionDate((String) (obj.getCollectionDate()));
									superMaster.setCollectionTime((String) (obj.getCollectionTime()));

									superMaster.setCustomerType((Integer) (obj.getCustomerType()));
									superMaster.setCustomerId((Integer) (obj.getCustomerId()));

									superMaster.setPatientId((Integer) (master.getPatientId()));
									superMaster.setTreatmentId((Integer) (master.getTreatmentId()));
									superMaster.setRefdocid(obj.getRefdocid());
									superMaster.setRegRefDocId(master.getRegRefDocId());
									superMaster.setPackageId(obj.getPackageId());
								} else {
									superMaster.setProfileId((Integer) row.get("profileid"));
									superMaster.setSampleTypeId((Integer) row.get("sampleid"));
									superMaster.setContainerId((Integer) row.get("containerid"));

									if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
										superMaster.setTeststatus((Integer) (112));
										superMaster.setPhleboteststatus("R");
									} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {
										superMaster.setTeststatus((Integer) (2));
									} else {
										superMaster.setTeststatus((Integer) (1));
									}

									superMaster.setServiceId((Integer) (obj.getServiceId()));
									superMaster.setSubServiceId((Integer) (obj.getSubServiceId()));
									superMaster.setUnitId((Integer) (unitId));
									superMaster.setBilDetId((Integer) (obj.getBilDetId()));
									superMaster.setBarCode((String) (obj.getBarCode()));
									superMaster.setSampleTypeId((Integer) (obj.getSampleTypeId()));
									superMaster.setInOutHouse((Integer) (obj.getInOutHouse()));
									superMaster.setBusinessType((Integer) (obj.getBusinessType()));
									superMaster.setCollectionDate((String) (obj.getCollectionDate()));
									superMaster.setCollectionTime((String) (obj.getCollectionTime()));

									superMaster.setCustomerType((Integer) (obj.getCustomerType()));
									superMaster.setCustomerId((Integer) (obj.getCustomerId()));

									superMaster.setPatientId((Integer) (master.getPatientId()));
									superMaster.setTreatmentId((Integer) (master.getTreatmentId()));
									superMaster.setRefdocid(obj.getRefdocid());
									superMaster.setRegRefDocId(master.getRegRefDocId());
									superMaster.setPackageId(obj.getPackageId());
								}

								if (count == 0) {

									String nablHeaderFlag = apiRepo
											.getAccreditatedFlagForProfile((Integer) row.get("profileid"));

									System.out.println("nablHeaderFlag****** " + nablHeaderFlag);

									Integer countVal = apiRepo.getCountVal(obj, runnerBoy, unitId);

									Integer profId = (Integer) row.get("profileid");

									String templateWiseValue = apiRepo.getTemplateWiseValue(profId);

									master.setProfileId((Integer) row.get("profileid"));
									master.setSampleTypeId((Integer) row.get("sampleid"));
									master.setContainerId((Integer) row.get("containerid"));

									if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
										master.setTeststatus((Integer) (112));
										master.setPhleboteststatus("R");
									} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {
										master.setTeststatus((Integer) (2));
									} else {
										master.setTeststatus((Integer) (1));
									}

									master.setServiceId((Integer) (obj.getServiceId()));
									master.setSubServiceId((Integer) (obj.getSubServiceId()));
									master.setUnitId((Integer) (unitId));
									master.setBilDetId((Integer) (obj.getBilDetId()));
									master.setBarCode((String) (obj.getBarCode()));
									master.setSampleTypeId((Integer) (obj.getSampleTypeId()));
									master.setInOutHouse((Integer) (obj.getInOutHouse()));
									master.setBusinessType((Integer) (obj.getBusinessType()));
									master.setCollectionDate((String) (obj.getCollectionDate()));
									master.setCollectionTime((String) (obj.getCollectionTime()));
									master.setTemplateWise(templateWiseValue);

									master.setCustomerType((Integer) (obj.getCustomerType()));
									master.setCustomerId((Integer) (obj.getCustomerId()));

									master.setSampleCount((Integer) (countVal));
									master.setCreatedBy((Integer) (userId));
									master.setRefdocid(obj.getRefdocid());
									master.setRegRefDocId(master.getRegRefDocId());
									master.setPackageId(obj.getPackageId());

									master.setNablChk((String) row.get("nablpro"));
									master.setFooterAddressFlag(reportFooterFlag);

									master.setNablHeaderFlag(nablHeaderFlag);
									master.setProjectId(projectId);
									master.setRegUnitId((Integer) (unitId));
									master.setMultilabFlag("A");
									master.setProfileCode((String) row.get("profilecode"));
									master.setPrintCountPdf(master.getTreatmentId());

									masterList.add(master);
								}
							}

							slave.setOrgan_id((Integer) row.get("organ_id"));
							slave.setProfileId((Integer) row.get("profileid"));
							slave.setSampleTypeId((Integer) row.get("sampleid"));
							slave.setTestid((Integer) row.get("testid"));
							slave.setProfileName((String) row.get("profilename"));
							slave.setPatientId(master.getPatientId());
							slave.setTreatmentId(master.getTreatmentId());
							slave.setUnitId((Integer) (unitId));
							slave.setBarCode((String) (obj.getBarCode()));
							slave.setInOutHouse((Integer) (obj.getInOutHouse()));
							slave.setCollectionDate((String) (obj.getCollectionDate()));
							slave.setCollectionTime((String) (obj.getCollectionTime()));
							slave.setRegRefDocId(master.getRegRefDocId());
							slave.setPackageId(obj.getPackageId());

							slave.setNabl((String) row.get("nabl"));

							slaveList.add(slave);

							superCount++;
							count++;

						}

					}

//					superMaster.setPathologySampleWiseMaster(masterList);
//					master.setPathologySampleWiseSlave(slaveList);

					for (PathologySampleWiseMaster masterobj : masterList) {

						masterobj.setPathologySampleWiseSuperMaster(superMaster);

						for (PathologySampleWiseSlave slave : slaveList) {
							slave.setPathologySampleWiseMaster(masterobj);
						}

						master.setPathologySampleWiseSlave(slaveList);
					}

					superMaster.setPathologySampleWiseMaster(masterList);

					PathologySampleWiseSuperMaster pathologySampleWiseSuperMaster = apiRepo
							.mergeSendtoLabData(superMaster);

				}
			}

			return serviceId;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Integer closeCampIdForDISHA(String campId) {
		
		Integer res = 0;
		try {
			apiRepo.closeCampIdForDISHA(campId);
		} catch(Exception e) {
			System.out.println("Cant able to close the camp*** "+e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

}
