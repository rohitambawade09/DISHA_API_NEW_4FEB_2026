package com.disha.hms.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "pathology_sample_wise_slave")
public class PathologySampleWiseSlave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer sampleWiseSlaveId;	
	
	@Column(name = "profile_Id")
	private Integer profileId;
	
	@Column(name = "package_id")
	private Integer packageId = 0;
   
	@Column(name = "test_id")
	private Integer testid;	
	@Column(name = "test_flag")	
	private String testflag = "N";
	@Column(name = "test_result")	
	private String testResult;
	
	@Column(name = "patient_id")
	private Integer patientId;	
	
	@Column(name = "treatment_id")
	private Integer treatmentId;	
	
	@Column(name = "unit_id")
	private Integer unitId;		
	
	@Column(name = "test_reason",columnDefinition="LONGTEXT")	
	private String testReason;
	
	@Column(name = "flag_mark")	
	private String flagMark;

	@Column(name = "re_collection_reason")	
	private String recollectionreason;
	
	@Column(name = "reject_test_reason")	
	private Integer rejectTestReason;
	
	@Column(name = "unReject_test_reason")	
	private Integer unRejectTestReason;
	
	@Column(name = "re_collection")	
	private String recollection = "N";
	
	@Column(name = "expression")	
	private String expression;
	
	@Column(name = "re_run_result")	
	private String reRunResult;
	
	@Column(name = "re_run_flag")	
	private String reRunFlag="N";
	
	@Column(name = "collection_date")
	private String collectionDate="";	
	
	@Column(name = "collection_time")
	private String collectionTime="";
	
	@Column(name="reg_ref_doc_id")
	private Integer regRefDocId;
	
	@Column(name = "profile_name", columnDefinition="LONGTEXT")
	private String profileName;


	@Column(name = "template_data", columnDefinition="LONGTEXT")
	private String templateData;
	
	@Column(name = "template_id", columnDefinition="int(11) default 0")
	private Integer templateId;
	
	@Column(name = "template_name", columnDefinition="TEXT")
	private String templateName;

	// Column added by ROHIT AMBAWADE on 2 Dec 2021
	@Column(name = "api_check",columnDefinition="varchar(1) default 'N' ")
	private String apiCheck = "N";

	@Column(name = "nabl")
	private String nabl = "N";
	

	//added by ROHIT for TIcket ID 1041
	@Column(name="temp_result_chk")
	private String tempResultChk="N";

	@Column(name="temp_result")
	private String tempResult="NA";

	@Column(name="temp_result_id")
	private Integer tempResultId=0;
	
	@Column(name="machine_name")
	private String machineName;
	
	@Column(name="machine_id")
	private Integer machineId;
	
	// ===========================================
	
	
	public String getReRunFlag() {
		return reRunFlag;
	}
	public void setReRunFlag(String reRunFlag) {
		this.reRunFlag = reRunFlag;
	}
	public String getReRunResult() {
		return reRunResult;
	}
	public void setReRunResult(String reRunResult) {
		this.reRunResult = reRunResult;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getRecollectionreason() {
		return recollectionreason;
	}
	public void setRecollectionreason(String recollectionreason) {
		this.recollectionreason = recollectionreason;
	}
	public String getRecollection() {
		return recollection;
	}
	public void setRecollection(String recollection) {
		this.recollection = recollection;
	}
	public Integer getRejectTestReason() {
		return rejectTestReason;
	}
	public void setRejectTestReason(Integer rejectTestReason) {
		this.rejectTestReason = rejectTestReason;
	}
	public Integer getUnRejectTestReason() {
		return unRejectTestReason;
	}
	public void setUnRejectTestReason(Integer unRejectTestReason) {
		this.unRejectTestReason = unRejectTestReason;
	}
	public String getTestReason() {
		return testReason;
	}
	public void setTestReason(String testReason) {
		this.testReason = testReason;
	}
	public String getFlagMark() {
		return flagMark;
	}
	public void setFlagMark(String flagMark) {
		this.flagMark = flagMark;
	}
	
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	@Column(name = "created_by",updatable=false)
	private Integer createdBy;	
	@Column(name = "updated_by")
	private Integer updatedBy;	
	@CreationTimestamp
	@Column(name = "created_date_time",updatable=false)
	private Date createDate;
	@UpdateTimestamp
	@Column(name = "updated_date_time")
	private Date updatedDate;	
	
	@Column(name = "sample_type_id",columnDefinition="int default 0")
	private Integer sampleTypeId=0;
	
	@Column(name = "bar_code",columnDefinition="int default 0")
	private String barCode="";
	
	@Column(name = "in_out_house",columnDefinition="int default 0")
	private Integer inOutHouse=0;
	
	// ===========================================================================
	// Added column for Ticket ID 667
	// ===========================================================================
	@Column(name="organ_id", columnDefinition="int DEFAULT '0'")
	private Integer organ_id = 0;	
	
	@Column(name = "test_name", columnDefinition="LONGTEXT")
	private String testnameee;
	
	@Column(name = "testresultt_new", columnDefinition="LONGTEXT")
	private String testresultt_new;
	
	@Column(name = "normal_values", columnDefinition="LONGTEXT")
	private String normalValues;
	
	@Column(name = "testunit_names", columnDefinition="LONGTEXT")
	private String testunitNames;
	
	@Column(name = "method_name", columnDefinition="LONGTEXT")
	private String methodName;
	
	@Column(name = "test_comments", columnDefinition="LONGTEXT")
	private String testComments;
	
	@Column(name = "biologicalreferenceinterval", columnDefinition="LONGTEXT")
	private String biologicalreferenceinterval;
	
	@Column(name = "oranism_test", columnDefinition="varchar(2) default 'N'")
	private String isOrganismTest="N";

	@Transient
	private Integer slaveIdd;
	
	@Transient
	private String barcodeId;

	@Transient
	private String callBackComment;

	@Transient
	private List<PathologySampleWiseSlave> pathologySampleWiseSlaveList;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
	private PathologySampleWiseMaster pathologySampleWiseMaster;
	
	public Integer getSampleWiseSlaveId() {
		return sampleWiseSlaveId;
	}
	public void setSampleWiseSlaveId(Integer sampleWiseSlaveId) {
		this.sampleWiseSlaveId = sampleWiseSlaveId;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public Integer getTestid() {
		return testid;
	}
	public void setTestid(Integer testid) {
		this.testid = testid;
	}
	public String getTestflag() {
		return testflag;
	}
	public void setTestflag(String testflag) {
		this.testflag = testflag;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public Integer getSampleTypeId() {
		return sampleTypeId;
	}
	public void setSampleTypeId(Integer sampleTypeId) {
		this.sampleTypeId = sampleTypeId;
	}
	
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public Integer getInOutHouse() {
		return inOutHouse;
	}
	public void setInOutHouse(Integer inOutHouse) {
		this.inOutHouse = inOutHouse;
	}
	public List<PathologySampleWiseSlave> getPathologySampleWiseSlaveList() {
		return pathologySampleWiseSlaveList;
	}
	public void setPathologySampleWiseSlaveList(
			List<PathologySampleWiseSlave> pathologySampleWiseSlaveList) {
		this.pathologySampleWiseSlaveList = pathologySampleWiseSlaveList;
	}
	public String getBarcodeId() {
		return barcodeId;
	}
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getTreatmentId() {
		return treatmentId;
	}
	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}
	@Transient
	private int masterIdd;

	public int getMasterIdd() {
		return masterIdd;
	}
	public void setMasterIdd(int masterIdd) {
		this.masterIdd = masterIdd;
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
	public Integer getRegRefDocId() {
		return regRefDocId;
	}
	public void setRegRefDocId(Integer regRefDocId) {
		this.regRefDocId = regRefDocId;
	}
	public String getTemplateData() {
		return templateData;
	}
	public void setTemplateData(String templateData) {
		this.templateData = templateData;
	}
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	public String getApiCheck() {
		return apiCheck;
	}
	public void setApiCheck(String apiCheck) {
		this.apiCheck = apiCheck;
	}
	public String getCallBackComment() {
		return callBackComment;
	}
	public void setCallBackComment(String callBackComment) {
		this.callBackComment = callBackComment;
	}
	public String getNabl() {
		return nabl;
	}
	public void setNabl(String nabl) {
		this.nabl = nabl;
	}
	public Integer getOrgan_id() {
		return organ_id;
	}
	public void setOrgan_id(Integer organ_id) {
		this.organ_id = organ_id;
	}
	public String getTestnameee() {
		return testnameee;
	}
	public void setTestnameee(String testnameee) {
		this.testnameee = testnameee;
	}
	public String getTestresultt_new() {
		return testresultt_new;
	}
	public void setTestresultt_new(String testresultt_new) {
		this.testresultt_new = testresultt_new;
	}
	public String getNormalValues() {
		return normalValues;
	}
	public void setNormalValues(String normalValues) {
		this.normalValues = normalValues;
	}
	public String getTestunitNames() {
		return testunitNames;
	}
	public void setTestunitNames(String testunitNames) {
		this.testunitNames = testunitNames;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getTestComments() {
		return testComments;
	}
	public void setTestComments(String testComments) {
		this.testComments = testComments;
	}
	public String getBiologicalreferenceinterval() {
		return biologicalreferenceinterval;
	}
	public void setBiologicalreferenceinterval(String biologicalreferenceinterval) {
		this.biologicalreferenceinterval = biologicalreferenceinterval;
	}
	public String getIsOrganismTest() {
		return isOrganismTest;
	}
	public void setIsOrganismTest(String isOrganismTest) {
		this.isOrganismTest = isOrganismTest;
	}
	public Integer getSlaveIdd() {
		return slaveIdd;
	}
	public void setSlaveIdd(Integer slaveIdd) {
		this.slaveIdd = slaveIdd;
	}
	public String getTempResultChk() {
		return tempResultChk;
	}
	public void setTempResultChk(String tempResultChk) {
		this.tempResultChk = tempResultChk;
	}
	public String getTempResult() {
		return tempResult;
	}
	public void setTempResult(String tempResult) {
		this.tempResult = tempResult;
	}
	public Integer getTempResultId() {
		return tempResultId;
	}
	public void setTempResultId(Integer tempResultId) {
		this.tempResultId = tempResultId;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public Integer getMachineId() {
		return machineId;
	}
	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}
	public PathologySampleWiseMaster getPathologySampleWiseMaster() {
		return pathologySampleWiseMaster;
	}
	public void setPathologySampleWiseMaster(PathologySampleWiseMaster pathologySampleWiseMaster) {
		this.pathologySampleWiseMaster = pathologySampleWiseMaster;
	}	
	
}
