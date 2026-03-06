package com.disha.hms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "ehat_treatment")
public class TreatmentDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "treatment_id")
	private Integer treatmentId;
	
	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "doctor_id")
	private String doctorIdList;
	
	@Column(name = "appointment_id",columnDefinition="int default 0")
	private int appointmentId=0;
	
	@Column(name = "token",columnDefinition="int default 0")
	private int token=0;
	
	@Column(name = "t_flag",columnDefinition="varchar(2) default 'N'")
	private String tFlag="N";
	
	@Column(name = "unit_id",columnDefinition="int default 1")
	private int unitId=1;
	
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

	@Column(name = "ref_doc_id")
	private int refDocId=0;
	
	@Column(name = "case_type",columnDefinition="int default 1")
	private int caseType=1;
	
	@Column(name = "weight",columnDefinition="double(255) default 0")
	private double weight;
	
	@Column(name = "height",columnDefinition="double(255) default 0")
	private double height;
	
	@Column(name = "notes",columnDefinition="varchar(255) default '-'")
	private String notes="-";
	
	@Column(name = "empid",columnDefinition="varchar(255) default '-'")
	private String empid="";
	
	@Column(name = "count")
	private int count=1;
	
	@Column(name = "trcount")
	private String trcount="0";
	
	@Column(name = "opdipdno")
	private String opdipdno="0";
	
	@Column(name = "tpaid",columnDefinition="varchar(255) default '-'")
	private String tpaid="-";
	 
	@Column(name = "BMI",columnDefinition="double default 0")
	private double BMI=0;
	
	@Column(name = "BSA",columnDefinition="double default 0")
	private double BSA=0;
	
	@Column(name = "HCIM",columnDefinition="double default 0")
	private double HCIM=0;
	
	@Column(name = "cancel_narration")
	private String cancelNarration="-";
	
	@Column(name = "adm_cancel_flag")
	private String admCancelFlag="N";
	
	@Column(name = "refer_source",columnDefinition="int default 0")
	private int refersource=0;
	
	
	@Column(name = "emergency_flag",columnDefinition="varchar(2) default 'N'")
	private String emergencyFlag="N";//added by dayanand(3-8-2020)

	//@Lob
	@Column(name = "patient_history", columnDefinition="LONGTEXT")
	private String patientHistory="";
	
	public int getRefersource() {
		return refersource;
	}

	public void setRefersource(int refersource) {
		this.refersource = refersource;
	}

	@Column(name = "business_type",columnDefinition="int default 0")
	private Integer businessType=0;
	
	@Column(name = "customer_type",columnDefinition="int default 0")
	private Integer customerType=0;
	
	@Column(name = "customer_id",columnDefinition="int default 0")
	private Integer customerId=0;
	
	
	@Column(name = "special_Case")
	private String specialCase="0";
	
	@Column(name = "gestational_age")
	private int gestationalAge=0;
	
	@Column(name = "urine_vol")
	private String urineVol="0";
	
	@Column(name = "lmp_date")
	private String lmpDate="";
	/*@Column(name = "tokencount")
	private int tokencount=1;
	*/
	@Column(name = "tokenno")
	private String tokenno="0";
	
	@Column(name = "reqGenFormId")
	private int reqGenFormId=0;
	
	@Column(name = "referred_by")
	private String referredBy;
	
	@Column(name = "referred_source")
	private Integer referredSource=0;
	
	@Column(name = "referred_source_slave")
	private String referredSourceSlave="";
	
	@Column(name = "referred_source_docId")
	private Integer referredSourceDocId=0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ref_date")
	private Date refDate;
	
	@Column(name = "saction_ord_no",columnDefinition="varchar(100) default '0'")
	private String sactionOrdNo="0";
	
	@Column(name = "sanction_amt",columnDefinition="double default 0")
	private double sanctionAmt=0;
	
	@Column(name = "neis_no",columnDefinition="varchar(100) default '0'")
	private String neisNo="0";
	
	@Column(name = "visit_no",columnDefinition="varchar(100) default '0'")
	private String visitNo="0";
	
	@Column(name = "ipd_or_opd",columnDefinition="varchar(100) default '-'")
	private String ipdOrOpd="0";
	
	@Column(name = "treat_permited",columnDefinition="TEXT default NULL")
	private String treatPermited="0";
	
	@Column(name = "dise_to_be_treat",columnDefinition="TEXT default NULL")
	private String diseToBeTreat="0";
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valid_upto_date")
	private Date validUpToDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "admsn_can_date_time")
	private Date admissionCanDateTime;
	
	@Column(name = "admsn_canceled_by")
	private Integer admissionCanceledBy;
	
	@Column(name = "admission_date_time")
	private String admissionDateTime="";
	
	@Column(name = "ref_doctor_name",columnDefinition="varchar(255) default '-'")
	private String refDoctorName="-";

	@Transient
	private String patientName="";
	
	@Transient
	private String userName="";
	
	@Temporal(TemporalType.DATE)
	@Transient
	private Date cancelDate;
	
	@Temporal(TemporalType.TIME)
	@Transient
	private Date cancelTime;
	
	//Here L&T fields added 21-mar-2019
	
	@Column(name = "radio_patient_type",columnDefinition="varchar(2) default 'C'")
	private String radioPatientType="C";
	
	@Column(name = "radio_self_relative",columnDefinition="varchar(2) default 'N'")
	private String radioSelfRelative="N";
	
	@Column(name = "radio_present_retired",columnDefinition="varchar(2) default 'N'")
	private String radioPresentRetired="N";
	
	@Column(name = "collection_date")
	private String collectionDate;
	
	@Column(name = "collection_time")
	private String collectionTime;
	
	@Column(name = "b2b_patient_id")
	private String b2bPatientId;
	
	@Column(name = "doctor_mobile_number")
	private String doctorMobileNo;
	
	@Column(name = "connecting_flight", columnDefinition="varchar(2) default 'N'")
	private String connectingFlight = "";

	@Column(name = "opt_destination_city")
	private String optDestinationCity="";
	
	@Column(name = "flight_departure_date", columnDefinition="varchar(45)")
	private String flightDepartureDate="";
	
	@Column(name = "flight_departure_time", columnDefinition="varchar(45)")
	private String flightDepartureTime="";

	@Column(name = "destination_city")
	private String destinationCity="";
	
	@Column(name = "city_of_origin")
	private String cityOfOrigin="";
	
	@Column(name = "patient_barcode", columnDefinition="varchar(15)")
	private String patientBarcode="";
	
	@Column(name = "registered_at", columnDefinition="varchar(15)")
	private String registeredAt="other";
	
	@Column(name = "network_api_chk")
	private String networkApiChk="N";
	
	@Column(name = "external_patient_id", columnDefinition="varchar(15) default '-'")
	private String externalPatientId="-";
	
	@Column(name = "vip_status", columnDefinition="varchar(2) default 'N'")
	private String vipStatus="N";
	
	@Column(name = "transaction_id")
	private String transactionId="-";
	
	@Column(name = "bill_category")
	private String billCategory="-";
	
	@Column(name = "source_from")
	private Integer sourceFrom;
	
	@Column(name = "hmis_api_flag")
	private String hmisApiFlag="N";
	
	@Column(name = "visit_code")
	private String visitCode="";
	
	@Column(name = "camp_id")
	private String campId="";
	
	@Column(name = "camp_close_flag")
	private String campCloseFlag="N";
	
	@Transient
	private List<TreatmentDto> listTreatment;

 	public String getTokenno() {
		return tokenno;
	}

	public void setTokenno(String tokenno) {
		this.tokenno = tokenno;
	}

	public double getBMI() {
		return BMI;
	}

	public void setBMI(double bMI) {
		BMI = bMI;
	}

	public double getBSA() {
		return BSA;
	}

	public void setBSA(double bSA) {
		BSA = bSA;
	}

	public double getHCIM() {
		return HCIM;
	}

	public void setHCIM(double hCIM) {
		HCIM = hCIM;
	}

	public String getTpaid() {
		return tpaid;
	}

	public void setTpaid(String tpaid) {
		this.tpaid = tpaid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTrcount() {
		return trcount;
	}

	public void setTrcount(String trcount) {
		this.trcount = trcount;
	}

	public String getOpdipdno() {
		return opdipdno;
	}

	public void setOpdipdno(String opdipdno) {
		this.opdipdno = opdipdno;
	}

	public Integer getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDoctorIdList() {
		return doctorIdList;
	}

	public void setDoctorIdList(String doctorIdList) {
		this.doctorIdList = doctorIdList;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public String gettFlag() {
		return tFlag;
	}

	public void settFlag(String tFlag) {
		this.tFlag = tFlag;
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

	public List<TreatmentDto> getListTreatment() {
		return listTreatment;
	}

	public void setListTreatment(List<TreatmentDto> listTreatment) {
		this.listTreatment = listTreatment;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getRefDocId() {
		return refDocId;
	}

	public void setRefDocId(int refDocId) {
		this.refDocId = refDocId;
	}

	 

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getCaseType() {
		return caseType;
	}

	public void setCaseType(int caseType) {
		this.caseType = caseType;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public int getReqGenFormId() {
		return reqGenFormId;
	}

	public void setReqGenFormId(int reqGenFormId) {
		this.reqGenFormId = reqGenFormId;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public Integer getReferredSource() {
		return referredSource;
	}

	public void setReferredSource(Integer referredSource) {
		this.referredSource = referredSource;
	}

	public String getReferredSourceSlave() {
		return referredSourceSlave;
	}

	public void setReferredSourceSlave(String referredSourceSlave) {
		this.referredSourceSlave = referredSourceSlave;
	}

	public Integer getReferredSourceDocId() {
		return referredSourceDocId;
	}

	public void setReferredSourceDocId(Integer referredSourceDocId) {
		this.referredSourceDocId = referredSourceDocId;
	}

	public String getCancelNarration() {
		return cancelNarration;
	}

	public void setCancelNarration(String cancelNarration) {
		this.cancelNarration = cancelNarration;
	}

	public String getAdmCancelFlag() {
		return admCancelFlag;
	}

	public void setAdmCancelFlag(String admCancelFlag) {
		this.admCancelFlag = admCancelFlag;
	}

	//Added By Pooja
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "phy_date_time")
	private Date phyDateTime;

	@Column(name = "phydis_flag")
	private String phyDisFlag="N";
	
	public String getPhyDisFlag() {
		return phyDisFlag;
	}

	public void setPhyDisFlag(String phyDisFlag) {
		this.phyDisFlag = phyDisFlag;
	}

	public Date getPhyDateTime() {
		return phyDateTime;
	}

	public void setPhyDateTime(Date phyDateTime) {
		this.phyDateTime = phyDateTime;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public String getSactionOrdNo() {
		return sactionOrdNo;
	}

	public void setSactionOrdNo(String sactionOrdNo) {
		this.sactionOrdNo = sactionOrdNo;
	}

	public double getSanctionAmt() {
		return sanctionAmt;
	}

	public void setSanctionAmt(double sanctionAmt) {
		this.sanctionAmt = sanctionAmt;
	}

	public String getNeisNo() {
		return neisNo;
	}

	public void setNeisNo(String neisNo) {
		this.neisNo = neisNo;
	}

	public String getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(String visitNo) {
		this.visitNo = visitNo;
	}

	public String getIpdOrOpd() {
		return ipdOrOpd;
	}

	public void setIpdOrOpd(String ipdOrOpd) {
		this.ipdOrOpd = ipdOrOpd;
	}

	public String getTreatPermited() {
		return treatPermited;
	}

	public void setTreatPermited(String treatPermited) {
		this.treatPermited = treatPermited;
	}

	public String getDiseToBeTreat() {
		return diseToBeTreat;
	}

	public void setDiseToBeTreat(String diseToBeTreat) {
		this.diseToBeTreat = diseToBeTreat;
	}

	public Date getValidUpToDate() {
		return validUpToDate;
	}

	public void setValidUpToDate(Date validUpToDate) {
		this.validUpToDate = validUpToDate;
	}

	public Date getAdmissionCanDateTime() {
		return admissionCanDateTime;
	}

	public void setAdmissionCanDateTime(Date admissionCanDateTime) {
		this.admissionCanDateTime = admissionCanDateTime;
	}

	public Integer getAdmissionCanceledBy() {
		return admissionCanceledBy;
	}

	public void setAdmissionCanceledBy(Integer admissionCanceledBy) {
		this.admissionCanceledBy = admissionCanceledBy;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getAdmissionDateTime() {
		return admissionDateTime;
	}

	public void setAdmissionDateTime(String admissionDateTime) {
		this.admissionDateTime = admissionDateTime;
	}

	public String getRadioPatientType() {
		return radioPatientType;
	}

	public void setRadioPatientType(String radioPatientType) {
		this.radioPatientType = radioPatientType;
	}

	public String getRadioSelfRelative() {
		return radioSelfRelative;
	}

	public void setRadioSelfRelative(String radioSelfRelative) {
		this.radioSelfRelative = radioSelfRelative;
	}

	public String getRadioPresentRetired() {
		return radioPresentRetired;
	}

	public void setRadioPresentRetired(String radioPresentRetired) {
		this.radioPresentRetired = radioPresentRetired;
	}
	
	
	@Transient
	private String doctorName="";	//jitendra
	
	@Transient
	private String doctorSpecialisation="";	//jitendra
	
	@Transient
	private String doctorPerDayCharge="";	//jitendra
	
	@Transient
	private String doctorTotalDays="";	//jitendra
	
	@Transient
	private String doctorToalAmt="";	//jitendra

	public String getDoctorName() {	//jitendra
		return doctorName;
	}

	public void setDoctorName(String doctorName) {	//jitendra
		this.doctorName = doctorName;
	}

	public String getDoctorSpecialisation() {	//jitendra
		return doctorSpecialisation;
	}

	public void setDoctorSpecialisation(String doctorSpecialisation) {	//jitendra
		this.doctorSpecialisation = doctorSpecialisation;
	}

	public String getDoctorPerDayCharge() {	//jitendra
		return doctorPerDayCharge;
	}

	public void setDoctorPerDayCharge(String doctorPerDayCharge) {	//jitendra
		this.doctorPerDayCharge = doctorPerDayCharge;
	}

	public String getDoctorTotalDays() {	//jitendra
		return doctorTotalDays;
	}

	public void setDoctorTotalDays(String doctorTotalDays) {	//jitendra
		this.doctorTotalDays = doctorTotalDays;
	}

	public String getDoctorToalAmt() {	//jitendra
		return doctorToalAmt;
	}

	public void setDoctorToalAmt(String doctorToalAmt) {	//jitendra
		this.doctorToalAmt = doctorToalAmt;
	}

	public static long getSerialversionuid() {	//jitendra
		return serialVersionUID;
	}
	
	@Transient
	private String doctorAttendanceDate="";	//jitendra
	
	@Transient
	private String doctorCheckupPatientCount="";	//jitendra

	public String getDoctorAttendanceDate() {
		return doctorAttendanceDate;
	}

	public void setDoctorAttendanceDate(String doctorAttendanceDate) {
		this.doctorAttendanceDate = doctorAttendanceDate;
	}

	public String getDoctorCheckupPatientCount() {
		return doctorCheckupPatientCount;
	}

	public void setDoctorCheckupPatientCount(String doctorCheckupPatientCount) {
		this.doctorCheckupPatientCount = doctorCheckupPatientCount;
	}
	
	@Transient
	private String patientTreatmentDateForDetailReport="";	//jitendra
	
	@Transient
	private String patientIdForDetailReport="";	//jitendra
	
	@Transient
	private String patientNameForDetailReport="";	//jitendra
	
	@Transient
	private String patientMobileForDetailReport="";	//jitendra
	
	public String getPatientTreatmentDateForDetailReport() {	//jitendra
		return patientTreatmentDateForDetailReport;
	}

	public void setPatientTreatmentDateForDetailReport(
			String patientTreatmentDateForDetailReport) {	//jitendra
		this.patientTreatmentDateForDetailReport = patientTreatmentDateForDetailReport;
	}

	public String getPatientIdForDetailReport() {	//jitendra
		return patientIdForDetailReport;
	}

	public void setPatientIdForDetailReport(String patientIdForDetailReport) {	//jitendra
		this.patientIdForDetailReport = patientIdForDetailReport;
	}

	public String getPatientNameForDetailReport() {	//jitendra
		return patientNameForDetailReport;
	}

	public void setPatientNameForDetailReport(String patientNameForDetailReport) {	//jitendra
		this.patientNameForDetailReport = patientNameForDetailReport;
	}

	public String getPatientMobileForDetailReport() {	//jitendra
		return patientMobileForDetailReport;
	}

	public void setPatientMobileForDetailReport(String patientMobileForDetailReport) {	//jitendra
		this.patientMobileForDetailReport = patientMobileForDetailReport;
	}	

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public String getSpecialCase() {
		return specialCase;
	}

	public void setSpecialCase(String specialCase) {
		this.specialCase = specialCase;
	}

	public int getGestationalAge() {
		return gestationalAge;
	}

	public void setGestationalAge(int gestationalAge) {
		this.gestationalAge = gestationalAge;
	}

	
	public String getLmpDate() {
		return lmpDate;
	}

	public void setLmpDate(String lmpDate) {
		this.lmpDate = lmpDate;
	}

	public String getUrineVol() {
		return urineVol;
	}

	public void setUrineVol(String urineVol) {
		this.urineVol = urineVol;
	}

	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getEmergencyFlag() {
		return emergencyFlag;
	}

	public void setEmergencyFlag(String emergencyFlag) {
		this.emergencyFlag = emergencyFlag;
	}

	public String getPatientHistory() {
		return patientHistory;
	}

	public void setPatientHistory(String patientHistory) {
		this.patientHistory = patientHistory;
	}
	
	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
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

	public String getPatientBarcode() {
		return patientBarcode;
	}

	public void setPatientBarcode(String patientBarcode) {
		this.patientBarcode = patientBarcode;
	}

	public String getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(String registeredAt) {
		this.registeredAt = registeredAt;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	

	public String getRefDoctorName() {
		return refDoctorName;
	}

	public void setRefDoctorName(String refDoctorName) {
		this.refDoctorName = refDoctorName;
	}
	

	public String getB2bPatientId() {
		return b2bPatientId;
	}

	public void setB2bPatientId(String b2bPatientId) {
		this.b2bPatientId = b2bPatientId;
	}

	public String getDoctorMobileNo() {
		return doctorMobileNo;
	}

	public void setDoctorMobileNo(String doctorMobileNo) {
		this.doctorMobileNo = doctorMobileNo;
	}
	
	public String getNetworkApiChk() {
		return networkApiChk;
	}

	public void setNetworkApiChk(String networkApiChk) {
		this.networkApiChk = networkApiChk;
	}

	public String getExternalPatientId() {
		return externalPatientId;
	}

	public void setExternalPatientId(String externalPatientId) {
		this.externalPatientId = externalPatientId;
	}
	
	public String getVipStatus() {
		return vipStatus;
	}

	public void setVipStatus(String vipStatus) {
		this.vipStatus = vipStatus;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBillCategory() {
		return billCategory;
	}

	public void setBillCategory(String billCategory) {
		this.billCategory = billCategory;
	}

	public Integer getSourceFrom() {
		return sourceFrom;
	}

	public void setSourceFrom(Integer sourceFrom) {
		this.sourceFrom = sourceFrom;
	}

	public String getHmisApiFlag() {
		return hmisApiFlag;
	}

	public void setHmisApiFlag(String hmisApiFlag) {
		this.hmisApiFlag = hmisApiFlag;
	}

	public String getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(String visitCode) {
		this.visitCode = visitCode;
	}

	public String getCampId() {
		return campId;
	}

	public void setCampId(String campId) {
		this.campId = campId;
	}

	public String getCampCloseFlag() {
		return campCloseFlag;
	}

	public void setCampCloseFlag(String campCloseFlag) {
		this.campCloseFlag = campCloseFlag;
	}

	@Override
	public String toString() {
		return "TreatmentDto [treatmentId=" + treatmentId + ", patientId=" + patientId + ", departmentId="
				+ departmentId + ", doctorIdList=" + doctorIdList + ", token=" + token + ", tFlag=" + tFlag
				+ ", unitId=" + unitId + ", deleted=" + deleted + ", createdBy=" + createdBy + ", createdDateTime="
				+ createdDateTime + ", updatedBy=" + updatedBy + ", updatedDateTime=" + updatedDateTime + ", deletedBy="
				+ deletedBy + ", deletedDateTime=" + deletedDateTime + ", refDocId=" + refDocId + ", caseType="
				+ caseType + ", weight=" + weight + ", height=" + height + ", notes=" + notes + ", empid=" + empid
				+ ", count=" + count + ", trcount=" + trcount + ", opdipdno=" + opdipdno + ", tpaid=" + tpaid + ", BMI="
				+ BMI + ", BSA=" + BSA + ", HCIM=" + HCIM + ", cancelNarration=" + cancelNarration + ", admCancelFlag="
				+ admCancelFlag + ", refersource=" + refersource + ", emergencyFlag=" + emergencyFlag
				+ ", patientHistory=" + patientHistory + ", businessType=" + businessType + ", customerType="
				+ customerType + ", customerId=" + customerId + ", specialCase=" + specialCase + ", gestationalAge="
				+ gestationalAge + ", urineVol=" + urineVol + ", lmpDate=" + lmpDate + ", tokenno=" + tokenno
				+ ", reqGenFormId=" + reqGenFormId + ", referredBy=" + referredBy + ", referredSource=" + referredSource
				+ ", referredSourceSlave=" + referredSourceSlave + ", referredSourceDocId=" + referredSourceDocId
				+ ", refDate=" + refDate + ", sactionOrdNo=" + sactionOrdNo + ", sanctionAmt=" + sanctionAmt
				+ ", neisNo=" + neisNo + ", visitNo=" + visitNo + ", ipdOrOpd=" + ipdOrOpd + ", treatPermited="
				+ treatPermited + ", diseToBeTreat=" + diseToBeTreat + ", validUpToDate=" + validUpToDate
				+ ", admissionCanDateTime=" + admissionCanDateTime + ", admissionCanceledBy=" + admissionCanceledBy
				+ ", admissionDateTime=" + admissionDateTime + ", patientName=" + patientName + ", userName=" + userName
				+ ", cancelDate=" + cancelDate + ", cancelTime=" + cancelTime + ", radioPatientType=" + radioPatientType
				+ ", radioSelfRelative=" + radioSelfRelative + ", radioPresentRetired=" + radioPresentRetired
				+ ", collectionDate=" + collectionDate + ", collectionTime=" + collectionTime + ", connectingFlight="
				+ connectingFlight + ", optDestinationCity=" + optDestinationCity + ", flightDepartureDate="
				+ flightDepartureDate + ", flightDepartureTime=" + flightDepartureTime + ", destinationCity="
				+ destinationCity + ", cityOfOrigin=" + cityOfOrigin + ", patientBarcode=" + patientBarcode
				+ ", listTreatment=" + listTreatment + ", phyDateTime=" + phyDateTime + ", phyDisFlag=" + phyDisFlag
				+ ", doctorName=" + doctorName + ", doctorSpecialisation=" + doctorSpecialisation
				+ ", doctorPerDayCharge=" + doctorPerDayCharge + ", doctorTotalDays=" + doctorTotalDays
				+ ", doctorToalAmt=" + doctorToalAmt + ", doctorAttendanceDate=" + doctorAttendanceDate
				+ ", doctorCheckupPatientCount=" + doctorCheckupPatientCount + ", patientTreatmentDateForDetailReport="
				+ patientTreatmentDateForDetailReport + ", patientIdForDetailReport=" + patientIdForDetailReport
				+ ", patientNameForDetailReport=" + patientNameForDetailReport + ", patientMobileForDetailReport="
				+ patientMobileForDetailReport + "]";
	}
}
