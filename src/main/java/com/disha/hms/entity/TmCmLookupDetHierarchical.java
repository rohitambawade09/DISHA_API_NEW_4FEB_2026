package com.disha.hms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tm_cm_lookup_det_hierarchical")
public class TmCmLookupDetHierarchical {

	private static final long serialVersionUID = 1L;
	private int lookupDetHierId;
	private TmCmLookupDet tmCmLookupDet;
	private int ulbId;
	private String lookupDetHierValue;
	private String lookupDetHierDescEn;
	private String lookupDetHierDescRg;
	private Integer lookupDetHierParentId;
	private Integer status;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	private String macId;
	private String ipAddress;
	private Character deviceFrom;
	private Integer lookupDetHierOrderBy;
	
	
	public TmCmLookupDetHierarchical() {
		super();
	}
	
	public TmCmLookupDetHierarchical(int lookupDetHierId) {
		
		this.lookupDetHierId=lookupDetHierId;
	}
	
	
	public TmCmLookupDetHierarchical(String lookupDetHierDescEn) {
		this.lookupDetHierDescEn = lookupDetHierDescEn;
	}
	

	public TmCmLookupDetHierarchical( String lookupDetHierDescEn,int lookupDetHierId) {
		this.lookupDetHierDescEn = lookupDetHierDescEn;
		this.lookupDetHierId=lookupDetHierId;
	}
	public TmCmLookupDetHierarchical( int lookupDetHierId,String lookupDetHierDescEn,String lookupDetHierDescRg) {
		this.lookupDetHierDescEn = lookupDetHierDescEn;
		this.lookupDetHierId=lookupDetHierId;
		this.lookupDetHierDescRg =lookupDetHierDescRg;
	}

	public TmCmLookupDetHierarchical(int lookupDetHierId, TmCmLookupDet tmCmLookupDet, int ulbId,
			String lookupDetHierValue, String lookupDetHierDescEn, String lookupDetHierDescRg) {
		this.lookupDetHierId = lookupDetHierId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.ulbId = ulbId;
		this.lookupDetHierValue = lookupDetHierValue;
		this.lookupDetHierDescEn = lookupDetHierDescEn;
		this.lookupDetHierDescRg = lookupDetHierDescRg;
	}

	public TmCmLookupDetHierarchical(int lookupDetHierId, TmCmLookupDet tmCmLookupDet, int ulbId,
			String lookupDetHierValue, String lookupDetHierDescEn, String lookupDetHierDescRg,
			Integer lookupDetHierParentId, Integer status, Integer createdBy, Date createdDate, Integer updatedBy,
			Date updatedDate, String macId, String ipAddress, Character deviceFrom) {
		this.lookupDetHierId = lookupDetHierId;
		this.tmCmLookupDet = tmCmLookupDet;
		this.ulbId = ulbId;
		this.lookupDetHierValue = lookupDetHierValue;
		this.lookupDetHierDescEn = lookupDetHierDescEn;
		this.lookupDetHierDescRg = lookupDetHierDescRg;
		this.lookupDetHierParentId = lookupDetHierParentId;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.macId = macId;
		this.ipAddress = ipAddress;
		this.deviceFrom = deviceFrom;
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lookup_det_hier_id", unique = true, nullable = false)
	public int getLookupDetHierId() {
		return this.lookupDetHierId;
	}

	public void setLookupDetHierId(int lookupDetHierId) {
		this.lookupDetHierId = lookupDetHierId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lookup_det_id", nullable = false)
	public TmCmLookupDet getTmCmLookupDet() {
		return this.tmCmLookupDet;
	}

	public void setTmCmLookupDet(TmCmLookupDet tmCmLookupDet) {
		this.tmCmLookupDet = tmCmLookupDet;
	}

	@Column(name = "ulb_id", nullable = false)
	public int getUlbId() {
		return this.ulbId;
	}

	public void setUlbId(int ulbId) {
		this.ulbId = ulbId;
	}

	@Column(name = "lookup_det_hier_value", nullable = false, length = 5)
	public String getLookupDetHierValue() {
		return this.lookupDetHierValue;
	}

	public void setLookupDetHierValue(String lookupDetHierValue) {
		this.lookupDetHierValue = lookupDetHierValue;
	}

	@Column(name = "lookup_det_hier_desc_en", nullable = false, length = 200)
	public String getLookupDetHierDescEn() {
		return this.lookupDetHierDescEn;
	}

	public void setLookupDetHierDescEn(String lookupDetHierDescEn) {
		this.lookupDetHierDescEn = lookupDetHierDescEn;
	}

	@Column(name = "lookup_det_hier_desc_rg", nullable = false, length = 200)
	public String getLookupDetHierDescRg() {
		return this.lookupDetHierDescRg;
	}

	public void setLookupDetHierDescRg(String lookupDetHierDescRg) {
		this.lookupDetHierDescRg = lookupDetHierDescRg;
	}

	@Column(name = "lookup_det_hier_parent_id")
	public Integer getLookupDetHierParentId() {
		return this.lookupDetHierParentId;
	}

	public void setLookupDetHierParentId(Integer lookupDetHierParentId) {
		this.lookupDetHierParentId = lookupDetHierParentId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "created_by")
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "mac_id", length = 50)
	public String getMacId() {
		return this.macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	@Column(name = "ip_address", length = 50)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "device_from", length = 1)
	public Character getDeviceFrom() {
		return this.deviceFrom;
	}

	public void setDeviceFrom(Character deviceFrom) {
		this.deviceFrom = deviceFrom;
	}

	@Column(name = "lookup_det_hier_order_by")
	public Integer getLookupDetHierOrderBy() {
		return lookupDetHierOrderBy;
	}

	public void setLookupDetHierOrderBy(Integer lookupDetHierOrderBy) {
		this.lookupDetHierOrderBy = lookupDetHierOrderBy;
	}

}
