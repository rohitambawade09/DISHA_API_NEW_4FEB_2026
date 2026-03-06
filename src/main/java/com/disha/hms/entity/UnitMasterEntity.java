package com.disha.hms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.disha.hms.dto.UnitMasterDataDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ehat_unit_master")
public class UnitMasterEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
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

	@Column(name = "email_typeid")
	private String emailTypeId;
	
	@Column(name = "email_minutes")
	private Integer emailMinutes;

	@Column(name = "auto_send_processFlag")
	private String autoSendProcessFlag;
	
	@Column(name = "whatsApp_flag")
	private String whatsAppFlag;

	@Column(name = "continuous_report_flag")
	private String contineousReportFlag="N";
	
	@Transient
	private Integer lookupDetId;

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
	
	@Column(name = "mail_flag")
	private String mailFlag;
	
	@Column(name = "whatsapp_scheduler_type")
	private String whatsappSchedulerType;
	
	@Column(name = "whatsapp_scheduler_time")
	private String whatsappSchedulerTime;

	@Transient
	private List<UnitMasterDataDto> lstUnit;

	@Transient
	private List<TmCmLookupDet> TmCmLookupDetLookupList;

	@Column(name = "runner_boy")
	private String runnerBoy;

	@Column(name = "report_flag")
	private String reportFlag="N";

	@Column(name = "footer_text")
	private String footerText;

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
	
	@Column(name = "bulk_authorize_flag")
	private String bulkAuthorizeFlag = "N";
	
	@Column(name = "processed_at")
	private String processedAtFlag="N";
	
	 @Column(name = "flag_mark")
	 private String flagMark;

}
