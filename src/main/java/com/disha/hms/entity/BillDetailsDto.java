package com.disha.hms.entity;

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
@Table(name = "ehat_bill_details")
public class BillDetailsDto {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_details_id")
	private Integer billDetailsId;
	
	@Column(name = "treatment_id")
	private Integer treatmentId=0;
	
	@Column(name = "patient_id")
	private Integer patienttId=0;
	
	@Column(name = "department_id")
	private Integer departmentId=0;
	
	@Column(name = "business_type",columnDefinition="int default 0")
	private Integer businessType=0;
	
	@Column(name = "customer_type",columnDefinition="int default 0")
	private Integer customerType=0;
	
	@Column(name = "customer_id",columnDefinition="int default 0")
	private Integer customerId=0;
	
	@Column(name = "pay")
	private double pay=0;
	
	@Column(name = "co_pay")
	private double coPay=0;
	
	@Column(name = "paid_flag")
	private String paidFlag="N";

	@Column(name = "bill_id")
	private Integer billId=0;
	
	@Column(name = "doctor_id")
	private int doctorId=0;
	
	//by Default self which is 0
	@Column(name = "source_type_id")
	private int sourceTypeId=0;
	
	@Column(name = "service_id")
	private int serviceId=0;
	
	@Column(name = "sub_service_id")
	private int subServiceId=0;
	
	@Column(name = "rate")
	private double rate=0;
	
	@Column(name = "quantity")
	private double quantity=1;
	
	@Column(name = "concession")
	private double concession=0;
	
	@Column(name = "other_rate")
	private double otherRate=0;
	
	@Column(name = "amount")
	private double amount=0;
	
	@Column(name = "discount")
	private double discount=0;
	
	@Column(name = "deleted")
	private String deleted="N";
	
	@Column(name = "cancle")
	private String cancle="N";
	
	@Column(name = "other_amount")
	private double otherAmount=0;
	
	@Column(name = "other_pay")
	private double otherPay=0;
	
	@Column(name = "other_concession")
	private double otherConcession=0;
	
	@Column(name = "other_co_pay")
	private double otherCoPay=0;
		
	@Column(name = "created_by",updatable=false)
	private Integer createdBy=0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time")
	private Date createdDateTime;

	@Column(name = "updated_by")
	private Integer updatedBy=0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date_time")
	private Date updatedDateTime;

	@Column(name = "deleted_by")
	private Integer deletedBy=0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date_time")
	private Date deletedDateTime;	
	
	@Column(name = "unit_id")
	private int unitId=1;	
	
	@Column(name = "clinical_notes")
	private String clinicalnotes="-";	
	
	@Column(name = "instructions")
	private String instructions="-";	
	
	@Column(name = "urgentflag")
	private String urgentflag="N";
	
	@Column(name = "drdesk_flag")
	private String drdeskflag="N";

	@Column(name = "delete_from")
	private String deleteFrom="-";
	
	@Column(name = "sndtorisflag")
	private String sndToRisFlag="N";
	
	@Column(name = "account_status_opd_diagno")
	private String accountStatusOpdDiagno="N";
	
	@Column(name = "sample_type_id",columnDefinition="int default 0")
	private Integer sampleTypeId=0;
	
	@Column(name = "bar_code",columnDefinition="int default 0")
	private String barCode="";
	
	@Column(name = "referred_source",columnDefinition="int default 0")
	private Integer referredSource=0;

	@Column(name = "in_out_house",columnDefinition="int default 0")
	private Integer inOutHouse=0;
	
	@Column(name = "histopath_lab",columnDefinition = "varchar(2) default 'N'")
	private String histopathLab="N";
	
	@Column(name = "sample_count",columnDefinition="int default 0")
	private Integer sampleCount=0;
	
	@Column(name = "invoice_generated_flag", columnDefinition = "varchar(2) default 'N'")//added by dayanand(23-3-2020)
	private String invoiceGenerateFlag = "N";

	@Column(name = "invoice_remain_amount")//added by vinod(27-3-2020)
	private double invoiceRemainAmount=0;
	
	@Column(name = "prepaid_receipt_id",columnDefinition="int default 0")
	private double prepaidReceiptId=0;
	
	@Column(name = "collection_date")
	private String collectionDate="";	
	
	@Column(name = "collection_time")
	private String collectionTime="";	

	@Column(name = "reg_ref_doc_id")
	private Integer regRefDocId = 0;
	

	@Column(name = "template_wise",columnDefinition="varchar(50) default 'N'")
	private String templateWise="N";
	
	@Column (name="remark")
	private String remark;
	
	@Column(name="b2b_receipt_flag")
	private String b2bReceiptFlag="N";
	
	@Column(name="alternate_test_name")
	private String alternateTestName="-";
	
	@Column(name="pre_credited_flag")
	private String preCreditedFlag="N";
	
	@Column(name="cust_receipt_master_id")
	private Integer custReceiptMasterIid=0;
	
	@Column(name="b2b_payment_flag")
	private String b2bPaymentFlag="N";
	
	@Column (name="deleted_remark")
	private String deletedRemark;
	
	@Column(name = "client_barcode")
	private String clientBarcode;

	@Column(name="parent_utilization_flag")
	private String parentUtilizationFlag="N";

	@Column(name="parent_customer_id")
	private int parentCustomerId=0;

	@Column(name="parent_utilization_amount")
	private double parentUtilizationAmount=0;

	@Column(name="is_2025_barcode")
	private String is2025Barcode="Y";
	
	@Column(name="project_id")
	private Integer projectId;
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getInvoiceRemainAmount() {
		return invoiceRemainAmount;
	}

	public void setInvoiceRemainAmount(double invoiceRemainAmount) {
		this.invoiceRemainAmount = invoiceRemainAmount;
	}
	
	public double getPrepaidReceiptId() {
		return prepaidReceiptId;
	}

	public void setPrepaidReceiptId(double prepaidReceiptId) {
		this.prepaidReceiptId = prepaidReceiptId;
	}

	public String getInvoiceGenerateFlag() {
		return invoiceGenerateFlag;
	}

	public void setInvoiceGenerateFlag(String invoiceGenerateFlag) {
		this.invoiceGenerateFlag = invoiceGenerateFlag;
	}

	@Transient
	private Integer recSlaveId;

	@Transient
	private String callfrom;

	@Transient
	private Integer masterReceiptId;

	@Transient
	private String subservicesname;

	@Transient
	private String iscombination;

	@Column(name = "sponsor_id")
	private Integer sponsorId;	

	@Column(name = "charges_slave_id")
	private Integer chargesSlaveId;
	
	@Column(name = "concession_in_Perc")
	private double concessionOnPerc=0.0;
		
	@Transient
	private String receiptOf;

	//For Professional fees
	@Transient
	private String narrationid;

@Column(name = "r_flag")
	private String rFlag="N";

      
	@Column(name = "narrationid_bill")
	private String narrationidBill="-";
	
	//Added By Tariq
	@Column(name = "emrPer",columnDefinition="double default 0")
	private double emrPer;
	
	//Added by Laxman on 04-March-2018
	@Column(name = "sndtolabflag",columnDefinition="varchar(15) default 'N'")
	private String sndToLabFlag="N";
	//For Professional fees

	@Transient
	private String sendToRisFlag;
	
	//added by irfan 12-sep-2018
	
	@Transient
	private Integer opdIpdNo;
	
	@Transient
	private String patientName;
	
	@Transient
	private Integer age;
	
	@Transient
	private String gender;
	
	@Transient
	private String serviceName;
	
	@Transient
	private String subServiceName;
	
	@Transient
	private String doctorName;
	
	@Transient
	private double parentuUtilizeAmount;
	
	@Transient
	private List<BillDetailsDto> listBillDetails;
	
	@Column(name = "paid_by_cash_flag",columnDefinition="varchar(2) default 'N'")
	private String paidByCashFlag="N";	
	
	@Column(name = "canceled_by",columnDefinition="int default 0")
	private double canceledBy=0;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "canceled_date_time")
	private Date canceledDateTime;
	

	//Added by ROHIT on 8JUNE 2022
	@Column(name = "sendtohistoflag",columnDefinition="varchar(15) default 'N'")
	private String sendtohistoflag="N";
	
	// added by ROHIT for the B2B disocunt flow
	@Column(name="b2b_now_pay")
	private Double b2bNowPay=0.0;

	@Column(name="b2b_disocunt")
	private Double b2bDisocunt=0.0;

	@Column(name="b2b_disocunt_per")
	private Double b2bDisocuntPer=0.0;

	@Column(name="b2b_authorized_by")
	private Integer b2bAuthorizedBy=0;
	// ========================================
	
		
	public double getCanceledBy() {
		return canceledBy;
	}

	public void setCanceledBy(double canceledBy) {
		this.canceledBy = canceledBy;
	}

	public Date getCanceledDateTime() {
		return canceledDateTime;
	}

	public void setCanceledDateTime(Date canceledDateTime) {
		this.canceledDateTime = canceledDateTime;
	}

	public String getPaidByCashFlag() {
		return paidByCashFlag;
	}

	public void setPaidByCashFlag(String paidByCashFlag) {
		this.paidByCashFlag = paidByCashFlag;
	}

	public Integer getBillDetailsId() {
		return billDetailsId;
	}

	public void setBillDetailsId(Integer billDetailsId) {
		this.billDetailsId = billDetailsId;
	}

	public Integer getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Integer getPatienttId() {
		return patienttId;
	}

	public void setPatienttId(Integer patienttId) {
		this.patienttId = patienttId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public double getCoPay() {
		return coPay;
	}

	public void setCoPay(double coPay) {
		this.coPay = coPay;
	}

	public String getPaidFlag() {
		return paidFlag;
	}

	public void setPaidFlag(String paidFlag) {
		this.paidFlag = paidFlag;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getSourceTypeId() {
		return sourceTypeId;
	}

	public void setSourceTypeId(int sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getSubServiceId() {
		return subServiceId;
	}

	public void setSubServiceId(int subServiceId) {
		this.subServiceId = subServiceId;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getConcession() {
		return concession;
	}

	public void setConcession(double concession) {
		this.concession = concession;
	}

	public double getOtherRate() {
		return otherRate;
	}

	public void setOtherRate(double otherRate) {
		this.otherRate = otherRate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getCancle() {
		return cancle;
	}

	public void setCancle(String cancle) {
		this.cancle = cancle;
	}

	public double getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}

	public double getOtherPay() {
		return otherPay;
	}

	public void setOtherPay(double otherPay) {
		this.otherPay = otherPay;
	}

	public double getOtherConcession() {
		return otherConcession;
	}

	public void setOtherConcession(double otherConcession) {
		this.otherConcession = otherConcession;
	}

	public double getOtherCoPay() {
		return otherCoPay;
	}

	public void setOtherCoPay(double otherCoPay) {
		this.otherCoPay = otherCoPay;
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

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getClinicalnotes() {
		return clinicalnotes;
	}

	public void setClinicalnotes(String clinicalnotes) {
		this.clinicalnotes = clinicalnotes;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getUrgentflag() {
		return urgentflag;
	}

	public void setUrgentflag(String urgentflag) {
		this.urgentflag = urgentflag;
	}

	public String getDrdeskflag() {
		return drdeskflag;
	}

	public void setDrdeskflag(String drdeskflag) {
		this.drdeskflag = drdeskflag;
	}

	public Integer getRecSlaveId() {
		return recSlaveId;
	}

	public void setRecSlaveId(Integer recSlaveId) {
		this.recSlaveId = recSlaveId;
	}

	public String getCallfrom() {
		return callfrom;
	}


	public void setCallfrom(String callfrom) {
		this.callfrom = callfrom;
	}

	public Integer getMasterReceiptId() {
		return masterReceiptId;
	}

	public void setMasterReceiptId(Integer masterReceiptId) {
		this.masterReceiptId = masterReceiptId;
	}

	public String getSubservicesname() {
		return subservicesname;
	}

	public void setSubservicesname(String subservicesname) {
		this.subservicesname = subservicesname;
	}

	public String getIscombination() {
		return iscombination;
	}

	public void setIscombination(String iscombination) {
		this.iscombination = iscombination;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}

	public Integer getChargesSlaveId() {
		return chargesSlaveId;
	}

	public void setChargesSlaveId(Integer chargesSlaveId) {
		this.chargesSlaveId = chargesSlaveId;
	}

	public List<BillDetailsDto> getListBillDetails() {
		return listBillDetails;
	}

	public void setListBillDetails(List<BillDetailsDto> listBillDetails) {
		this.listBillDetails = listBillDetails;
	}

	public double getConcessionOnPerc() {
		return concessionOnPerc;
	}

	public void setConcessionOnPerc(double concessionOnPerc) {
		this.concessionOnPerc = concessionOnPerc;
	}

	public String getReceiptOf() {
		return receiptOf;
	}

	public void setReceiptOf(String receiptOf) {
		this.receiptOf = receiptOf;
	}

	public String getNarrationid() {
		return narrationid;
	}

	public void setNarrationid(String narrationid) {
		this.narrationid = narrationid;
	}

	public String getNarrationidBill() {
		return narrationidBill;
	}

	public void setNarrationidBill(String narrationidBill) {
		this.narrationidBill = narrationidBill;
	}

	public String getSndToLabFlag() {
		return sndToLabFlag;
	}

	public void setSndToLabFlag(String sndToLabFlag) {
		this.sndToLabFlag = sndToLabFlag;
	}
	public String getDeleteFrom() {
		return deleteFrom;
	}

	public void setDeleteFrom(String deleteFrom) {
		this.deleteFrom = deleteFrom;
	}

	public void setSndToRisFlag(String sndToRisFlag) {
		this.sndToRisFlag = sndToRisFlag;
	}
	public String getSndToRisFlag() {
		return sndToRisFlag;
	}
public String getSendToRisFlag() {
		return sendToRisFlag;
	}

	public void setSendToRisFlag(String sendToRisFlag) {
		this.sendToRisFlag = sendToRisFlag;
	}
	public String getrFlag() {
		return rFlag;
	}

	public void setrFlag(String rFlag) {
		this.rFlag = rFlag;
	}
	public String getAccountStatusOpdDiagno() {
		return accountStatusOpdDiagno;
	}

	public void setAccountStatusOpdDiagno(String accountStatusOpdDiagno) {
		this.accountStatusOpdDiagno = accountStatusOpdDiagno;
	}
	
	public double getEmrPer() {
		return emrPer;
	}

	public void setEmrPer(double emrPer) {
		this.emrPer = emrPer;
	}

	public Integer getOpdIpdNo() {
		return opdIpdNo;
	}

	public void setOpdIpdNo(Integer opdIpdNo) {
		this.opdIpdNo = opdIpdNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSubServiceName() {
		return subServiceName;
	}

	public void setSubServiceName(String subServiceName) {
		this.subServiceName = subServiceName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Integer getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(Integer sampleCount) {
		this.sampleCount = sampleCount;
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getHistopathLab() {
		return histopathLab;
	}

	public void setHistopathLab(String histopathLab) {
		this.histopathLab = histopathLab;
	}

	public String getTemplateWise() {
		return templateWise;
	}

	public void setTemplateWise(String templateWise) {
		this.templateWise = templateWise;
	}

	public String getSendtohistoflag() {
		return sendtohistoflag;
	}

	public void setSendtohistoflag(String sendtohistoflag) {
		this.sendtohistoflag = sendtohistoflag;
	}

	public Double getB2bNowPay() {
		return b2bNowPay;
	}

	public void setB2bNowPay(Double b2bNowPay) {
		this.b2bNowPay = b2bNowPay;
	}

	public Double getB2bDisocunt() {
		return b2bDisocunt;
	}

	public void setB2bDisocunt(Double b2bDisocunt) {
		this.b2bDisocunt = b2bDisocunt;
	}

	public Double getB2bDisocuntPer() {
		return b2bDisocuntPer;
	}

	public void setB2bDisocuntPer(Double b2bDisocuntPer) {
		this.b2bDisocuntPer = b2bDisocuntPer;
	}

	public Integer getB2bAuthorizedBy() {
		return b2bAuthorizedBy;
	}

	public void setB2bAuthorizedBy(Integer b2bAuthorizedBy) {
		this.b2bAuthorizedBy = b2bAuthorizedBy;
	}
	
	public Integer getReferredSource() {
		return referredSource;
	}

	public void setReferredSource(Integer referredSource) {
		this.referredSource = referredSource;
	}

	public String getB2bReceiptFlag() {
		return b2bReceiptFlag;
	}

	public void setB2bReceiptFlag(String b2bReceiptFlag) {
		this.b2bReceiptFlag = b2bReceiptFlag;
	}

	public String getAlternateTestName() {
		return alternateTestName;
	}

	public void setAlternateTestName(String alternateTestName) {
		this.alternateTestName = alternateTestName;
	}

	public String getPreCreditedFlag() {
		return preCreditedFlag;
	}

	public void setPreCreditedFlag(String preCreditedFlag) {
		this.preCreditedFlag = preCreditedFlag;
	}

	public Integer getCustReceiptMasterIid() {
		return custReceiptMasterIid;
	}

	public void setCustReceiptMasterIid(Integer custReceiptMasterIid) {
		this.custReceiptMasterIid = custReceiptMasterIid;
	}

	public String getB2bPaymentFlag() {
		return b2bPaymentFlag;
	}

	public void setB2bPaymentFlag(String b2bPaymentFlag) {
		this.b2bPaymentFlag = b2bPaymentFlag;
	}

	public String getDeletedRemark() {
		return deletedRemark;
	}

	public void setDeletedRemark(String deletedRemark) {
		this.deletedRemark = deletedRemark;
	}

	public String getClientBarcode() {
		return clientBarcode;
	}

	public void setClientBarcode(String clientBarcode) {
		this.clientBarcode = clientBarcode;
	}

	public String getParentUtilizationFlag() {
		return parentUtilizationFlag;
	}

	public void setParentUtilizationFlag(String parentUtilizationFlag) {
		this.parentUtilizationFlag = parentUtilizationFlag;
	}

	public int getParentCustomerId() {
		return parentCustomerId;
	}

	public void setParentCustomerId(int parentCustomerId) {
		this.parentCustomerId = parentCustomerId;
	}

	public double getParentUtilizationAmount() {
		return parentUtilizationAmount;
	}

	public void setParentUtilizationAmount(double parentUtilizationAmount) {
		this.parentUtilizationAmount = parentUtilizationAmount;
	}

	public String getIs2025Barcode() {
		return is2025Barcode;
	}

	public void setIs2025Barcode(String is2025Barcode) {
		this.is2025Barcode = is2025Barcode;
	}

	public double getParentuUtilizeAmount() {
		return parentuUtilizeAmount;
	}

	public void setParentuUtilizeAmount(double parentuUtilizeAmount) {
		this.parentuUtilizeAmount = parentuUtilizeAmount;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
}
