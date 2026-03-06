package com.disha.hms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

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
@Table(name = "user_customers")
@Component
public class UserCustomersDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id",columnDefinition="int default 0")
	private int userId=0;
	
	@Column(name = "customer_type",columnDefinition="int default 0")
	private int customerType=0;	
	
	@Column(name = "customer_id",columnDefinition="int default 0")
	private int customerId=0;
	
	@Column(name = "inhouse_id",columnDefinition="int default 0")
	private int inhouseId=0;	
	
	@Column(name = "unit_id",columnDefinition="int default 0")
	private int unitId=0;
	
	@Column(name = "customer_type_name",columnDefinition="varchar(255) default 'N'")
	private String customerTypeName;
	
	@Column(name = "customer_name",columnDefinition="varchar(255) default 'N'")
	private String customerName;
	
	@Column(name = "deleted",columnDefinition="varchar(2) default 'N'")
	private String deleted="N";

	@Column(name = "created_by",updatable=false)
	private Integer createdBy;
	
	@CreationTimestamp
	@Column(name = "created_date_time",updatable=false)
	private Date createdDateTime;

	@Column(name = "deleted_by")
	private Integer deletedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date_time")
	private Date deletedDateTime;
	
	@Transient
	private List<UserCustomersDto> lstUserCustomersDto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getInhouseId() {
		return inhouseId;
	}

	public void setInhouseId(int inhouseId) {
		this.inhouseId = inhouseId;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public List<UserCustomersDto> getLstUserCustomersDto() {
		return lstUserCustomersDto;
	}

	public void setLstUserCustomersDto(List<UserCustomersDto> lstUserCustomersDto) {
		this.lstUserCustomersDto = lstUserCustomersDto;
	}	
}
