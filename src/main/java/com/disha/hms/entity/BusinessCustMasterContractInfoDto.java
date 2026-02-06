package com.disha.hms.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "business_cust_master_contract_info_slave")
@Component
@JsonDeserialize(as = BusinessCustMasterContractInfoDto.class)
public class BusinessCustMasterContractInfoDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "contract_type_id")
	private Integer contractTypeId;
	
	@Column(name = "contract_type")
	private String contractType;
	
	@Column(name = "duration",columnDefinition = "int default 0")
	private Integer duration;
	
	@Column(name = "time_period",columnDefinition = "varchar(255) default ''")
	private String timePeriod="";
	
	@Column(name = "from_date",columnDefinition = "varchar(30) default ''")
	private String fromDate="";
	
	@Column(name = "to_date",columnDefinition = "varchar(30) default ''")
	private String toDate="";
	
	@Column(name = "unit_id")
	private Integer unitId;
	
	@Column(name = "deleted", columnDefinition = "varchar(2) default 'N'")
	private String deleted = "N";
	
	@Column(name = "created_by", updatable = false)
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "deleted_by")
	private Integer deletedBy;
	
	@CreationTimestamp
	@Column(name = "created_date_time", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date_time")
	private Date updatedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_date_time")
	private Date deletedDate;
	
	@ManyToOne
	@JoinColumn(name = "business_master_id")
	private BusinessCustMasterDto businessCustMaster;
	
	@Transient
	private List<BusinessCustMasterContractInfoDto> businessMasterContractInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
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

	public List<BusinessCustMasterContractInfoDto> getBusinessMasterContractInfo() {
		return businessMasterContractInfo;
	}

	public void setBusinessMasterContractInfo(List<BusinessCustMasterContractInfoDto> businessMasterContractInfo) {
		this.businessMasterContractInfo = businessMasterContractInfo;
	}	
}
