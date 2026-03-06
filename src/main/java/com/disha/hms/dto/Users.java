package com.disha.hms.dto;

import java.io.Serializable;
import java.util.List;

import com.disha.hms.entity.UserCustomersDto;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_ID;
	private String full_name;
	private String title;
	private String unit_name;
	private String f_name;
	private String m_name;
	private String l_name;
	private String user_Name;
	private String user_Type;
	private String password;
	private String created_Date;
	private String availability;
	private String status;
	private List<Users> usersList;
	private int doc_id;
	private String userFor;
	private int collectedAt;
	private String doc_name;
	private Doctor objDoctor;
	private String last_loged_in_date_time;
	private String last_loged_out_date_time;
	private String current_loged_in_date_time;
	private String current_loged_out_date_time;
	private String softwareUsed;
	private String signOne;
	private String signOneDoctor;
	private String signTwo;
	private String signTwoDoctor;
	private String hrms_emp_flag;
	private int lookupDetIdTtl;
	private String rowCount; //added by prayag for pagination
	private int projectId;
	
	private String usePrepaidCreditAmount;
	private String updateCustomerDetails;
	private String updateRateAmount ;
	private String editMakePayment ;
    private String parentUtilizationAmountAcces;
	private String b2bAndB2cQueueAcces;
	
	
	 private String defaultSignatureflag;
	 private String departmentName;
	 
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
  
	@JsonGetter("lookup_det_id_ttl")
	public int getLookupDetIdTtl() {
		return lookupDetIdTtl;
	}
	
	@JsonSetter("lookup_det_id_ttl")
	public void setLookupDetIdTtl(int lookupDetIdTtl) {
		this.lookupDetIdTtl = lookupDetIdTtl;
	}
	public String getHrms_emp_flag() {
		return hrms_emp_flag;
	}
	public void setHrms_emp_flag(String hrms_emp_flag) {
		this.hrms_emp_flag = hrms_emp_flag;
	}
	//@Name: paras suryawanshi @date: 18-5-2017 @reason: doctor type master
	private int	dcTypeMasterID;
	private String  mulSelunit;
	
	// added by kishor @date 15/3/2018
		private String  doctorTypeIdList;
	
	private String  mulDeptid; //@Name: Sagar Kadam @date:07/07/-2017 @reason: dept master

	
	private String  mulServiceid;  //@Name: Sagar Kadam @date:07/07/-2017 @reason: dept master
		
	//added by Vinod  @date 20/11/2017
	private String  adminServiceid;
	
	private String empIdhr;
	
	
	private String customerType;//added by dayanand(18-3-2020)
	private String customerId;//added by dayanand(18-3-2020)
	private String inhouseLabId;//added by dayanand(18-3-2020)	
	
	private List<UserCustomersDto> userCustomersList;
	
	@JsonGetter("empIdhr")
	public String getEmpIdhr() {
		return empIdhr;
	}
	@JsonSetter("empIdhr")
	public void setEmpIdhr(String empIdhr) {
		this.empIdhr = empIdhr;
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
	
	public String getSoftwareUsed() {
		return softwareUsed;
	}

	public void setSoftwareUsed(String softwareUsed) {
		this.softwareUsed = softwareUsed;
	}
	
	

	public String getAdminServiceid() {
		return adminServiceid;
	}
	public void setAdminServiceid(String adminServiceid) {
		this.adminServiceid = adminServiceid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the doc_id
	 */
	public int getDoc_id() {
		return doc_id;
	}

	/**
	 * @param doc_id
	 *            the doc_id to set
	 */
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	/**
	 * @return the doc_name
	 */
	public String getDoc_name() {
		return doc_name;
	}

	/**
	 * @param doc_name
	 *            the doc_name to set
	 */
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	/**
	 * @return the availability
	 */
	@JsonGetter("ua")
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 *            the availability to set
	 */
	@JsonSetter("ua")
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * @return the usersList
	 */
	@JsonGetter("ul")
	public List<Users> getUsersList() {
		return usersList;
	}

	/**
	 * @param usersList
	 *            the usersList to set
	 */
	@JsonSetter("ul")
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

	public Users() {

	}

	public Users(String user_Name, String user_Type, String password) {

		this.password = password;
		this.user_Name = user_Name;
		this.user_Type = user_Type;

	}

	public Users(String user_Name, String user_Type,  String unit_name  ,String password) {

		this.password = password;
		this.user_Name = user_Name;
		this.user_Type = user_Type;
		this.unit_name = unit_name;

	}

	public Users(int user_ID, String user_Name, String user_Type,
			String password, String created_Date) {

		this.password = password;
		this.user_ID = user_ID;
		this.user_Name = user_Name;
		this.user_Type = user_Type;
		this.created_Date = created_Date;
	}

	@JsonGetter("cd")
	public String getCreated_Date() {
		return created_Date;
	}

	@JsonSetter("cd")
	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	/**
	 * @return the user_ID
	 */
	@JsonGetter("ui")
	public int getUser_ID() {
		return user_ID;
	}

	/**
	 * @param user_ID
	 *            the user_ID to set
	 */
	@JsonSetter("ui")
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
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
	 * @return the user_Type
	 */
	@JsonGetter("ut")
	public String getUser_Type() {
		return user_Type;
	}

	/**
	 * @param user_Type
	 *            the user_Type to set
	 */
	@JsonSetter("ut")
	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
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

	@JsonSetter("st")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonGetter("st")
	public String getStatus() {
		return status;
	}

	@JsonSetter("obd")
	public void setObjDoctor(Doctor objDoctor) {
		this.objDoctor = objDoctor;
	}

	@JsonGetter("obd")
	public Doctor getObjDoctor() {
		return objDoctor;
	}
	@JsonGetter("fuNm")
	public String getFull_name() {
		return full_name;
	}
	@JsonSetter("fuNm")
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	@JsonGetter("title")
	public String getTitle() {
		return title;
	}
	@JsonSetter("title")
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonGetter("fname")
	public String getF_name() {
		return f_name;
	}
	@JsonSetter("fname")
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	@JsonGetter("mname")
	public String getM_name() {
		return m_name;
	}
	@JsonSetter("mname")
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	@JsonGetter("lname")
	public String getL_name() {
		return l_name;
	}
	@JsonSetter("lname")
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	
	public String getLast_loged_in_date_time() {
		return last_loged_in_date_time;
	}

	public void setLast_loged_in_date_time(String last_loged_in_date_time) {
		this.last_loged_in_date_time = last_loged_in_date_time;
	}

	public String getLast_loged_out_date_time() {
		return last_loged_out_date_time;
	}

	public void setLast_loged_out_date_time(String last_loged_out_date_time) {
		this.last_loged_out_date_time = last_loged_out_date_time;
	}

	public String getCurrent_loged_in_date_time() {
		return current_loged_in_date_time;
	}

	public void setCurrent_loged_in_date_time(String current_loged_in_date_time) {
		this.current_loged_in_date_time = current_loged_in_date_time;
	}

	public String getCurrent_loged_out_date_time() {
		return current_loged_out_date_time;
	}

	public void setCurrent_loged_out_date_time(String current_loged_out_date_time) {
		this.current_loged_out_date_time = current_loged_out_date_time;
	}
	public String getDoctorTypeIdList() {
		return doctorTypeIdList;
	}
	public void setDoctorTypeIdList(String doctorTypeIdList) {
		this.doctorTypeIdList = doctorTypeIdList;
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
	public String getSignOne() {
		return signOne;
	}
	public void setSignOne(String signOne) {
		this.signOne = signOne;
	}
	public String getSignTwo() {
		return signTwo;
	}
	public void setSignTwo(String signTwo) {
		this.signTwo = signTwo;
	}
	public String getSignOneDoctor() {
		return signOneDoctor;
	}
	public void setSignOneDoctor(String signOneDoctor) {
		this.signOneDoctor = signOneDoctor;
	}
	public String getSignTwoDoctor() {
		return signTwoDoctor;
	}
	public void setSignTwoDoctor(String signTwoDoctor) {
		this.signTwoDoctor = signTwoDoctor;
	}

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	@JsonGetter("uName")
	public String getUnit_name() {
		return unit_name;
	}
	@JsonSetter("uName")
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getUsePrepaidCreditAmount() {
		return usePrepaidCreditAmount;
	}

	public void setUsePrepaidCreditAmount(String usePrepaidCreditAmount) {
		this.usePrepaidCreditAmount = usePrepaidCreditAmount;
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

	
	public String getDefaultSignatureflag() {
		return defaultSignatureflag;
	}

	public void setDefaultSignatureflag(String defaultSignatureflag) {
		this.defaultSignatureflag = defaultSignatureflag;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Users [user_ID=" + user_ID + ", full_name=" + full_name + ", title=" + title + ", unit_name="
				+ unit_name + ", f_name=" + f_name + ", m_name=" + m_name + ", l_name=" + l_name + ", user_Name="
				+ user_Name + ", user_Type=" + user_Type + ", password=" + password + ", created_Date=" + created_Date
				+ ", availability=" + availability + ", status=" + status + ", usersList=" + usersList + ", doc_id="
				+ doc_id + ", userFor=" + userFor + ", collectedAt=" + collectedAt + ", doc_name=" + doc_name
				+ ", objDoctor=" + objDoctor + ", last_loged_in_date_time=" + last_loged_in_date_time
				+ ", last_loged_out_date_time=" + last_loged_out_date_time + ", current_loged_in_date_time="
				+ current_loged_in_date_time + ", current_loged_out_date_time=" + current_loged_out_date_time
				+ ", softwareUsed=" + softwareUsed + ", signOne=" + signOne + ", signOneDoctor=" + signOneDoctor
				+ ", signTwo=" + signTwo + ", signTwoDoctor=" + signTwoDoctor + ", hrms_emp_flag=" + hrms_emp_flag
				+ ", lookupDetIdTtl=" + lookupDetIdTtl + ", rowCount=" + rowCount + ", usePrepaidCreditAmount="
				+ usePrepaidCreditAmount + ", dcTypeMasterID=" + dcTypeMasterID + ", mulSelunit=" + mulSelunit
				+ ", doctorTypeIdList=" + doctorTypeIdList + ", mulDeptid=" + mulDeptid + ", mulServiceid="
				+ mulServiceid + ", adminServiceid=" + adminServiceid + ", empIdhr=" + empIdhr + ", customerType="
				+ customerType + ", customerId=" + customerId + ", inhouseLabId=" + inhouseLabId
				+ ", userCustomersList=" + userCustomersList +",b2bAndB2cQueueAcces=" + b2bAndB2cQueueAcces +"]";
	}

	
}
