package com.disha.hms.entity;

import java.util.Date;
import java.util.List;

import com.disha.hms.dto.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ehat_patient")
public class RegistrationDto {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Integer patientId;
	
	@Column(name = "prefix")
	private String prefix;

	@Column(name = "f_name")
	private String fName;
	
	@Column(name = "m_name")
	private String mName;
	
	@Column(name = "l_name")
	private String lName;

	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dob",columnDefinition="varchar(100) default '' ")
	private String dob="";
	
	@Column(name = "age",columnDefinition="int default 0")
	private int age;
	
	@Column(name = "age_months",columnDefinition="int default 0")
	private int ageMonths;
	
	@Column(name = "age_days",columnDefinition="int default 0")
	private int ageDays;
	
	@Column(name = "taluka_id",columnDefinition="int default 0")
	private int talukaId;
	
	@Column(name = "town_id",columnDefinition="int default 0")
	private int townId;
	
	@Column(name = "district_id",columnDefinition="int default 0")
	private int districtId;
	
	@Column(name = "state_id",columnDefinition="int default 0")
	private int stateId;
	
	@Column(name = "country_id",columnDefinition="int default 1")
	private int countryId;
	
	@Column(name = "area_code",columnDefinition="int default 0")
	private int areaCode;
	
	@Column(name = "unit_id",columnDefinition="int default 1")
	private int unitId;
	
	@Column(name = "deleted",columnDefinition="varchar(2) default 'N'")
	private String deleted;
	
	@Column(name = "created_by",updatable=false)
	private Integer createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time",updatable=false)
	private Date createdDateTime;

	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date_time")
	private Date updatedDateTime;

	@Column(name = "deleted_by")
	private Integer deletedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date_time")
	private Date deletedDateTime;
	
	@Column(name = "mrnno")
	private String mrnno;
 
	@Column(name = "unitcount")
	private Integer unitCount;
	
	@Column(name = "transSMS",columnDefinition="varchar(2) default 'N'")
	private String transSMS="N";
	
	@Column(name = "transEmail",columnDefinition="varchar(2) default 'N'")
	private String transEmail="N" ;
	
	@Column(name = "pramoEmail",columnDefinition="varchar(2) default 'N'")
	private String pramoEmail="N" ;
	
	@Column(name = "pramoSMS",columnDefinition="varchar(2) default 'N'")
	private String pramoSMS="N" ;
	
	@Column(name = "external",columnDefinition="varchar(2) default 'N'")
	private String external="N" ;
	
	@Column(name = "emergency",columnDefinition="varchar(2) default 'N'")
	private String emergency="N" ;
	
	@Column(name = "adharcardNo",columnDefinition="varchar(100) default ''")
	private String adharcardNo="";
	
	@Column(name = "address",columnDefinition="varchar(100) default ''")
	private String address="";
	
	@Column(name = "image_name")
	private String imageName="patientPhoto.jpg";
	
	@Column(name = "aadhar_image_name",columnDefinition="varchar(255) default 'aadhar.jpg'")
	private String aadharImageName="aadhar.jpg";
	
	@Column(name = "aadhar_back_image_name",columnDefinition="varchar(255) default 'aadhar.jpg'")
	private String aadharBackImageName="aadhar.jpg";
	
	@Column(name = "block_flag",columnDefinition="varchar(2) default 'N'")
	private String blockFlag ="N";
	
	@Column(name = "block_narration_1",columnDefinition="varchar(5000) default '-'")
	private String blockNarration1 ="-";
	
	@Column(name = "block_narration_2",columnDefinition="varchar(5000) default '-'")
	private String blockNarration2 ="-";
	
	@Column(name = "block_narration_3",columnDefinition="varchar(5000) default '-'")
	private String blockNarration3 ="-";
	
	@Column(name = "block_user_name_1",columnDefinition="varchar(500) default '-'")
	private String blockUserName1 ="-";
	
	@Column(name = "block_user_name_2",columnDefinition="varchar(500) default '-'")
	private String blockUserName2 ="-";
	
	@Column(name = "block_user_name_3",columnDefinition="varchar(500) default '-'")
	private String blockUserName3 ="-";
	
	
	@Column(name = "block_user_id_1",columnDefinition="int default 0")
	private Integer blockUserId1=0;
	
	@Column(name = "block_user_id_2",columnDefinition="int default 0")
	private Integer blockUserId2=0;
	
	@Column(name = "block_user_id_3",columnDefinition="int default 0")
	private Integer blockUserId3=0;
	
	
	@Column(name = "passport",columnDefinition="varchar(55) default '-'")
	private String passport="";
	
	@Column(name = "visa",columnDefinition="varchar(55) default '-'")
	private String visa="";
	
	@Column(name = "relation_id",columnDefinition="int default 0")
	private Integer relationId;
	
	@Column(name = "relative_name",columnDefinition="varchar(55) default '-'")
	private String relativeName="";
	
	@Column(name = "relative_nationality_id",columnDefinition="int default 0")
	private Integer relativeNationalityId;
	
	//Added on 07-May-2018 For Permanant Address.
	
	@Column(name = "per_address",columnDefinition="varchar(255) default '-'")
	private String perAddress="";
	
	@Column(name = "per_taluka_id",columnDefinition="int default 0")
	private Integer pertalukaId;
	
	@Column(name = "per_town_id",columnDefinition="int default 0")
	private Integer pertownId;
	
	@Column(name = "per_district_id",columnDefinition="int default 0")
	private Integer perdistrictId;
	
	@Column(name = "per_state_id",columnDefinition="int default 0")
	private Integer perstateId;
	
	@Column(name = "per_country_id",columnDefinition="int default 1")
	private Integer percountryId;
	
	@Column(name = "per_area_code",columnDefinition="int default 0")
	private Integer perareaCode;
	
	//additional information columns added
	
	@Column(name = "old_patient_id",columnDefinition="varchar(20) default '0'")
	private String oldPatientId="0";
	
	@Column(name = "email_id",columnDefinition="varchar(255) default '-'")
	private String emailId;
	
	@Column(name = "marital_status_id",columnDefinition="int default 0")
	private Integer maritalStatusId;
	
	@Column(name = "nationality_id",columnDefinition="int default 0")
	private Integer nationalityId;
	
	@Column(name = "religion_id",columnDefinition="int default 0")
	private Integer religionId;
	
	@Column(name = "language_id",columnDefinition="int default 0")
	private Integer languageId;
	
	@Column(name = "blood_group_id",columnDefinition="int default 0")
	private int bloodGroupId;
	
	@Column(name = "identity_proof_id",columnDefinition="int default 0")
	private int identityProofId;
	
	@Column(name = "identification_number",columnDefinition="varchar(255) default '-'")
	private String identificationNumber="-";
	
	@Column(name = "annual_income_id",columnDefinition="int default 0")
	private int annualIncomeId;
	
	@Column(name = "occupation",columnDefinition="varchar(255) default '-'")
	private String occupation="-";
	
	@Column(name = "education",columnDefinition="int(11) default 0")
	private Integer education=0;
	
	@Column(name = "employ_id",columnDefinition="varchar(255) default '-'")
	private String employId="-";
	
	// aniket_12_06_019
	@Column(name = "employee_name",columnDefinition="varchar(200) default '-'")
	private String employeeName="-";

	@Column(name = "txt_pincode",columnDefinition="varchar(200) default '-'")
	private String txtPincode="";
	
	@Column(name = "flight_no",columnDefinition="varchar(200) default '-'")
	private String flightNumber="";
	
	@Column(name = "connecting_flight", columnDefinition="varchar(2) default 'N'")
	private String connectingFlight = "N";

	@Column(name = "opt_destination_city",columnDefinition="varchar(200) default '-'")
	private String optDestinationCity="";
	
	@Column(name = "flight_departure_date", columnDefinition="varchar(45)")
	private String flightDepartureDate="";
	
	@Column(name = "flight_departure_time", columnDefinition="varchar(45)")
	private String flightDepartureTime="";

	@Column(name = "destination_city",columnDefinition="varchar(200) default '-'")
	private String destinationCity="";
	
	@Column(name = "city_of_origin",columnDefinition="varchar(200) default '-'")
	private String cityOfOrigin="";
	
	
	@Column(name = "lookup_det_id_ttl",columnDefinition="int default 0")
	private int lookupDetIdTtl;
	
	// =====================================================================
	// added new column on 25 May 2022 by ROHIT for Ticket ID 548
	
	@Column(name = "country",columnDefinition="int(11) default 0")
	private Integer country = 0;

	@Column(name = "country_code",columnDefinition="int(11) default 0")
	private Integer countryCode = 0;
	
	//akash
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "spec_arrival_date")
	private String specArrivalDate;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "spec_arrival_time ")
	private String specArrivalTime;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "formalin_fixation_date")
	private String formalinDate;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "formalin_fixation_time ")
	private String formalinFixationTime;
	
	@Column(name = "provisional_diagnosis")
	String  provisionalDiagnosis;
	
	@Column(name = "previous_therapy")
	private String  previousTherapy;
	
	@Column(name = "previous_biopsy_cytology")
	private String  previousBiopsyCytology;
	
	@Column(name = "intra_operative_findings")
	private String  intraOperativeFindings;
	
	@Column(name = "seropositive_status", columnDefinition="varchar(2) default 'N'")
	private Character seropositiveStatus = 'N';
	
	@Column(name = "histopath_findings")
	private String  histopathFindings;
	
	@Column(name = "anomalies")
	private String  anomalies;
	
	@Column(name = "additional_remarks")
	private String  additionalRemarks;
	
	@Column(name = "histo_test", columnDefinition="varchar(2) default 'N'")
	private Character histoTest = 'N';
	
	@Column(name = "more_info")
	private String  moreInfo;
	
	@Column(name = "clinical_details")
	private String  clinicalDetails;
	
	
	// =====================================================================
	
	//aniket_12_06_019
	/*@Column(name = "fp_image_base_code")
	private byte[] fpimageBaseCode;*/
	
	
	

	//L & T number of children
	@Column(name = "no_of_children",columnDefinition="int default 0")
	private Integer noOfChildren=0;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "spec_removal_date")
	private String specRemovalDate;
	
	@Column(name = "spec_removal_time")
	private String specRemovalTime;
		
	@Column(name = "gene_provisional_diagnosis")
	private String  geneProvisionalDiagnosis;
		
	@Column(name = "gene_previous_therapy")
	private String  genePreviousTherapy;
		
	@Column(name = "gene_anomalies")
	private String  geneAnomalies;
		
	@Column(name = "gene_additional_remarks")
	private String  geneAdditionalRemarks;
		
	@Column(name = "gene_clinical_details")
	private String  geneClinicalDetails;	
	
	@Column(name = "hasana_id")
	private String hasanaID="";
	
	@Column(name = "nhs_no")
	private String nhsNo="";
	
	@Column(name = "lookup_det_id_ethnicity")
	private Integer lookupDetIdEthnicity;
	
	@Column(name = "ref_doctor_clinic")
	private String refDoctorClnic;
	
	@Column(name = "vip_name_id")
	private Integer vipNameId;
	
	@Column(name = "data_sharing_consent_id")
	private Integer dataSharingConsentId;
	
	@Column(name = "patient_type")
	private String patientType;
	
	@Column(name = "lookup_det_id_patient_type_m")
	private Integer lookupDetIdPatientTypeM;
	
	@Column(name = "lookup_det_id_sample_type")
	private Integer lookupDetIdSampleType;
	
	@Column(name = "lookup_det_id_category_type")
	private Integer lookupDetIdCategoryType;
	
	@Column(name = "opd_ipdno_m")
	private String opdIpdNoM;
	
	@Column(name = "birth_time")
	private String birthTime;
	
	@Column(name = "birth_weight")
	private String birthWeight;
	
	@Column(name = "gestn_week_m")
	private Integer gestnWeekM;
	
	@Column(name = "anc_type")
	private Integer ancType;
	
	@Column(name = "abha_no")
	private String abhaNo;
	
	@Transient
	private String countryName ;
	//@Temporal(TemporalType.TIMESTAMP)
	public String getSpecArrivalDate() {
		return specArrivalDate;
	}

	public void setSpecArrivalDate(String specArrivalDate) {
		this.specArrivalDate = specArrivalDate;
	}

	public String getSpecArrivalTime() {
		return specArrivalTime;
	}

	public void setSpecArrivalTime(String specArrivalTime) {
		this.specArrivalTime = specArrivalTime;
	}

	
	/*
	 * public String getFormalinFixationDate() { return formalinFixationDate; }
	 * 
	 * public void setFormalinFixationDate(String formalinFixationDate) {
	 * this.formalinFixationDate = formalinFixationDate; }
	 */

	public String getFormalinDate() {
		return formalinDate;
	}

	public void setFormalinDate(String formalinDate) {
		this.formalinDate = formalinDate;
	}

	public String getFormalinFixationTime() {
		return formalinFixationTime;
	}

	public void setFormalinFixationTime(String formalinFixationTime) {
		this.formalinFixationTime = formalinFixationTime;
	}

	public String getProvisionalDiagnosis() {
		return provisionalDiagnosis;
	}

	public void setProvisionalDiagnosis(String provisionalDiagnosis) {
		this.provisionalDiagnosis = provisionalDiagnosis;
	}

	public String getPreviousTherapy() {
		return previousTherapy;
	}

	public void setPreviousTherapy(String previousTherapy) {
		this.previousTherapy = previousTherapy;
	}

	public String getPreviousBiopsyCytology() {
		return previousBiopsyCytology;
	}

	public void setPreviousBiopsyCytology(String previousBiopsyCytology) {
		this.previousBiopsyCytology = previousBiopsyCytology;
	}

	public String getIntraOperativeFindings() {
		return intraOperativeFindings;
	}

	public void setIntraOperativeFindings(String intraOperativeFindings) {
		this.intraOperativeFindings = intraOperativeFindings;
	}

	public Character getSeropositiveStatus() {
		return seropositiveStatus;
	}

	public void setSeropositiveStatus(Character seropositiveStatus) {
		this.seropositiveStatus = seropositiveStatus;
	}

	public String getHistopathFindings() {
		return histopathFindings;
	}

	public void setHistopathFindings(String histopathFindings) {
		this.histopathFindings = histopathFindings;
	}

	public String getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(String anomalies) {
		this.anomalies = anomalies;
	}

	public String getAdditionalRemarks() {
		return additionalRemarks;
	}

	public void setAdditionalRemarks(String additionalRemarks) {
		this.additionalRemarks = additionalRemarks;
	}

	public Character getHistoTest() {
		return histoTest;
	}

	public void setHistoTest(Character histoTest) {
		this.histoTest = histoTest;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getClinicalDetails() {
		return clinicalDetails;
	}

	public void setClinicalDetails(String clinicalDetails) {
		this.clinicalDetails = clinicalDetails;
	}



	@Transient
	private String patientName;
	
	@Transient
	private String tflag;
	
	@Transient
	private List<RegistrationDto> listReg;
	
	@Transient
	private List<RegistrationDto> patientList;  

	@Transient
	private List<Users> userList;  
	
	@Transient
	private String nationality;
	
	public String getTflag() {
		return tflag;
	}

	public void setTflag(String tflag) {
		this.tflag = tflag;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	public String getTransSMS() {
		return transSMS;
	}

	public void setTransSMS(String transSMS) {
		this.transSMS = transSMS;
	}

	public String getTransEmail() {
		return transEmail;
	}

	public void setTransEmail(String transEmail) {
		this.transEmail = transEmail;
	}

	public String getPramoEmail() {
		return pramoEmail;
	}

	public void setPramoEmail(String pramoEmail) {
		this.pramoEmail = pramoEmail;
	}

	public String getPramoSMS() {
		return pramoSMS;
	}

	public void setPramoSMS(String pramoSMS) {
		this.pramoSMS = pramoSMS;
	}

	public String getExternal() {
		return external;
	}

	public void setExternal(String external) {
		this.external = external;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getAdharcardNo() {
		return adharcardNo;
	}

	public void setAdharcardNo(String adharcardNo) {
		this.adharcardNo = adharcardNo;
	}

	public Integer getUnitCount() {
		return unitCount;
	}

	public void setUnitCount(Integer unitCount) {
		this.unitCount = unitCount;
	}

	public String getMrnno() {
		return mrnno;
	}

	public void setMrnno(String mrnno) {
		this.mrnno = mrnno;
	}

	public List<RegistrationDto> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<RegistrationDto> patientList) {
		this.patientList = patientList;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTownId() {
		return townId;
	}

	public void setTownId(int townId) {
		this.townId = townId;
	}

	public int getTalukaId() {
		return talukaId;
	}

	public void setTalukaId(int talukaId) {
		this.talukaId = talukaId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedDateTime() {
		return deletedDateTime;
	}

	public void setDeletedDateTime(Date deletedDateTime) {
		this.deletedDateTime = deletedDateTime;
	}

	public List<RegistrationDto> getListReg() {
		return listReg;
	}

	public void setListReg(List<RegistrationDto> listReg) {
		this.listReg = listReg;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(int ageMonths) {
		this.ageMonths = ageMonths;
	}

	public int getAgeDays() {
		return ageDays;
	}

	public void setAgeDays(int ageDays) {
		this.ageDays = ageDays;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}	

	public String getAadharImageName() {
		return aadharImageName;
	}

	public void setAadharImageName(String aadharImageName) {
		this.aadharImageName = aadharImageName;
	}

	public String getAadharBackImageName() {
		return aadharBackImageName;
	}

	public void setAadharBackImageName(String aadharBackImageName) {
		this.aadharBackImageName = aadharBackImageName;
	}

	public String getBlockFlag() {
		return blockFlag;
	}

	public void setBlockFlag(String blockFlag) {
		this.blockFlag = blockFlag;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getVisa() {
		return visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	public int getPertalukaId() {
		return pertalukaId;
	}

	public void setPertalukaId(int pertalukaId) {
		this.pertalukaId = pertalukaId;
	}

	public int getPertownId() {
		return pertownId;
	}

	public void setPertownId(int pertownId) {
		this.pertownId = pertownId;
	}

	public int getPerdistrictId() {
		return perdistrictId;
	}

	public void setPerdistrictId(int perdistrictId) {
		this.perdistrictId = perdistrictId;
	}

	public int getPerstateId() {
		return perstateId;
	}

	public void setPerstateId(int perstateId) {
		this.perstateId = perstateId;
	}

	public int getPercountryId() {
		return percountryId;
	}

	public void setPercountryId(int percountryId) {
		this.percountryId = percountryId;
	}

	public int getPerareaCode() {
		return perareaCode;
	}

	public void setPerareaCode(int perareaCode) {
		this.perareaCode = perareaCode;
	}

	public String getPerAddress() {
		return perAddress;
	}

	public void setPerAddress(String perAddress) {
		this.perAddress = perAddress;
	}

	public String getOldPatientId() {
		return oldPatientId;
	}

	public void setOldPatientId(String oldPatientId) {
		this.oldPatientId = oldPatientId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(int maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	public int getReligionId() {
		return religionId;
	}

	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public int getIdentityProofId() {
		return identityProofId;
	}

	public void setIdentityProofId(int identityProofId) {
		this.identityProofId = identityProofId;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public int getAnnualIncomeId() {
		return annualIncomeId;
	}

	public void setAnnualIncomeId(int annualIncomeId) {
		this.annualIncomeId = annualIncomeId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getBlockNarration1() {
		return blockNarration1;
	}

	public void setBlockNarration1(String blockNarration1) {
		this.blockNarration1 = blockNarration1;
	}

	public String getBlockNarration2() {
		return blockNarration2;
	}

	public void setBlockNarration2(String blockNarration2) {
		this.blockNarration2 = blockNarration2;
	}

	public String getBlockNarration3() {
		return blockNarration3;
	}

	public void setBlockNarration3(String blockNarration3) {
		this.blockNarration3 = blockNarration3;
	}

	public int getBlockUserId1() {
		return blockUserId1;
	}

	public void setBlockUserId1(int blockUserId1) {
		this.blockUserId1 = blockUserId1;
	}

	public int getBlockUserId2() {
		return blockUserId2;
	}

	public void setBlockUserId2(int blockUserId2) {
		this.blockUserId2 = blockUserId2;
	}

	public int getBlockUserId3() {
		return blockUserId3;
	}

	public void setBlockUserId3(int blockUserId3) {
		this.blockUserId3 = blockUserId3;
	}

	public String getBlockUserName1() {
		return blockUserName1;
	}

	public void setBlockUserName1(String blockUserName1) {
		this.blockUserName1 = blockUserName1;
	}

	public String getBlockUserName2() {
		return blockUserName2;
	}

	public void setBlockUserName2(String blockUserName2) {
		this.blockUserName2 = blockUserName2;
	}

	public String getBlockUserName3() {
		return blockUserName3;
	}

	public void setBlockUserName3(String blockUserName3) {
		this.blockUserName3 = blockUserName3;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getEmployId() {
		return employId;
	}

	public void setEmployId(String employId) {
		this.employId = employId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTxtPincode() {
		return txtPincode;
	}

	public void setTxtPincode(String txtPincode) {
		this.txtPincode = txtPincode;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getConnectingFlight() {
		return connectingFlight;
	}

	public void setConnectingFlight(String connectingFlight) {
		this.connectingFlight = connectingFlight;
	}

	public String getOptDestinationCity() {
		return optDestinationCity;
	}

	public void setOptDestinationCity(String optDestinationCity) {
		this.optDestinationCity = optDestinationCity;
	}

	public String getFlightDepartureDate() {
		return flightDepartureDate;
	}

	public void setFlightDepartureDate(String flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}

	public String getFlightDepartureTime() {
		return flightDepartureTime;
	}

	public void setFlightDepartureTime(String flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getCityOfOrigin() {
		return cityOfOrigin;
	}

	public void setCityOfOrigin(String cityOfOrigin) {
		this.cityOfOrigin = cityOfOrigin;
	}

	public int getRelativeNationalityId() {
		return relativeNationalityId;
	}

	public void setRelativeNationalityId(int relativeNationalityId) {
		this.relativeNationalityId = relativeNationalityId;
	}

	/*public byte[] getFpimageBaseCode() {
		return fpimageBaseCode;
	}

	public void setFpimageBaseCode(byte[] fpimageBaseCode) {
		this.fpimageBaseCode = fpimageBaseCode;
	}*/
	public int getLookupDetIdTtl() {
		return lookupDetIdTtl;
	}

	public void setLookupDetIdTtl(int lookupDetIdTtl) {
		this.lookupDetIdTtl = lookupDetIdTtl;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSpecRemovalDate() {
		return specRemovalDate;
	}

	public void setSpecRemovalDate(String specRemovalDate) {
		this.specRemovalDate = specRemovalDate;
	}

	public String getSpecRemovalTime() {
		return specRemovalTime;
	}

	public void setSpecRemovalTime(String specRemovalTime) {
		this.specRemovalTime = specRemovalTime;
	}

	public String getGeneProvisionalDiagnosis() {
		return geneProvisionalDiagnosis;
	}

	public void setGeneProvisionalDiagnosis(String geneProvisionalDiagnosis) {
		this.geneProvisionalDiagnosis = geneProvisionalDiagnosis;
	}

	public String getGenePreviousTherapy() {
		return genePreviousTherapy;
	}

	public void setGenePreviousTherapy(String genePreviousTherapy) {
		this.genePreviousTherapy = genePreviousTherapy;
	}

	public String getGeneAnomalies() {
		return geneAnomalies;
	}

	public void setGeneAnomalies(String geneAnomalies) {
		this.geneAnomalies = geneAnomalies;
	}

	public String getGeneAdditionalRemarks() {
		return geneAdditionalRemarks;
	}

	public void setGeneAdditionalRemarks(String geneAdditionalRemarks) {
		this.geneAdditionalRemarks = geneAdditionalRemarks;
	}

	public String getGeneClinicalDetails() {
		return geneClinicalDetails;
	}

	public void setGeneClinicalDetails(String geneClinicalDetails) {
		this.geneClinicalDetails = geneClinicalDetails;
	}

	public String getHasanaID() {
		return hasanaID;
	}

	public void setHasanaID(String hasanaID) {
		this.hasanaID = hasanaID;
	}

	public String getNhsNo() {
		return nhsNo;
	}

	public void setNhsNo(String nhsNo) {
		this.nhsNo = nhsNo;
	}

	public Integer getLookupDetIdEthnicity() {
		return lookupDetIdEthnicity;
	}

	public void setLookupDetIdEthnicity(Integer lookupDetIdEthnicity) {
		this.lookupDetIdEthnicity = lookupDetIdEthnicity;
	}

	public String getRefDoctorClnic() {
		return refDoctorClnic;
	}

	public void setRefDoctorClnic(String refDoctorClnic) {
		this.refDoctorClnic = refDoctorClnic;
	}

	public int getVipNameId() {
		return vipNameId;
	}

	public void setVipNameId(int vipNameId) {
		this.vipNameId = vipNameId;
	}

	public int getDataSharingConsentId() {
		return dataSharingConsentId;
	}

	public void setDataSharingConsentId(int dataSharingConsentId) {
		this.dataSharingConsentId = dataSharingConsentId;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public Integer getLookupDetIdPatientTypeM() {
		return lookupDetIdPatientTypeM;
	}

	public void setLookupDetIdPatientTypeM(Integer lookupDetIdPatientTypeM) {
		this.lookupDetIdPatientTypeM = lookupDetIdPatientTypeM;
	}

	public Integer getLookupDetIdSampleType() {
		return lookupDetIdSampleType;
	}

	public void setLookupDetIdSampleType(Integer lookupDetIdSampleType) {
		this.lookupDetIdSampleType = lookupDetIdSampleType;
	}

	public Integer getLookupDetIdCategoryType() {
		return lookupDetIdCategoryType;
	}

	public void setLookupDetIdCategoryType(Integer lookupDetIdCategoryType) {
		this.lookupDetIdCategoryType = lookupDetIdCategoryType;
	}

	public String getOpdIpdNoM() {
		return opdIpdNoM;
	}

	public void setOpdIpdNoM(String opdIpdNoM) {
		this.opdIpdNoM = opdIpdNoM;
	}

	public String getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}

	public String getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(String birthWeight) {
		this.birthWeight = birthWeight;
	}

	public Integer getGestnWeekM() {
		return gestnWeekM;
	}

	public void setGestnWeekM(Integer gestnWeekM) {
		this.gestnWeekM = gestnWeekM;
	}

	public Integer getAncType() {
		return ancType;
	}

	public void setAncType(Integer ancType) {
		this.ancType = ancType;
	}

	public String getAbhaNo() {
		return abhaNo;
	}

	public void setAbhaNo(String abhaNo) {
		this.abhaNo = abhaNo;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
