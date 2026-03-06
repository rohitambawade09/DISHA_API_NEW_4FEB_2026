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
@Table(name = "ehat_unit_master")
public class UnitMasterDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "unit_id")
	private Integer unitId;

	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "unit_code")
	private String unitCode;
	
	@Column(name = "barcode_type")
	private Integer barcode_type;
	
	@Column(name = "signature_reflection")
	private String signatureReflection;
	
	@Column(name = "lookup_det_id_unit_type")
	private Integer lookupDetIdUnitType;
	
	@Column(name = "lookup_det_id_sub_unit_type")
	private Integer lookupDetIdSubUnitType;
	
	@Column(name = "mapped_project_id")
	private String mappedProjectId;
	
	@Column(name="unit_for",nullable = true)
	private Integer unitFor;

	@Column(name = "created_by",updatable=false)
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "deleted_by")
	private Integer deletedBy;

	@Column(name = "deleted")
	private String deleted="N";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time",updatable=false)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date_time")
	private Date updatedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date_time")
	private Date deletedDate;
	
	@Column(name = "resulting_lab")
	private String resultingLab;
	
	@Column(name = "sending_facility_id")
	private String sendingFacilityId;
	
	@Column(name = "runner_boy")
	private String runnerBoy;
	
	@Column(name = "email_typeid")
	private String emailTypeId;
	
	@Column(name = "email_minutes")
	private Integer emailMinutes;

	@Column(name = "auto_send_processFlag")
	private String autoSendProcessFlag;
	
	@Column(name = "report_flag")
	private String reportFlag="N";
	
	@Column(name = "footer_text")
	private String footerText;
	
	@Column(name = "mail_flag")
	private String mailFlag;
	
	@Column(name = "whatsapp_scheduler_type")
	private String whatsappSchedulerType;
	
	@Column(name = "whatsapp_scheduler_time")
	private String whatsappSchedulerTime;
	
	@Column(name = "whatsApp_flag")
	private String whatsAppFlag;

	@Column(name = "continuous_report_flag")
	private String contineousReportFlag="N";

	@Column(name = "sms_mail_send_flag")
	private Integer smsMailSendFlag;

	@Column(name = "lookup_det_id_histo_header")
	private Integer lookupDetIdHistoHeader;
	
	@Column(name = "credit_limit_type")
	private Integer creditLimitType;

	@Column(name = "b2b_payment_method")
	private String b2bPaymentMethod="N";
	
	@Column(name = "outsource_tab_flag")
	private String outsourceTabFlag;
	
	@Column(name = "generate_receipt_rate")
	private Integer generateReceiptRate=1;
	
	@Column(name="upload_document_flag")
	private String uploadDocumentFlag="N";
	
	@Column(name = "nabl_logo_flag")
	private Integer nablLogoFlag=1;
	
	@Column(name = "disclaimer_chk")
	private String disclaimerChk="N";
	
	@Column(name = "disclaimer_text")
	private String disclaimerText="-";
	
	@Column(name = "show_auth_page_data_flag")
	private String showAuthPageDataFlag;
	
	@Column(name = "lookup_det_id_barcode_type")
	private Integer lookupDetIdBarcodeype;
	
	@Transient
	private String mappedProjects;
	
	@Transient
	private Integer lookupDetId;

	@Transient
	private List<UnitMasterDto> lstUnit;
	
	@Transient
	private String lookbarcodeTCode;
	
	@Transient
	private List<TmCmLookupDet> TmCmLookupDetLookupList;

	public List<UnitMasterDto> getLstUnit() {
		return lstUnit;
	}

	public void setLstUnit(List<UnitMasterDto> lstUnit) {
		this.lstUnit = lstUnit;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer userId) {
		this.createdBy = userId;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public String getResultingLab() {
		return resultingLab;
	}

	public void setResultingLab(String resultingLab) {
		this.resultingLab = resultingLab;
	}

	public String getSendingFacilityId() {
		return sendingFacilityId;
	}

	public void setSendingFacilityId(String sendingFacilityId) {
		this.sendingFacilityId = sendingFacilityId;
	}
	
	public List<TmCmLookupDet> getTmCmLookupDetLookupList() {
		return TmCmLookupDetLookupList;
	}
	
	public void setTmCmLookupDetLookupList(List<TmCmLookupDet> tmCmLookupDetLookupList) {
		TmCmLookupDetLookupList = tmCmLookupDetLookupList;
	}

	public String getRunnerBoy() {
		return runnerBoy;
	}

	public void setRunnerBoy(String runnerBoy) {
		this.runnerBoy = runnerBoy;
	}

	public Integer getBarcode_type() {
		return barcode_type;
	}

	public void setBarcode_type(Integer barcode_type) {
		this.barcode_type = barcode_type;
	}

	public String getSignatureReflection() {
		return signatureReflection;
	}

	public void setSignatureReflection(String signatureReflection) {
		this.signatureReflection = signatureReflection;
	}

	public Integer getLookupDetId() {
		return lookupDetId;
	}

	public void setLookupDetId(Integer lookupDetId) {
		this.lookupDetId = lookupDetId;
	}

	public Integer getLookupDetIdUnitType() {
		return lookupDetIdUnitType;
	}

	public void setLookupDetIdUnitType(Integer lookupDetIdUnitType) {
		this.lookupDetIdUnitType = lookupDetIdUnitType;
	}

	public Integer getLookupDetIdSubUnitType() {
		return lookupDetIdSubUnitType;
	}

	public void setLookupDetIdSubUnitType(Integer lookupDetIdSubUnitType) {
		this.lookupDetIdSubUnitType = lookupDetIdSubUnitType;
	}

	public String getMappedProjectId() {
		return mappedProjectId;
	}

	public void setMappedProjectId(String mappedProjectId) {
		this.mappedProjectId = mappedProjectId;
	}

	public String getMappedProjects() {
		return mappedProjects;
	}

	public void setMappedProjects(String mappedProjects) {
		this.mappedProjects = mappedProjects;
	}

	public Integer getUnitFor() {
		return unitFor;
	}

	public void setUnitFor(Integer unitFor) {
		this.unitFor = unitFor;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getEmailTypeId() {
		return emailTypeId;
	}

	public void setEmailTypeId(String emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	public Integer getEmailMinutes() {
		return emailMinutes;
	}

	public void setEmailMinutes(Integer emailMinutes) {
		this.emailMinutes = emailMinutes;
	}

	public String getAutoSendProcessFlag() {
		return autoSendProcessFlag;
	}

	public void setAutoSendProcessFlag(String autoSendProcessFlag) {
		this.autoSendProcessFlag = autoSendProcessFlag;
	}

	public String getReportFlag() {
		return reportFlag;
	}

	public void setReportFlag(String reportFlag) {
		this.reportFlag = reportFlag;
	}

	public String getFooterText() {
		return footerText;
	}

	public void setFooterText(String footerText) {
		this.footerText = footerText;
	}

	public String getMailFlag() {
		return mailFlag;
	}

	public void setMailFlag(String mailFlag) {
		this.mailFlag = mailFlag;
	}

	public String getWhatsappSchedulerType() {
		return whatsappSchedulerType;
	}

	public void setWhatsappSchedulerType(String whatsappSchedulerType) {
		this.whatsappSchedulerType = whatsappSchedulerType;
	}

	public String getWhatsappSchedulerTime() {
		return whatsappSchedulerTime;
	}

	public void setWhatsappSchedulerTime(String whatsappSchedulerTime) {
		this.whatsappSchedulerTime = whatsappSchedulerTime;
	}

	public String getWhatsAppFlag() {
		return whatsAppFlag;
	}

	public void setWhatsAppFlag(String whatsAppFlag) {
		this.whatsAppFlag = whatsAppFlag;
	}

	public String getContineousReportFlag() {
		return contineousReportFlag;
	}

	public void setContineousReportFlag(String contineousReportFlag) {
		this.contineousReportFlag = contineousReportFlag;
	}

	public Integer getSmsMailSendFlag() {
		return smsMailSendFlag;
	}

	public void setSmsMailSendFlag(Integer smsMailSendFlag) {
		this.smsMailSendFlag = smsMailSendFlag;
	}

	public Integer getLookupDetIdHistoHeader() {
		return lookupDetIdHistoHeader;
	}

	public void setLookupDetIdHistoHeader(Integer lookupDetIdHistoHeader) {
		this.lookupDetIdHistoHeader = lookupDetIdHistoHeader;
	}

	public Integer getCreditLimitType() {
		return creditLimitType;
	}

	public void setCreditLimitType(Integer creditLimitType) {
		this.creditLimitType = creditLimitType;
	}

	public String getB2bPaymentMethod() {
		return b2bPaymentMethod;
	}

	public void setB2bPaymentMethod(String b2bPaymentMethod) {
		this.b2bPaymentMethod = b2bPaymentMethod;
	}

	public String getOutsourceTabFlag() {
		return outsourceTabFlag;
	}

	public void setOutsourceTabFlag(String outsourceTabFlag) {
		this.outsourceTabFlag = outsourceTabFlag;
	}

	public Integer getGenerateReceiptRate() {
		return generateReceiptRate;
	}

	public void setGenerateReceiptRate(Integer generateReceiptRate) {
		this.generateReceiptRate = generateReceiptRate;
	}

	public String getUploadDocumentFlag() {
		return uploadDocumentFlag;
	}

	public void setUploadDocumentFlag(String uploadDocumentFlag) {
		this.uploadDocumentFlag = uploadDocumentFlag;
	}

	public Integer getNablLogoFlag() {
		return nablLogoFlag;
	}

	public void setNablLogoFlag(Integer nablLogoFlag) {
		this.nablLogoFlag = nablLogoFlag;
	}

	public String getDisclaimerChk() {
		return disclaimerChk;
	}

	public void setDisclaimerChk(String disclaimerChk) {
		this.disclaimerChk = disclaimerChk;
	}

	public String getDisclaimerText() {
		return disclaimerText;
	}

	public void setDisclaimerText(String disclaimerText) {
		this.disclaimerText = disclaimerText;
	}

	public String getShowAuthPageDataFlag() {
		return showAuthPageDataFlag;
	}

	public void setShowAuthPageDataFlag(String showAuthPageDataFlag) {
		this.showAuthPageDataFlag = showAuthPageDataFlag;
	}

	public Integer getLookupDetIdBarcodeype() {
		return lookupDetIdBarcodeype;
	}

	public void setLookupDetIdBarcodeype(Integer lookupDetIdBarcodeype) {
		this.lookupDetIdBarcodeype = lookupDetIdBarcodeype;
	}

	public String getLookbarcodeTCode() {
		return lookbarcodeTCode;
	}

	public void setLookbarcodeTCode(String lookbarcodeTCode) {
		this.lookbarcodeTCode = lookbarcodeTCode;
	}
	
}