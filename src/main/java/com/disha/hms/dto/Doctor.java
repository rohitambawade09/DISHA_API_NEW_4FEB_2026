package com.disha.hms.dto;

import java.util.List;

import com.disha.hms.entity.UserCustomersDto;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/*@XmlRootElement*/
public class Doctor {

	private String doc_name;
	private int Doctor_ID;
	private String address;
	private String mobileNo;
	private String email_Id;
	private String education;
	private String specialisation;
	private String specialisationName;
	private String doc_Type;
	private int User_ID;
	private String userFor;
	private int collectedAt;
	private int fees;
	private String dob;
	private String apartment;
	private String city;
	private String state;
	private String zip;
	private String dojoin;
	private String schoolNm;
	private String schoolAdd;
	private String schoolForm;
	private String schooTo;
	private String schoolPercent;
	private String colNm;
	private String colAdd;
	private String colForm;
	private String colTo;
	private String colPercent;
	private String colDegree;
	private String pgNm;
	private String pgAdd;
	private String pgForm;
	private String pgTo;
	private String pgPercent;
	private String pgDegree;
	private String cmpnyNm;
	private String cmpnyAdd;
	private String cmpnyPhone;
	private String cmpnyBoss;
	private String jobTitle;
	private String jobResp;
	private String jobForm;
	private String jobTo;
	private Float salary;
	private Double followfees;
	private String status;
	private String hosType;
	private Float secu_monthly_deduct;
	private Float no_of_months_for_secu;
	private String machine_emp_code;
	private int aplicable_leaves;
	private int balance_leaves;
	private String charge_type;
	private String security_current_month;
	private Float total_submit_security;
	private String department;
	private String speciality;
	private String PAN;
	private String CTC;
	private String PLVP;
	private String doctor_percent;
	private String Docsign;
	private int tomID;

	private String qualification;
	private String designation;
	private String regNo;
	private String overrideChargesFlag;
	private String sendSMSflag;
	//Add by Amol Saware
	private String softwareUsed;
	private String hrmsEmpFlag;
	private int lookupDetIdTtl;
	private int mappedProjectId;
	
	
	
	
	public int getMappedProjectId() {
		return mappedProjectId;
	}
	public void setMappedProjectId(int mappedProjectId) {
		this.mappedProjectId = mappedProjectId;
	}
	public int getLookupDetIdTtl() {
		return lookupDetIdTtl;
	}
	public void setLookupDetIdTtl(int lookupDetIdTtl) {
		this.lookupDetIdTtl = lookupDetIdTtl;
	}
	public String getHrmsEmpFlag() {
		return hrmsEmpFlag;
	}
	public void setHrmsEmpFlag(String hrmsEmpFlag) {
		this.hrmsEmpFlag = hrmsEmpFlag;
	}

	private List<Doctor> listDoctorDetails;
	private String departmentName;
	private String motivatorAuthorisation;
	private List<Visiting_doc_Procedure> liVDPro;
	
	private String constCharges;
	private String investPer;
	

	private String sunMorningStart;
	private String monMorningStart;
	private String tueMorningStart;
	private String wedMorningStart;
	private String thiMorningStart;
	private String friMorningStart;
	private String satMorningStart;
	
	private String sunMorningEnd;
	private String monMorningEnd;
	private String tueMorningEnd;
	private String wedMorningEnd;
	private String thiMorningEnd;
	private String friMorningEnd;
	private String satMorningEnd;

	private String sunAfternoonStart;
	private String monAfternoonStart;
	private String tueAfternoonStart;
	private String wedAfternoonStart;
	private String thiAfternoonStart;
	private String friAfternoonStart;
	private String satAfternoonStart;
	
	private String sunAfternoonEnd;
	private String monAfternoonEnd;
	private String tueAfternoonEnd;
	private String wedAfternoonEnd;
	private String thiAfternoonEnd;
	private String friAfternoonEnd;
	private String satAfternoonEnd;
	
	private String sunEverningStart;
	private String monEverningStart;
	private String tueEverningStart;
	private String wedEverningStart;
	private String thiEverningStart;
	private String friEverningStart;
	private String satEverningStart;
	
	private String sunEverningEnd;
	private String monEverningEnd;
	private String tueEverningEnd;
	private String wedEverningEnd;
	private String thiEverningEnd;
	private String friEverningEnd;
	private String satEverningEnd;
	private String empIdhr;
	//@Name: irfan khan @date: 11-11-2016 @reason: clinic% and test shared flag
	private double clinicPercent;
	private int testSharedFlag;
	
	private String docIni;
	private double folloupFees;
	private double folloupWeekend;
	
	//Aniket, 21/10/019, for bank details
	private String employeeServiceCode;
	private String bankName;
	private String bankBranchName;
	private String bankAccountNo;
	private String ifscCode;
	private String micrCode;
	private String drSign;
	private String drSpecialization;
	private String usePrepaidCreditAmount;
	private String updateCustomerDetails;
	private String updateRateAmount ;
	private String editMakePayment ;
	private String parentUtilizationAmountAcces ;
	private String b2bAndB2cQueueAcces ;

	@JsonGetter("drSign")
	public String getDrSign() {
		return drSign;
	}
	@JsonSetter("drSign")
	public void setDrSign(String drSign) {
		this.drSign = drSign;
	}
	@JsonGetter("drSpecialization")
	public String getDrSpecialization() {
		return drSpecialization;
	}
	@JsonSetter("drSpecialization")
	public void setDrSpecialization(String drSpecialization) {
		this.drSpecialization = drSpecialization;
	}
	@JsonGetter("docIni")
	public String getDocIni() {
		return docIni;
	}
	@JsonSetter("docIni")
	public void setDocIni(String docIni) {
		this.docIni = docIni;
	}

	//Pathology percentage added by irfan khan @date 3-nov-2016
	private String pathologyPer;
	
	//physio,otherservices,casualty percentage added by irfan khan @date 2-nov-2016
	private String physioPer;
	private String otherServicesPer;
	private String casualtyPer;
	
	private String user_Name;
	private String password;

   //@Name: paras suryawanshi @date: 18-5-2017 @reason: doctor type master
    private int	dcTypeMasterID;
	private String  mulSelunit;
	
	//added by sagar  @date7/july/2017
	private String  mulDeptid;
	private String  mulServiceid;
	
	//added by Vinod  @date 20/11/2017
	private String  adminServiceid;
	
	// added by kishor @date 15/3/2018
	private String  doctorTypeIdList;
	
	private String customerType;//added by dayanand(18-3-2020)
	private String customerId;//added by dayanand(18-3-2020)
	private String inhouseLabId;//added by dayanand(18-3-2020)
	
	private List<UserCustomersDto> userCustomersList;
	
	public String getConstCharges() {
		return constCharges;
	}
	public void setConstCharges(String constCharges) {
		this.constCharges = constCharges;
	}
	public String getInvestPer() {
		return investPer;
	}
	public void setInvestPer(String investPer) {
		this.investPer = investPer;
	}
	public String getAdminServiceid() {
		return adminServiceid;
	}
	public void setAdminServiceid(String adminServiceid) {
		this.adminServiceid = adminServiceid;
	}
	@JsonGetter("mulDeptid")
	public String getMulDeptid() {
		return mulDeptid;
	}
	@JsonSetter("mulDeptid")
	public void setMulDeptid(String mulDeptid) {
		this.mulDeptid = mulDeptid;
	}
	@JsonGetter("mulServiceid")
	public String getMulServiceid() {
		return mulServiceid;
	}
	@JsonSetter("mulServiceid")
	public void setMulServiceid(String mulServiceid) {
		this.mulServiceid = mulServiceid;
	}

	@JsonGetter("mulSelunit")
	public String getMulSelunit() {
		return mulSelunit;
	}
	
	@JsonSetter("mulSelunit")
	public void setMulSelunit(String mulSelunit) {
		this.mulSelunit = mulSelunit;
	}
	@JsonGetter("dcTypeMasterID")
	public int getDcTypeMasterID() {
		return dcTypeMasterID;
	}
	@JsonSetter("dcTypeMasterID")
   public void setDcTypeMasterID(int dcTypeMasterID) {
		this.dcTypeMasterID = dcTypeMasterID;
	}
	
	@JsonSetter("doctorTypeIdList")
	public String getDoctorTypeIdList() {
		return doctorTypeIdList;
	}
	@JsonSetter("doctorTypeIdList")
	public void setDoctorTypeIdList(String doctorTypeIdList) {
		this.doctorTypeIdList = doctorTypeIdList;
	}
	/**
	 * @return the user_Name
	 */
	@JsonGetter("un")
	public String getUser_Name() {
		return user_Name;
	}

	/**
	 * @param user_Name
	 *            the user_Name to set
	 */
	@JsonSetter("un")
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	/**
	 * @return the password
	 */
	@JsonGetter("up")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	@JsonSetter("up")
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonSetter("pathologyPer")
	public String getPathologyPer() {
		return pathologyPer;
	}
	@JsonSetter("pathologyPer")
	public void setPathologyPer(String pathologyPer) {
		this.pathologyPer = pathologyPer;
	}
	
	@JsonSetter("physioPer")
	public String getPhysioPer() {
		return physioPer;
	}
	@JsonSetter("physioPer")
	public void setPhysioPer(String physioPer) {
		this.physioPer = physioPer;
	}
	@JsonSetter("otherServicesPer")
	public String getOtherServicesPer() {
		return otherServicesPer;
	}
	@JsonSetter("otherServicesPer")
	public void setOtherServicesPer(String otherServicesPer) {
		this.otherServicesPer = otherServicesPer;
	}
	@JsonSetter("casualtyPer")
	public String getCasualtyPer() {
		return casualtyPer;
	}
	@JsonSetter("casualtyPer")
	public void setCasualtyPer(String casualtyPer) {
		this.casualtyPer = casualtyPer;
	}

	@JsonGetter("clinicPercent")
	public double getClinicPercent() {
		return clinicPercent;
	}

	@JsonSetter("clinicPercent")
	public void setClinicPercent(double clinicPercent) {
		this.clinicPercent = clinicPercent;
	}

	@JsonGetter("testSharedFlag")
	public int getTestSharedFlag() {
		return testSharedFlag;
	}

	@JsonSetter("testSharedFlag")
	public void setTestSharedFlag(int testSharedFlag) {
		this.testSharedFlag = testSharedFlag;
	}

	@JsonGetter("softwareUsed")
	public String getSoftwareUsed() {
		return softwareUsed;
	}

	@JsonSetter("softwareUsed")
	public void setSoftwareUsed(String softwareUsed) {
		this.softwareUsed = softwareUsed;
	}
	
	@JsonGetter("qualification")
	public String getQualification() {
		return qualification;
	}

	@JsonSetter("qualification")
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@JsonGetter("designation")
	public String getDesignation() {
		return designation;
	}

	@JsonSetter("designation")
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@JsonGetter("regNo")
	public String getRegNo() {
		return regNo;
	}

	@JsonSetter("regNo")
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@JsonGetter("dpercent")
	public String getDoctor_percent() {
		return doctor_percent;
	}

	@JsonSetter("dpercent")
	public void setDoctor_percent(String doctor_percent) {
		this.doctor_percent = doctor_percent;
	}
	
	@JsonGetter("pan")
	public String getPAN() {
		return PAN;
	}

	@JsonSetter("pan")
	public void setPAN(String pAN) {
		PAN = pAN;
	}

	@JsonGetter("ctc")
	public String getCTC() {
		return CTC;
	}

	@JsonSetter("ctc")
	public void setCTC(String cTC) {
		CTC = cTC;
	}

	@JsonGetter("plvp")
	public String getPLVP() {
		return PLVP;
	}

	@JsonSetter("plvp")
	public void setPLVP(String pLVP) {
		PLVP = pLVP;
	}

	@JsonGetter("overFlg")
	public String getOverrideChargesFlag() {
		return overrideChargesFlag;
	}

	@JsonSetter("overFlg")
	public void setOverrideChargesFlag(String overrideChargesFlag) {
		this.overrideChargesFlag = overrideChargesFlag;
	}

	@JsonGetter("liVDPro")
	public List<Visiting_doc_Procedure> getLiVDPro() {
		return liVDPro;
	}

	@JsonSetter("liVDPro")
	public void setLiVDPro(List<Visiting_doc_Procedure> liVDPro) {
		this.liVDPro = liVDPro;
	}

	@JsonGetter("chargtyp")
	public String getCharge_type() {
		return charge_type;
	}

	@JsonSetter("chargtyp")
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}

	@JsonGetter("secCurrMon")
	public String getSecurity_current_month() {
		return security_current_month;
	}

	@JsonSetter("secCurrMon")
	public void setSecurity_current_month(String security_current_month) {
		this.security_current_month = security_current_month;
	}

	@JsonGetter("totSubSec")
	public Float getTotal_submit_security() {
		return total_submit_security;
	}

	@JsonSetter("totSubSec")
	public void setTotal_submit_security(Float total_submit_security) {
		this.total_submit_security = total_submit_security;
	}

	@JsonGetter("secMonDed")
	public Float getSecu_monthly_deduct() {
		return secu_monthly_deduct;
	}

	@JsonSetter("secMonDed")
	public void setSecu_monthly_deduct(Float secu_monthly_deduct) {
		this.secu_monthly_deduct = secu_monthly_deduct;
	}

	@JsonGetter("noOfMonth")
	public Float getNo_of_months_for_secu() {
		return no_of_months_for_secu;
	}

	@JsonSetter("noOfMonth")
	public void setNo_of_months_for_secu(Float no_of_months_for_secu) {
		this.no_of_months_for_secu = no_of_months_for_secu;
	}

	@JsonGetter("macEmpCode")
	public String getMachine_emp_code() {
		return machine_emp_code;
	}

	@JsonSetter("macEmpCode")
	public void setMachine_emp_code(String machine_emp_code) {
		this.machine_emp_code = machine_emp_code;
	}

	/**
	 * @return the hosType
	 */
	@JsonGetter("hosType")
	public String getHosType() {
		return hosType;
	}

	/**
	 * @param hosType
	 *            the hosType to set
	 */
	@JsonSetter("hosType")
	public void setHosType(String hosType) {
		this.hosType = hosType;
	}

	/**
	 * @return the followfees
	 */
	@JsonGetter("flwfees")
	public Double getFollowfees() {
		return followfees;
	}

	/**
	 * @param followfees
	 *            the followfees to set
	 */
	@JsonSetter("flwfees")
	public void setFollowfees(Double followfees) {
		this.followfees = followfees;
	}

	/**
	 * @return the status
	 */
	@JsonGetter("st")
	public String getStatus() {
		return status;
	}

	/**
	 * @return the salary
	 */
	@JsonGetter("empSal")
	public Float getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	@JsonSetter("empSal")
	public void setSalary(Float salary) {
		this.salary = salary;
	}

	/**
	 * @return the dob
	 */
	@JsonGetter("udob")
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	@JsonSetter("udob")
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the apartment
	 */
	@JsonGetter("uApart")
	public String getApartment() {
		return apartment;
	}

	/**
	 * @param apartment
	 *            the apartment to set
	 */
	@JsonSetter("uApart")
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	/**
	 * @return the city
	 */
	@JsonGetter("city")
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	@JsonSetter("city")
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	@JsonGetter("state")
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	@JsonSetter("state")
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	@JsonGetter("zip")
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	@JsonSetter("zip")
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the dojoin
	 */
	@JsonGetter("doj")
	public String getDojoin() {
		return dojoin;
	}

	/**
	 * @param dojoin
	 *            the dojoin to set
	 */
	@JsonSetter("doj")
	public void setDojoin(String dojoin) {
		this.dojoin = dojoin;
	}

	/**
	 * @return the schoolNm
	 */
	@JsonGetter("schoolNm")
	public String getSchoolNm() {
		return schoolNm;
	}

	/**
	 * @param schoolNm
	 *            the schoolNm to set
	 */
	@JsonSetter("schoolNm")
	public void setSchoolNm(String schoolNm) {
		this.schoolNm = schoolNm;
	}

	/**
	 * @return the schoolAdd
	 */
	@JsonGetter("schoolAdd")
	public String getSchoolAdd() {
		return schoolAdd;
	}

	/**
	 * @param schoolAdd
	 *            the schoolAdd to set
	 */
	@JsonSetter("schoolAdd")
	public void setSchoolAdd(String schoolAdd) {
		this.schoolAdd = schoolAdd;
	}

	/**
	 * @return the schoolForm
	 */
	@JsonGetter("schoolForm")
	public String getSchoolForm() {
		return schoolForm;
	}

	/**
	 * @param schoolForm
	 *            the schoolForm to set
	 */
	@JsonSetter("schoolForm")
	public void setSchoolForm(String schoolForm) {
		this.schoolForm = schoolForm;
	}

	/**
	 * @return the schooTo
	 */
	@JsonGetter("schooTo")
	public String getSchooTo() {
		return schooTo;
	}

	/**
	 * @param schooTo
	 *            the schooTo to set
	 */
	@JsonSetter("schooTo")
	public void setSchooTo(String schooTo) {
		this.schooTo = schooTo;
	}

	/**
	 * @return the schoolPercent
	 */
	@JsonGetter("schoolPercent")
	public String getSchoolPercent() {
		return schoolPercent;
	}

	/**
	 * @param schoolPercent
	 *            the schoolPercent to set
	 */
	@JsonSetter("schoolPercent")
	public void setSchoolPercent(String schoolPercent) {
		this.schoolPercent = schoolPercent;
	}

	/**
	 * @return the colNm
	 */
	@JsonGetter("colNm")
	public String getColNm() {
		return colNm;
	}

	/**
	 * @param colNm
	 *            the colNm to set
	 */
	@JsonSetter("colNm")
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}

	/**
	 * @return the colAdd
	 */
	@JsonGetter("colAdd")
	public String getColAdd() {
		return colAdd;
	}

	/**
	 * @param colAdd
	 *            the colAdd to set
	 */
	@JsonSetter("colAdd")
	public void setColAdd(String colAdd) {
		this.colAdd = colAdd;
	}

	/**
	 * @return the colForm
	 */
	@JsonGetter("colForm")
	public String getColForm() {
		return colForm;
	}

	/**
	 * @param colForm
	 *            the colForm to set
	 */
	@JsonSetter("colForm")
	public void setColForm(String colForm) {
		this.colForm = colForm;
	}

	/**
	 * @return the colTo
	 */
	@JsonGetter("colTo")
	public String getColTo() {
		return colTo;
	}

	/**
	 * @param colTo
	 *            the colTo to set
	 */
	@JsonSetter("colTo")
	public void setColTo(String colTo) {
		this.colTo = colTo;
	}

	/**
	 * @return the colPercent
	 */
	@JsonGetter("colPercent")
	public String getColPercent() {
		return colPercent;
	}

	/**
	 * @param colPercent
	 *            the colPercent to set
	 */
	@JsonSetter("colPercent")
	public void setColPercent(String colPercent) {
		this.colPercent = colPercent;
	}

	/**
	 * @return the colDegree
	 */
	@JsonGetter("colDegree")
	public String getColDegree() {
		return colDegree;
	}

	/**
	 * @param colDegree
	 *            the colDegree to set
	 */
	@JsonSetter("colDegree")
	public void setColDegree(String colDegree) {
		this.colDegree = colDegree;
	}

	/**
	 * @return the pgNm
	 */
	@JsonGetter("pgNm")
	public String getPgNm() {
		return pgNm;
	}

	/**
	 * @param pgNm
	 *            the pgNm to set
	 */
	@JsonSetter("pgNm")
	public void setPgNm(String pgNm) {
		this.pgNm = pgNm;
	}

	/**
	 * @return the pgAdd
	 */
	@JsonGetter("pgAdd")
	public String getPgAdd() {
		return pgAdd;
	}

	/**
	 * @param pgAdd
	 *            the pgAdd to set
	 */
	@JsonSetter("pgAdd")
	public void setPgAdd(String pgAdd) {
		this.pgAdd = pgAdd;
	}

	/**
	 * @return the pgForm
	 */
	@JsonGetter("pgForm")
	public String getPgForm() {
		return pgForm;
	}

	/**
	 * @param pgForm
	 *            the pgForm to set
	 */
	@JsonSetter("pgForm")
	public void setPgForm(String pgForm) {
		this.pgForm = pgForm;
	}

	/**
	 * @return the pgTo
	 */
	@JsonGetter("pgTo")
	public String getPgTo() {
		return pgTo;
	}

	/**
	 * @param pgTo
	 *            the pgTo to set
	 */
	@JsonSetter("pgTo")
	public void setPgTo(String pgTo) {
		this.pgTo = pgTo;
	}

	/**
	 * @return the pgPercent
	 */
	@JsonGetter("pgPercent")
	public String getPgPercent() {
		return pgPercent;
	}

	/**
	 * @param pgPercent
	 *            the pgPercent to set
	 */
	@JsonSetter("pgPercent")
	public void setPgPercent(String pgPercent) {
		this.pgPercent = pgPercent;
	}

	/**
	 * @return the pgDegree
	 */
	@JsonGetter("pgDegree")
	public String getPgDegree() {
		return pgDegree;
	}

	/**
	 * @param pgDegree
	 *            the pgDegree to set
	 */
	@JsonSetter("pgDegree")
	public void setPgDegree(String pgDegree) {
		this.pgDegree = pgDegree;
	}

	/**
	 * @return the cmpnyNm
	 */
	@JsonGetter("cmpnyNm")
	public String getCmpnyNm() {
		return cmpnyNm;
	}

	/**
	 * @param cmpnyNm
	 *            the cmpnyNm to set
	 */
	@JsonSetter("cmpnyNm")
	public void setCmpnyNm(String cmpnyNm) {
		this.cmpnyNm = cmpnyNm;
	}

	/**
	 * @return the cmpnyAdd
	 */
	@JsonGetter("cmpnyAdd")
	public String getCmpnyAdd() {
		return cmpnyAdd;
	}

	/**
	 * @param cmpnyAdd
	 *            the cmpnyAdd to set
	 */
	@JsonSetter("cmpnyAdd")
	public void setCmpnyAdd(String cmpnyAdd) {
		this.cmpnyAdd = cmpnyAdd;
	}

	/**
	 * @return the cmpnyPhone
	 */
	@JsonGetter("cmpnyPhone")
	public String getCmpnyPhone() {
		return cmpnyPhone;
	}

	/**
	 * @param cmpnyPhone
	 *            the cmpnyPhone to set
	 */
	@JsonSetter("cmpnyPhone")
	public void setCmpnyPhone(String cmpnyPhone) {
		this.cmpnyPhone = cmpnyPhone;
	}

	/**
	 * @return the cmpnyBoss
	 */
	@JsonGetter("cmpnyBoss")
	public String getCmpnyBoss() {
		return cmpnyBoss;
	}

	/**
	 * @param cmpnyBoss
	 *            the cmpnyBoss to set
	 */
	@JsonSetter("cmpnyBoss")
	public void setCmpnyBoss(String cmpnyBoss) {
		this.cmpnyBoss = cmpnyBoss;
	}

	/**
	 * @return the jobTitle
	 */
	@JsonGetter("jobTitle")
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	@JsonSetter("jobTitle")
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the jobResp
	 */
	@JsonGetter("jobResp")
	public String getJobResp() {
		return jobResp;
	}

	/**
	 * @param jobResp
	 *            the jobResp to set
	 */
	@JsonSetter("jobResp")
	public void setJobResp(String jobResp) {
		this.jobResp = jobResp;
	}

	/**
	 * @return the jobForm
	 */
	@JsonGetter("jobForm")
	public String getJobForm() {
		return jobForm;
	}

	/**
	 * @param jobForm
	 *            the jobForm to set
	 */
	@JsonSetter("jobForm")
	public void setJobForm(String jobForm) {
		this.jobForm = jobForm;
	}

	/**
	 * @return the jobTo
	 */
	@JsonGetter("jobTo")
	public String getJobTo() {
		return jobTo;
	}

	/**
	 * @param jobTo
	 *            the jobTo to set
	 */
	@JsonSetter("jobTo")
	public void setJobTo(String jobTo) {
		this.jobTo = jobTo;
	}

	/**
	 * @return the fees
	 */
	@JsonGetter("df")
	public int getFees() {
		return fees;
	}

	/**
	 * @param fees
	 *            the fees to set
	 */
	@JsonSetter("df")
	public void setFees(int fees) {
		this.fees = fees;
	}

	private List<Doctor> doctorList;

	/**
	 * @return the doctorList
	 */
	@JsonGetter("dl")
	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	@JsonGetter("ad")
	public String getAddress() {
		return address;
	}

	@JsonSetter("ad")
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonGetter("mb")
	public String getMobileNo() {
		return mobileNo;
	}

	@JsonSetter("mb")
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@JsonGetter("eid")
	public String getEmail_Id() {
		return email_Id;
	}

	@JsonSetter("eid")
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	@JsonGetter("ed")
	public String getEducation() {
		return education;
	}

	@JsonSetter("ed")
	public void setEducation(String education) {
		this.education = education;
	}

	@JsonGetter("sp")
	public String getSpecialisation() {
		return specialisation;
	}

	@JsonSetter("sp")
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	@JsonGetter("dt")
	public String getDoc_Type() {
		return doc_Type;
	}

	@JsonSetter("dt")
	public void setDoc_Type(String doc_Type) {
		this.doc_Type = doc_Type;
	}

	/**
	 * @param doctorList
	 *            the doctorList to set
	 */
	@JsonSetter("dl")
	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	/**
	 * @return the doc_name
	 */
	@JsonGetter("dn")
	public String getDoc_name() {
		return doc_name;
	}

	/**
	 * @param doc_name
	 *            the doc_name to set
	 */
	@JsonSetter("dn")
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	/**
	 * @return the doctor_ID
	 */
	@JsonGetter("di")
	public int getDoctor_ID() {
		return Doctor_ID;
	}

	/**
	 * @param doctor_ID
	 *            the doctor_ID to set
	 */
	@JsonSetter("di")
	public void setDoctor_ID(int doctor_ID) {
		Doctor_ID = doctor_ID;
	}

	@JsonSetter("st")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonSetter("ui")
	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	@JsonGetter("ui")
	public int getUser_ID() {
		return User_ID;
	}

	@JsonGetter("listDoctor")
	public List<Doctor> getListDoctorDetails() {
		return listDoctorDetails;
	}
	
	@JsonSetter("listDoctor")	//jitendra
	public void setListDoctorDetails(List<Doctor> listDoctorDetails) {
		this.listDoctorDetails = listDoctorDetails;
	}

	@JsonGetter("aplLeaves")
	public int getAplicable_leaves() {
		return aplicable_leaves;
	}

	@JsonSetter("aplLeaves")
	public void setAplicable_leaves(int aplicable_leaves) {
		this.aplicable_leaves = aplicable_leaves;
	}

	@JsonGetter("balLeaves")
	public int getBalance_leaves() {
		return balance_leaves;
	}

	@JsonSetter("balLeaves")
	public void setBalance_leaves(int balance_leaves) {
		this.balance_leaves = balance_leaves;
	}

	@JsonGetter("dept")
	public String getDepartment() {
		return department;
	}

	@JsonSetter("dept")
	public void setDepartment(String department) {
		this.department = department;
	}

	@JsonGetter("depNm")
	public String getDepartmentName() {
		return departmentName;
	}

	@JsonSetter("depNm")
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@JsonGetter("spl")
	public String getSpeciality() {
		return speciality;
	}

	@JsonSetter("spl")
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@JsonGetter("specialisationName")
	public String getSpecialisationName() {
		return specialisationName;
	}

	@JsonSetter("specialisationName")
	public void setSpecialisationName(String specialisationName) {
		this.specialisationName = specialisationName;
	}
	@JsonGetter("sendSMSflag")
	public String getSendSMSflag() {
		return sendSMSflag;
	}
	@JsonSetter("sendSMSflag")
	public void setSendSMSflag(String sendSMSflag) {
		this.sendSMSflag = sendSMSflag;
	}
	@JsonGetter("Docsign")
	public String getDocsign() {
		return Docsign;
	}
	@JsonSetter("Docsign")
	public void setDocsign(String docsign) {
		Docsign = docsign;
	}
	@JsonGetter("motivatorAuthorisation")
	public String getMotivatorAuthorisation() {
		return motivatorAuthorisation;
	}

	@JsonSetter("motivatorAuthorisation")
	public void setMotivatorAuthorisation(String motivatorAuthorisation) {
		this.motivatorAuthorisation = motivatorAuthorisation;
	}
	
	@JsonGetter("sunMorningStart")
	public String getSunMorningStart() {
		return sunMorningStart;
	}
	@JsonSetter("sunMorningStart")
	public void setSunMorningStart(String sunMorningStart) {
		this.sunMorningStart = sunMorningStart;
	}
	
	@JsonGetter("monMorningStart")
	public String getMonMorningStart() {
		return monMorningStart;
	}
	@JsonSetter("monMorningStart")
	public void setMonMorningStart(String monMorningStart) {
		this.monMorningStart = monMorningStart;
	}
	
	@JsonGetter("tueMorningStart")
	public String getTueMorningStart() {
		return tueMorningStart;
	}
	@JsonSetter("tueMorningStart")
	public void setTueMorningStart(String tueMorningStart) {
		this.tueMorningStart = tueMorningStart;
	}
	
	@JsonGetter("wedMorningStart")
	public String getWedMorningStart() {
		return wedMorningStart;
	}
	@JsonSetter("wedMorningStart")
	public void setWedMorningStart(String wedMorningStart) {
		this.wedMorningStart = wedMorningStart;
	}
	
	@JsonGetter("thiMorningStart")
	public String getThiMorningStart() {
		return thiMorningStart;
	}
	@JsonSetter("thiMorningStart")
	public void setThiMorningStart(String thiMorningStart) {
		this.thiMorningStart = thiMorningStart;
	}
	
	@JsonGetter("friMorningStart")
	public String getFriMorningStart() {
		return friMorningStart;
	}
	@JsonSetter("friMorningStart")
	public void setFriMorningStart(String friMorningStart) {
		this.friMorningStart = friMorningStart;
	}
	
	@JsonGetter("satMorningStart")
	public String getSatMorningStart() {
		return satMorningStart;
	}
	@JsonSetter("satMorningStart")
	public void setSatMorningStart(String satMorningStart) {
		this.satMorningStart = satMorningStart;
	}
	
	@JsonGetter("sunMorningEnd")
	public String getSunMorningEnd() {
		return sunMorningEnd;
	}
	@JsonSetter("sunMorningEnd")
	public void setSunMorningEnd(String sunMorningEnd) {
		this.sunMorningEnd = sunMorningEnd;
	}
	
	@JsonGetter("monMorningEnd")
	public String getMonMorningEnd() {
		return monMorningEnd;
	}
	@JsonSetter("monMorningEnd")
	public void setMonMorningEnd(String monMorningEnd) {
		this.monMorningEnd = monMorningEnd;
	}
	
	@JsonGetter("tueMorningEnd")
	public String getTueMorningEnd() {
		return tueMorningEnd;
	}
	@JsonSetter("tueMorningEnd")
	public void setTueMorningEnd(String tueMorningEnd) {
		this.tueMorningEnd = tueMorningEnd;
	}
	
	@JsonGetter("wedMorningEnd")
	public String getWedMorningEnd() {
		return wedMorningEnd;
	}
	@JsonSetter("wedMorningEnd")
	public void setWedMorningEnd(String wedMorningEnd) {
		this.wedMorningEnd = wedMorningEnd;
	}
	
	@JsonGetter("thiMorningEnd")
	public String getThiMorningEnd() {
		return thiMorningEnd;
	}
	@JsonSetter("thiMorningEnd")
	public void setThiMorningEnd(String thiMorningEnd) {
		this.thiMorningEnd = thiMorningEnd;
	}
	
	@JsonGetter("friMorningEnd")
	public String getFriMorningEnd() {
		return friMorningEnd;
	}
	@JsonSetter("friMorningEnd")
	public void setFriMorningEnd(String friMorningEnd) {
		this.friMorningEnd = friMorningEnd;
	}
	
	@JsonGetter("satMorningEnd")
	public String getSatMorningEnd() {
		return satMorningEnd;
	}
	@JsonSetter("satMorningEnd")
	public void setSatMorningEnd(String satMorningEnd) {
		this.satMorningEnd = satMorningEnd;
	}
	
	@JsonGetter("sunAfternoonStart")
	public String getSunAfternoonStart() {
		return sunAfternoonStart;
	}
	@JsonSetter("sunAfternoonStart")
	public void setSunAfternoonStart(String sunAfternoonStart) {
		this.sunAfternoonStart = sunAfternoonStart;
	}
	
	@JsonGetter("monAfternoonStart")
	public String getMonAfternoonStart() {
		return monAfternoonStart;
	}
	@JsonSetter("monAfternoonStart")
	public void setMonAfternoonStart(String monAfternoonStart) {
		this.monAfternoonStart = monAfternoonStart;
	}
	
	@JsonGetter("tueAfternoonStart")
	public String getTueAfternoonStart() {
		return tueAfternoonStart;
	}
	@JsonSetter("tueAfternoonStart")
	public void setTueAfternoonStart(String tueAfternoonStart) {
		this.tueAfternoonStart = tueAfternoonStart;
	}
	
	@JsonGetter("wedAfternoonStart")
	public String getWedAfternoonStart() {
		return wedAfternoonStart;
	}
	@JsonSetter("wedAfternoonStart")
	public void setWedAfternoonStart(String wedAfternoonStart) {
		this.wedAfternoonStart = wedAfternoonStart;
	}
	
	@JsonGetter("thiAfternoonStart")
	public String getThiAfternoonStart() {
		return thiAfternoonStart;
	}
	@JsonSetter("thiAfternoonStart")
	public void setThiAfternoonStart(String thiAfternoonStart) {
		this.thiAfternoonStart = thiAfternoonStart;
	}
	
	@JsonGetter("friAfternoonStart")
	public String getFriAfternoonStart() {
		return friAfternoonStart;
	}
	@JsonSetter("friAfternoonStart")
	public void setFriAfternoonStart(String friAfternoonStart) {
		this.friAfternoonStart = friAfternoonStart;
	}
	
	@JsonGetter("satAfternoonStart")
	public String getSatAfternoonStart() {
		return satAfternoonStart;
	}
	@JsonSetter("satAfternoonStart")
	public void setSatAfternoonStart(String satAfternoonStart) {
		this.satAfternoonStart = satAfternoonStart;
	}
	
	@JsonGetter("sunAfternoonEnd")
	public String getSunAfternoonEnd() {
		return sunAfternoonEnd;
	}
	@JsonSetter("sunAfternoonEnd")
	public void setSunAfternoonEnd(String sunAfternoonEnd) {
		this.sunAfternoonEnd = sunAfternoonEnd;
	}
	
	@JsonGetter("monAfternoonEnd")
	public String getMonAfternoonEnd() {
		return monAfternoonEnd;
	}
	@JsonSetter("monAfternoonEnd")
	public void setMonAfternoonEnd(String monAfternoonEnd) {
		this.monAfternoonEnd = monAfternoonEnd;
	}
	
	@JsonGetter("tueAfternoonEnd")
	public String getTueAfternoonEnd() {
		return tueAfternoonEnd;
	}
	@JsonSetter("tueAfternoonEnd")
	public void setTueAfternoonEnd(String tueAfternoonEnd) {
		this.tueAfternoonEnd = tueAfternoonEnd;
	}
	
	@JsonGetter("wedAfternoonEnd")
	public String getWedAfternoonEnd() {
		return wedAfternoonEnd;
	}
	@JsonSetter("wedAfternoonEnd")
	public void setWedAfternoonEnd(String wedAfternoonEnd) {
		this.wedAfternoonEnd = wedAfternoonEnd;
	}
	
	@JsonGetter("thiAfternoonEnd")
	public String getThiAfternoonEnd() {
		return thiAfternoonEnd;
	}
	@JsonSetter("thiAfternoonEnd")
	public void setThiAfternoonEnd(String thiAfternoonEnd) {
		this.thiAfternoonEnd = thiAfternoonEnd;
	}
	
	@JsonGetter("friAfternoonEnd")
	public String getFriAfternoonEnd() {
		return friAfternoonEnd;
	}
	@JsonSetter("friAfternoonEnd")
	public void setFriAfternoonEnd(String friAfternoonEnd) {
		this.friAfternoonEnd = friAfternoonEnd;
	}
	
	@JsonGetter("satAfternoonEnd")
	public String getSatAfternoonEnd() {
		return satAfternoonEnd;
	}
	@JsonSetter("satAfternoonEnd")
	public void setSatAfternoonEnd(String satAfternoonEnd) {
		this.satAfternoonEnd = satAfternoonEnd;
	}
	
	@JsonGetter("sunEverningStart")
	public String getSunEverningStart() {
		return sunEverningStart;
	}
	@JsonSetter("sunEverningStart")
	public void setSunEverningStart(String sunEverningStart) {
		this.sunEverningStart = sunEverningStart;
	}
	
	@JsonGetter("monEverningStart")
	public String getMonEverningStart() {
		return monEverningStart;
	}
	@JsonSetter("monEverningStart")
	public void setMonEverningStart(String monEverningStart) {
		this.monEverningStart = monEverningStart;
	}
	
	@JsonGetter("tueEverningStart")
	public String getTueEverningStart() {
		return tueEverningStart;
	}
	@JsonSetter("tueEverningStart")
	public void setTueEverningStart(String tueEverningStart) {
		this.tueEverningStart = tueEverningStart;
	}
	
	@JsonGetter("wedEverningStart")
	public String getWedEverningStart() {
		return wedEverningStart;
	}
	@JsonSetter("wedEverningStart")
	public void setWedEverningStart(String wedEverningStart) {
		this.wedEverningStart = wedEverningStart;
	}
	
	@JsonGetter("thiEverningStart")
	public String getThiEverningStart() {
		return thiEverningStart;
	}
	@JsonSetter("thiEverningStart")
	public void setThiEverningStart(String thiEverningStart) {
		this.thiEverningStart = thiEverningStart;
	}
	
	@JsonGetter("friEverningStart")
	public String getFriEverningStart() {
		return friEverningStart;
	}
	@JsonSetter("friEverningStart")
	public void setFriEverningStart(String friEverningStart) {
		this.friEverningStart = friEverningStart;
	}
	
	@JsonGetter("satEverningStart")
	public String getSatEverningStart() {
		return satEverningStart;
	}
	@JsonSetter("satEverningStart")
	public void setSatEverningStart(String satEverningStart) {
		this.satEverningStart = satEverningStart;
	}
	
	@JsonGetter("sunEverningEnd")
	public String getSunEverningEnd() {
		return sunEverningEnd;
	}
	@JsonSetter("sunEverningEnd")
	public void setSunEverningEnd(String sunEverningEnd) {
		this.sunEverningEnd = sunEverningEnd;
	}
	
	@JsonGetter("monEverningEnd")
	public String getMonEverningEnd() {
		return monEverningEnd;
	}
	@JsonSetter("monEverningEnd")
	public void setMonEverningEnd(String monEverningEnd) {
		this.monEverningEnd = monEverningEnd;
	}
	
	@JsonGetter("tueEverningEnd")
	public String getTueEverningEnd() {
		return tueEverningEnd;
	}
	@JsonSetter("tueEverningEnd")
	public void setTueEverningEnd(String tueEverningEnd) {
		this.tueEverningEnd = tueEverningEnd;
	}
	
	@JsonGetter("wedEverningEnd")
	public String getWedEverningEnd() {
		return wedEverningEnd;
	}
	@JsonSetter("wedEverningEnd")
	public void setWedEverningEnd(String wedEverningEnd) {
		this.wedEverningEnd = wedEverningEnd;
	}
	
	@JsonGetter("thiEverningEnd")
	public String getThiEverningEnd() {
		return thiEverningEnd;
	}
	@JsonSetter("thiEverningEnd")
	public void setThiEverningEnd(String thiEverningEnd) {
		this.thiEverningEnd = thiEverningEnd;
	}
	
	@JsonGetter("friEverningEnd")
	public String getFriEverningEnd() {
		return friEverningEnd;
	}
	@JsonSetter("friEverningEnd")
	public void setFriEverningEnd(String friEverningEnd) {
		this.friEverningEnd = friEverningEnd;
	}
	
	@JsonGetter("satEverningEnd")
	public String getSatEverningEnd() {
		return satEverningEnd;
	}
	@JsonSetter("satEverningEnd")
	public void setSatEverningEnd(String satEverningEnd) {
		this.satEverningEnd = satEverningEnd;
	}
	@JsonGetter("tomid")
	public int getTomID() {
		return tomID;
	}
	@JsonSetter("tomid")
	public void setTomID(int tomID) {
		this.tomID = tomID;
	}

	@JsonGetter("empIdhr")
	public String getEmpIdhr() {
		return empIdhr;
	}
	@JsonSetter("empIdhr")
	public void setEmpIdhr(String empIdhr) {
		this.empIdhr = empIdhr;
	}
	
	private double doctorfee;
	
	private double fixedIncome;
	
	private double referalPercent;

	@JsonGetter("doctorfee")
	public double getDoctorfee() {
		return doctorfee;
	}
	
	@JsonSetter("doctorfee")
	public void setDoctorfee(double doctorfee) {
		this.doctorfee = doctorfee;
	}
	
	@JsonGetter("fixedIncome")
	public double getFixedIncome() {
		return fixedIncome;
	}
	@JsonSetter("fixedIncome")
	public void setFixedIncome(double fixedIncome) {
		this.fixedIncome = fixedIncome;
	}
	
	@JsonGetter("referalPercent")
	public double getReferalPercent() {
		return referalPercent;
	}
	
	@JsonSetter("referalPercent")
	public void setReferalPercent(double referalPercent) {
		this.referalPercent = referalPercent;
	}
	
	@JsonGetter("folloupFees")
	public double getFolloupFees() {
		return folloupFees;
	}
	@JsonSetter("folloupFees")
	public void setFolloupFees(double folloupFees) {
		this.folloupFees = folloupFees;
	}

	@JsonGetter("folloupWeekend")
	public double getFolloupWeekend() {
		return folloupWeekend;
	}
	@JsonSetter("folloupWeekend")
	public void setFolloupWeekend(double folloupWeekend) {
		this.folloupWeekend = folloupWeekend;
	}
	
	//adding Ajay:28-april-2019 purpose adding reg date ,reli date , termination service//
	private String dateReg;
	private String dateReve;
	private String terid;
    private String specializationName;
    
    
    
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	public String getDateReg() {
		return dateReg;
	}
	public void setDateReg(String dateReg) {
		this.dateReg = dateReg;
	}
	public String getDateReve() {
		return dateReve;
	}
	public void setDateReve(String dateReve) {
		this.dateReve = dateReve;
	}
	public String getTerid() {
		return terid;
	}
	public void setTerid(String terid) {
		this.terid = terid;
	}
	
	private double perVisitCharge;	//jitendra
	
	@JsonGetter("perVisitCharge")
	public double getPerVisitCharge() {	//jitendra
		return perVisitCharge;
	}
	
	@JsonSetter("perVisitCharge")
	public void setPerVisitCharge(double perVisitCharge) {	//jitendra
		this.perVisitCharge = perVisitCharge;
	}
	
	@JsonGetter("employeeServiceCode")
	public String getEmployeeServiceCode() {
		return employeeServiceCode;
	}
	
	@JsonSetter("employeeServiceCode")
	public void setEmployeeServiceCode(String employeeServiceCode) {
		this.employeeServiceCode = employeeServiceCode;
	}
	
	@JsonGetter("bankName")
	public String getBankName() {
		return bankName;
	}
	
	@JsonSetter("bankName")
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@JsonGetter("bankBranchName")
	public String getBankBranchName() {
		return bankBranchName;
	}
	
	@JsonSetter("bankBranchName")
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}
	
	@JsonGetter("bankAccountNo")
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	
	@JsonSetter("bankAccountNo")
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	
	@JsonGetter("ifscCode")
	public String getIfscCode() {
		return ifscCode;
	}
	
	@JsonSetter("ifscCode")
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	@JsonGetter("micrCode")
	public String getMicrCode() {
		return micrCode;
	}
	
	@JsonSetter("micrCode")
	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getInhouseLabId() {
		return inhouseLabId;
	}
	public void setInhouseLabId(String inhouseLabId) {
		this.inhouseLabId = inhouseLabId;
	}
	public List<UserCustomersDto> getUserCustomersList() {
		return userCustomersList;
	}
	public void setUserCustomersList(List<UserCustomersDto> userCustomersList) {
		this.userCustomersList = userCustomersList;
	}
	
	public String getUsePrepaidCreditAmount() {
		return usePrepaidCreditAmount;
	}
	public void setUsePrepaidCreditAmount(String usePrepaidCreditAmount) {
		this.usePrepaidCreditAmount = usePrepaidCreditAmount;
	}
	
	public int getCollectedAt() {
		return collectedAt;
	}
	public void setCollectedAt(int collectedAt) {
		this.collectedAt = collectedAt;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	
	public String getUpdateCustomerDetails() {
		return updateCustomerDetails;
	}
	public void setUpdateCustomerDetails(String updateCustomerDetails) {
		this.updateCustomerDetails = updateCustomerDetails;
	}
	public String getUpdateRateAmount() {
		return updateRateAmount;
	}
	public void setUpdateRateAmount(String updateRateAmount) {
		this.updateRateAmount = updateRateAmount;
	}
	public String getEditMakePayment() {
		return editMakePayment;
	}
	public void setEditMakePayment(String editMakePayment) {
		this.editMakePayment = editMakePayment;
	}
	public String getParentUtilizationAmountAcces() {
		return parentUtilizationAmountAcces;
	}
	public void setParentUtilizationAmountAcces(String parentUtilizationAmountAcces) {
		this.parentUtilizationAmountAcces = parentUtilizationAmountAcces;
	}
		
	public String getB2bAndB2cQueueAcces() {
		return b2bAndB2cQueueAcces;
	}
	public void setB2bAndB2cQueueAcces(String b2bAndB2cQueueAcces) {
		this.b2bAndB2cQueueAcces = b2bAndB2cQueueAcces;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + User_ID;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (User_ID != other.User_ID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Doctor [doc_name=" + doc_name + ", Doctor_ID=" + Doctor_ID + ", address=" + address + ", mobileNo="
				+ mobileNo + ", email_Id=" + email_Id + ", education=" + education + ", specialisation="
				+ specialisation + ", specialisationName=" + specialisationName + ", doc_Type=" + doc_Type
				+ ", User_ID=" + User_ID + ", userFor=" + userFor + ", collectedAt=" + collectedAt + ", fees=" + fees
				+ ", dob=" + dob + ", apartment=" + apartment + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", dojoin=" + dojoin + ", schoolNm=" + schoolNm + ", schoolAdd=" + schoolAdd + ", schoolForm="
				+ schoolForm + ", schooTo=" + schooTo + ", schoolPercent=" + schoolPercent + ", colNm=" + colNm
				+ ", colAdd=" + colAdd + ", colForm=" + colForm + ", colTo=" + colTo + ", colPercent=" + colPercent
				+ ", colDegree=" + colDegree + ", pgNm=" + pgNm + ", pgAdd=" + pgAdd + ", pgForm=" + pgForm + ", pgTo="
				+ pgTo + ", pgPercent=" + pgPercent + ", pgDegree=" + pgDegree + ", cmpnyNm=" + cmpnyNm + ", cmpnyAdd="
				+ cmpnyAdd + ", cmpnyPhone=" + cmpnyPhone + ", cmpnyBoss=" + cmpnyBoss + ", jobTitle=" + jobTitle
				+ ", jobResp=" + jobResp + ", jobForm=" + jobForm + ", jobTo=" + jobTo + ", salary=" + salary
				+ ", followfees=" + followfees + ", status=" + status + ", hosType=" + hosType
				+ ", secu_monthly_deduct=" + secu_monthly_deduct + ", no_of_months_for_secu=" + no_of_months_for_secu
				+ ", machine_emp_code=" + machine_emp_code + ", aplicable_leaves=" + aplicable_leaves
				+ ", balance_leaves=" + balance_leaves + ", charge_type=" + charge_type + ", security_current_month="
				+ security_current_month + ", total_submit_security=" + total_submit_security + ", department="
				+ department + ", speciality=" + speciality + ", PAN=" + PAN + ", CTC=" + CTC + ", PLVP=" + PLVP
				+ ", doctor_percent=" + doctor_percent + ", Docsign=" + Docsign + ", tomID=" + tomID
				+ ", qualification=" + qualification + ", designation=" + designation + ", regNo=" + regNo
				+ ", overrideChargesFlag=" + overrideChargesFlag + ", sendSMSflag=" + sendSMSflag + ", softwareUsed="
				+ softwareUsed + ", hrmsEmpFlag=" + hrmsEmpFlag + ", lookupDetIdTtl=" + lookupDetIdTtl
				+ ", listDoctorDetails=" + listDoctorDetails + ", departmentName=" + departmentName
				+ ", motivatorAuthorisation=" + motivatorAuthorisation + ", liVDPro=" + liVDPro + ", constCharges="
				+ constCharges + ", investPer=" + investPer + ", sunMorningStart=" + sunMorningStart
				+ ", monMorningStart=" + monMorningStart + ", tueMorningStart=" + tueMorningStart + ", wedMorningStart="
				+ wedMorningStart + ", thiMorningStart=" + thiMorningStart + ", friMorningStart=" + friMorningStart
				+ ", satMorningStart=" + satMorningStart + ", sunMorningEnd=" + sunMorningEnd + ", monMorningEnd="
				+ monMorningEnd + ", tueMorningEnd=" + tueMorningEnd + ", wedMorningEnd=" + wedMorningEnd
				+ ", thiMorningEnd=" + thiMorningEnd + ", friMorningEnd=" + friMorningEnd + ", satMorningEnd="
				+ satMorningEnd + ", sunAfternoonStart=" + sunAfternoonStart + ", monAfternoonStart="
				+ monAfternoonStart + ", tueAfternoonStart=" + tueAfternoonStart + ", wedAfternoonStart="
				+ wedAfternoonStart + ", thiAfternoonStart=" + thiAfternoonStart + ", friAfternoonStart="
				+ friAfternoonStart + ", satAfternoonStart=" + satAfternoonStart + ", sunAfternoonEnd="
				+ sunAfternoonEnd + ", monAfternoonEnd=" + monAfternoonEnd + ", tueAfternoonEnd=" + tueAfternoonEnd
				+ ", wedAfternoonEnd=" + wedAfternoonEnd + ", thiAfternoonEnd=" + thiAfternoonEnd + ", friAfternoonEnd="
				+ friAfternoonEnd + ", satAfternoonEnd=" + satAfternoonEnd + ", sunEverningStart=" + sunEverningStart
				+ ", monEverningStart=" + monEverningStart + ", tueEverningStart=" + tueEverningStart
				+ ", wedEverningStart=" + wedEverningStart + ", thiEverningStart=" + thiEverningStart
				+ ", friEverningStart=" + friEverningStart + ", satEverningStart=" + satEverningStart
				+ ", sunEverningEnd=" + sunEverningEnd + ", monEverningEnd=" + monEverningEnd + ", tueEverningEnd="
				+ tueEverningEnd + ", wedEverningEnd=" + wedEverningEnd + ", thiEverningEnd=" + thiEverningEnd
				+ ", friEverningEnd=" + friEverningEnd + ", satEverningEnd=" + satEverningEnd + ", empIdhr=" + empIdhr
				+ ", clinicPercent=" + clinicPercent + ", testSharedFlag=" + testSharedFlag + ", docIni=" + docIni
				+ ", folloupFees=" + folloupFees + ", folloupWeekend=" + folloupWeekend + ", employeeServiceCode="
				+ employeeServiceCode + ", bankName=" + bankName + ", bankBranchName=" + bankBranchName
				+ ", bankAccountNo=" + bankAccountNo + ", ifscCode=" + ifscCode + ", micrCode=" + micrCode + ", drSign="
				+ drSign + ", drSpecialization=" + drSpecialization + ", usePrepaidCreditAmount="
				+ usePrepaidCreditAmount + ", pathologyPer=" + pathologyPer + ", physioPer=" + physioPer
				+ ", otherServicesPer=" + otherServicesPer + ", casualtyPer=" + casualtyPer + ", user_Name=" + user_Name
				+ ", password=" + password + ", dcTypeMasterID=" + dcTypeMasterID + ", mulSelunit=" + mulSelunit
				+ ", mulDeptid=" + mulDeptid + ", mulServiceid=" + mulServiceid + ", adminServiceid=" + adminServiceid
				+ ", doctorTypeIdList=" + doctorTypeIdList + ", customerType=" + customerType + ", customerId="
				+ customerId + ", inhouseLabId=" + inhouseLabId + ", userCustomersList=" + userCustomersList
				+ ", doctorList=" + doctorList + ", doctorfee="
				+ doctorfee + ", fixedIncome=" + fixedIncome + ", referalPercent=" + referalPercent + ", dateReg="
				+ dateReg + ", dateReve=" + dateReve + ", terid=" + terid + ", specializationName=" + specializationName
				+ ", perVisitCharge=" + perVisitCharge + "]";
	}
	
	
}
