package com.disha.hms.service;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.disha.hms.entity.BillMasterDto;
import com.disha.hms.entity.RegistrationDto;
import com.disha.hms.entity.TokenDto;
import com.disha.hms.entity.TreatmentDto;
import com.disha.hms.repo.RegPatientRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegPatientServiceImpl implements RegPatientService {
	
	@Autowired
	RegPatientRepo regPatientRepo;
	
	@Value("${doctorWiseToken}")
	private String doctorWise;

	java.util.Calendar currentDate = java.util.Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public Integer savePatientRegDetails(RegistrationDto registrationDto, String queryType, Integer appointmentId) {

		Integer userId = registrationDto.getCreatedBy();

		if (queryType.equalsIgnoreCase("insert")) {
  		registrationDto.setCreatedDateTime(new Date(new java.util.Date().getTime()));
			registrationDto.setDeleted("N");
		} else if (queryType.equalsIgnoreCase("update") || queryType.equalsIgnoreCase("markvisit")) {

			registrationDto.setUpdatedBy(userId);
			registrationDto.setUpdatedDateTime(new Date(new java.util.Date().getTime()));
			registrationDto.setDeleted("N");

		}

		int a = savePatient(registrationDto, queryType, appointmentId);

		return a;
	}

	@Override
	public Integer saveTreatmentDetails(TreatmentDto treatmentDto, String queryType) {

		Integer userId = treatmentDto.getCreatedBy();

		if (queryType.equalsIgnoreCase("insert") || queryType.equalsIgnoreCase("markvisit")) {
			treatmentDto.setCreatedDateTime(new Date(new java.util.Date().getTime()));
			treatmentDto.setDeleted("N");

		} else if (queryType.equalsIgnoreCase("update")) {
			treatmentDto.setUpdatedDateTime(new Date(new java.util.Date().getTime()));
			treatmentDto.setDeleted("N");

		}
		
		int a = saveTreatment(treatmentDto, queryType);

		return a;
	}
	
	public Integer savePatient(RegistrationDto registrationDto, String queryType, Integer appointmentId) {
		
		int a=0;
		int unitid=0;
		try {

			String initials = regPatientRepo.getHospitalInitials();
			
			StringBuffer mrNo = new StringBuffer(initials);
			StringBuffer bufferMrNo = null;

			SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
			String currentMonth = monthFormatter.format(currentDate.getTime());

			SimpleDateFormat yearFormatter = new SimpleDateFormat("yy");
			String currentYear = yearFormatter.format(currentDate.getTime());
			Integer nextYear = 0;
			String currentNextYear = "";
			Integer intPatientID = 0;

			Integer unid1 = regPatientRepo.getMaxPatientId();

			if (unid1 != null) {
				intPatientID = unid1;
			}
			
			if (Integer.parseInt(currentMonth) > 6) {
				nextYear = Integer.parseInt(currentYear) + 1;
				mrNo.append(currentYear);
				mrNo.append(nextYear.toString());
				currentNextYear = currentYear + nextYear.toString();
			} else {
				nextYear = Integer.parseInt(currentYear) - 1;
				mrNo.append(currentYear);
				mrNo.append(nextYear.toString());

				currentNextYear = nextYear.toString() + currentYear;
			}
			
			intPatientID = intPatientID + 1;
			int length = intPatientID.toString().length();
			bufferMrNo = new StringBuffer(initials + currentNextYear);
			for (int i = length; i < 10; i++) {
				bufferMrNo.append("0");
			}
			
			bufferMrNo.append(intPatientID.toString());

			Long count = regPatientRepo.getTotalPatientCountByUnitId(registrationDto.getUnitId());
			//Integer unid = regPatientRepo.getUnitIdbyPatientId(registrationDto.getPatientId());
			
			if (count != null) {
				unitid = ((Number) count).intValue();
			}

			if (queryType.equalsIgnoreCase("insert")) {
				unitid++;

				registrationDto.setUnitCount(unitid);
				registrationDto.setMrnno(bufferMrNo.toString());

				System.out.println("****" + registrationDto.getFormalinDate());
				System.out.println("#####" + registrationDto.getSpecArrivalDate());
				
				regPatientRepo.mergePatient(registrationDto);
				
				System.out.println("1111" + registrationDto.getFormalinDate());
				System.out.println("2222" + registrationDto.getSpecArrivalDate());

				a = regPatientRepo.maxCountOfColumn(RegistrationDto.class, "patientId");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			a=-1;
		}

		return a;
	}


	public Integer saveTreatment(TreatmentDto treatmentDto, String queryType) {
		Calendar cal = Calendar.getInstance();
		Calendar now = Calendar.getInstance();

		int cur_yr1 = 0;
		int next_yr = 0;
		String year = "";
		DateFormat date1 = new SimpleDateFormat("MM");
		String cur_month = date1.format(new java.util.Date());
		int cur_month1 = (Integer.parseInt(cur_month));
		if (cur_month1 < 4) {

			DateFormat date = new SimpleDateFormat("yy");
			String cur_yr = date.format(new java.util.Date());

			cur_yr1 = (Integer.parseInt(cur_yr));
			next_yr = (Integer.parseInt(cur_yr) - 1);
			year = next_yr + "-" + cur_yr1;

		} else {
			DateFormat date = new SimpleDateFormat("yy");
			String cur_yr = date.format(new java.util.Date());
			cur_yr1 = (Integer.parseInt(cur_yr));
			next_yr = (Integer.parseInt(cur_yr) + 1);
			year = cur_yr1 + "-" + next_yr;

		}

		long deptcnt = 01;
		int a = 0;
		int count = 0;
		String deptNm = "";
		String opdipdNo = "";
		int tokencount = 0;
		int loopCnt = 0;
		String tokenno = "";

		try {

			long constCharges = regPatientRepo.getDeptCount(treatmentDto.getDepartmentId());

			List<Integer> rows2 = regPatientRepo.getTreatmentCount(getSysDate());

			List<String> ltUnitMasters1 = regPatientRepo.getUnitNamebyUnitId(treatmentDto.getUnitId());

			if (ltUnitMasters1.isEmpty() || ltUnitMasters1 == null) {

			} else {
				opdipdNo = ltUnitMasters1.get(0);
				opdipdNo = opdipdNo.substring(0, 2);
			}
			if (queryType.equalsIgnoreCase("insert")) {

				if (rows2.contains(0) || rows2.contains(null)) {
					deptcnt = 01;
				} else {
					deptcnt = constCharges;
					deptcnt++;
				}

				if (treatmentDto.getDepartmentId() == 1) {
					deptNm = deptNm + "DIG" + "/" + year + "/" + deptcnt;
					opdipdNo = opdipdNo + "/" + deptNm;
				} else if (treatmentDto.getDepartmentId() == 2) {
					deptNm = deptNm + "IPD" + "/" + year + "/" + deptcnt;
					opdipdNo = opdipdNo + "/" + deptNm;

				} else if (treatmentDto.getDepartmentId() == 3) {
					deptNm = deptNm + "DIG" + "/" + year + "/" + deptcnt;
					opdipdNo = opdipdNo + "/" + deptNm;

				} else {
					deptNm = deptNm + "NAN" + "/" + year + "/" + deptcnt;
					opdipdNo = opdipdNo + "" + opdipdNo + "/" + deptNm;

				}

				treatmentDto.setTrcount(deptNm);
				treatmentDto.setOpdipdno(opdipdNo);

				regPatientRepo.mergeTratment(treatmentDto);

				a = regPatientRepo.maxCountOfColumn(TreatmentDto.class, "treatmentId");

				int toknvalue = 0;
				TokenDto tn = new TokenDto();
				String drid = treatmentDto.getDoctorIdList();
				if (treatmentDto.getDepartmentId() == 1) {
					for (String s : drid.split(",")) {

						tokencount = regPatientRepo.getTokenCount(treatmentDto, getSysDate(), loopCnt);
						tn.setToken(tokencount);
						tn.setDepartmentId(treatmentDto.getDepartmentId());
						tn.setPatientId(treatmentDto.getPatientId());
						tn.setTreatmentId(a);
						tn.setDoctorIdList(s);
						tn.setCreatedDateTime(treatmentDto.getCreatedDateTime());
						tn.setUnitId(treatmentDto.getUnitId());

						regPatientRepo.mergeToken(tn);

						tokencount = 0;
						loopCnt = 1;
					}
				}

				String dt = formatter.format(treatmentDto.getCreatedDateTime());
				regPatientRepo.savePatientBMIDeatils(treatmentDto, dt, a);
			}

		} catch (Exception e) {
			e.printStackTrace();
			a = -1;
		}
		return a;
	}

	public static Date getSysDate()
	{
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	@Override
	public Integer saveBillMaster(BillMasterDto billMasterDto, String queryType) {

		Integer userId = billMasterDto.getCreatedBy();

		if (queryType.equalsIgnoreCase("insert") || queryType.equalsIgnoreCase("markvisit")) {

			billMasterDto.setCreatedBy(userId);
			billMasterDto.setCreatedDateTime(new Date(new java.util.Date().getTime()));
			billMasterDto.setDeleted("N");

		} else if (queryType.equalsIgnoreCase("update")) {

			billMasterDto.setUpdatedBy(userId);
			billMasterDto.setUpdatedDateTime(new Date(new java.util.Date().getTime()));
			billMasterDto.setDeleted("N");

		}

		int a = saveBill(billMasterDto, queryType, userId);

		return a;
	}
	
	public int saveBill(BillMasterDto billMasterDto, String queryType, Integer userId)
	{
		int a = 0;
		try {

			if (queryType.equalsIgnoreCase("insert") || queryType.equalsIgnoreCase("markvisit")) {

				int deptId = billMasterDto.getDepartmentId();
				int count = regPatientRepo.maxCountOfBilling(BillMasterDto.class, "count", deptId);
				billMasterDto.setCount(count + 1);

				//billMasterDto.setBillId(0);
				regPatientRepo.mergeBillMaster(billMasterDto);
				a = regPatientRepo.maxCountOfColumn(BillMasterDto.class, "billId");

				if (deptId == 1)
					regPatientRepo.generateOpdCount(userId, billMasterDto.getTreatmentId(), 1);
				else if (deptId == 3)
					regPatientRepo.generateOpdCount(userId, billMasterDto.getTreatmentId(), 3);
			}

		} catch (Exception e) {
			e.printStackTrace();
			a = -1;
		}

		return a;
	}
	
}
