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
@Table(name = "ehat_bill_master")
public class BillMasterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	private Integer billId;
	
	@Column(name = "treatment_id")
	private Integer treatmentId;
	
	@Column(name = "patient_id")
	private Integer patienttId;
	
	@Column(name = "department_id")
	private Integer departmentId;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "source_type_id",columnDefinition="int default 1")
	private int sourceTypeId;
	
	@Column(name = "unit_id",columnDefinition="int default 1")
	private int unitId;
	
	@Column(name = "deleted",columnDefinition="varchar(2) default 'N'")
	private String deleted;

	@Column(name = "created_by",updatable=false)
	private Integer createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time",updatable=false)
	private Date createdDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "inv_created_date_time",updatable=false)
	private Date invoiceCreatedDateTime;
	
	@Column(name = "inv_created_by",updatable=false)
	private Integer invCreatedBy;

	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date_time")
	private Date updatedDateTime;

	@Column(name = "deleted_by")
	private Integer deletedBy;
	
	@Column(name = "invoice_flag")
	private String invoiceFlag="N";
	
	@Column(name = "invoice_count")
	private Integer invoiceCount=0;
	
	@Column(name = "bill_type")
	private Integer billType=0;
	
	@Column(name = "bill_type_name")
	private String billTypeName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date_time")
	private Date deletedDateTime;
	
	@Column(name = "sponsor_cat_id",columnDefinition="int default 0")
	private int sponsorCatId;
	
	@Column(name = "patient_cat_id",columnDefinition="int default 0")
	private int patientCatId;
	

	@Column(name = "charges_master_slave_id",columnDefinition="int default 0")
	private Integer sponsorId=0;
	
	@Column(name = "total_bill")
	private double totalBill=0;
	
	@Column(name = "total_paid")
	private double totalPaid=0;
	
	@Column(name = "total_remain")
	private double totalRemain=0;
	
	@Column(name = "total_refund")
	private double totalRefund=0;
	
	@Column(name = "discount")
	private double discount=0;
	
	@Column(name = "bill_settled_flag")
	private String billSettledFlag="N";
	
	@Transient
	private List<BillMasterDto> listBill;
	
	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	
	public String getInvoiceFlag() {
		return invoiceFlag;
	}

	public void setInvoiceFlag(String invoiceFlag) {
		this.invoiceFlag = invoiceFlag;
	}

	public Integer getInvoiceCount() {
		return invoiceCount;
	}

	public void setInvoiceCount(Integer invoiceCount) {
		this.invoiceCount = invoiceCount;
	}

	public Integer getBillType() {
		return billType;
	}

	public void setBillType(Integer billType) {
		this.billType = billType;
	}

	public String getBillTypeName() {
		return billTypeName;
	}

	public void setBillTypeName(String billTypeName) {
		this.billTypeName = billTypeName;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSourceTypeId() {
		return sourceTypeId;
	}

	public void setSourceTypeId(int sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
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

	public Date getInvoiceCreatedDateTime() {
		return invoiceCreatedDateTime;
	}

	public void setInvoiceCreatedDateTime(Date invoiceCreatedDateTime) {
		this.invoiceCreatedDateTime = invoiceCreatedDateTime;
	}

	public Integer getInvCreatedBy() {
		return invCreatedBy;
	}

	public void setInvCreatedBy(Integer invCreatedBy) {
		this.invCreatedBy = invCreatedBy;
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

	public List<BillMasterDto> getListBill() {
		return listBill;
	}

	public void setListBill(List<BillMasterDto> listBill) {
		this.listBill = listBill;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public int getSponsorCatId() {
		return sponsorCatId;
	}

	public void setSponsorCatId(int sponsorCatId) {
		this.sponsorCatId = sponsorCatId;
	}

	public int getPatientCatId() {
		return patientCatId;
	}

	public void setPatientCatId(int patientCatId) {
		this.patientCatId = patientCatId;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public double getTotalRemain() {
		return totalRemain;
	}

	public void setTotalRemain(double totalRemain) {
		this.totalRemain = totalRemain;
	}

	public double getTotalRefund() {
		return totalRefund;
	}

	public void setTotalRefund(double totalRefund) {
		this.totalRefund = totalRefund;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getBillSettledFlag() {
		return billSettledFlag;
	}

	public void setBillSettledFlag(String billSettledFlag) {
		this.billSettledFlag = billSettledFlag;
	}

	
}
