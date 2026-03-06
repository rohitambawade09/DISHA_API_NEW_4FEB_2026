package com.disha.hms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "token_number")
public class TokenDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tokenId")
	private Integer tokenId;
	
 	@Column(name = "treatment_id")
	private Integer treatmentId;
	
	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "doctor_id")
	private String doctorIdList;
	
	@Column(name = "token",columnDefinition="int default 0")
	private int token;
	
	@Column(name = "t_flag",columnDefinition="varchar(2) default 'N'")
	private String tFlag;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time",updatable=false)
	private Date createdDateTime;
	
	//Added by Laxman for display LED on 01-Jan-2018.
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cancel_date_time")
	private Date cancelDateTime;

	@Column(name = "send_by")
	private String sendBy;
	
	@Column(name = "queue_status")
	private String queueStatus;
	
	@Column(name = "narration")
	private String narration;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "checkup_done_date_time")
	private Date checkupDoneDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "app_date")
	private Date appDate;
	
	@Column(name = "unit_id")
	private int unitId;
	
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

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getCancelDateTime() {
		return cancelDateTime;
	}

	public void setCancelDateTime(Date cancelDateTime) {
		this.cancelDateTime = cancelDateTime;
	}

	public String getSendBy() {
		return sendBy;
	}

	public void setSendBy(String sendBy) {
		this.sendBy = sendBy;
	}

	public String getQueueStatus() {
		return queueStatus;
	}

	public void setQueueStatus(String queueStatus) {
		this.queueStatus = queueStatus;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Date getCheckupDoneDateTime() {
		return checkupDoneDateTime;
	}

	public void setCheckupDoneDateTime(Date checkupDoneDateTime) {
		this.checkupDoneDateTime = checkupDoneDateTime;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public int getUnitId() {
		return unitId;
	}
	
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
}
