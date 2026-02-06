package com.disha.hms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Component
@Table(name = "business_master_new")
public class BusinessCustMasterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "lab_name")
	private String name;
	
	@Column(name = "lab_code")
	private String code;
	
	@Column(name = "reg_no")
	private String regNo;
	
	@Column(name = "status")
	private String status;	
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "hospital_type")
	private String hospitalType;
	
	@Column(name = "no_of_beds")
	private String noOfBeds;
	
	@Column(name = "lab_available")
	private String labAvailable;
	
	@Column(name = "customer_type_name")
	private String customerTypeName;
	
	@Column(name = "type",columnDefinition="int(11) default 0")
	private Integer type=0;	
	
	@Column(name = "unit_name_id",columnDefinition="int(11) default 0")
	private Integer unit=0;		
	
	@Column(name="inhous_lab_id",columnDefinition="int(11) default 0")
	private Integer inhouseLabId=0;
	
	@Column(name = "unit_id",columnDefinition="int(11) default 0")
	private Integer unitId=0;
	
	@Column(name = "Avg_Patient_Footfall_Per_Day")
	private String Avg_Patient_Footfall_Per_Day;
	
	@Column(name = "Avg_Outs_No_Per_Day")
	private String Avg_Outs_No_Per_Day;	
	
	@Column(name = "avg_Opd_Patient_PerDay")
	private String avgOpdPatientPerDay;
	
	@Column(name = "avg_Ipd_Patient_PerDay")
	private String avgIpdPatientPerDay;
	
	@Column(name = "avg_Diagnostics_Patient_PerDay")
	private String avgDiagnosticsPatientPerDay;
	
	@Column(name = "avg_test_OutsourceDay")
	private String avgtestOutsourceDay;
	
	@Column(name="payment_flag")
	private String paymentFlag;
	
	@Column(name = "parent_balance_utilization")
	private String parentBalanceUtilization;

	@Column(name="advance_amount")
	private Double advanceAmount;
	
	@Column(name="prepaid_day",columnDefinition="double default 0")
	private Double prePaidDay=0.0;
	
	@Column(name="reminder_on_percentage_prepaid",columnDefinition="double default 0")
	private Double reminderOnPercentagePrepaid=0.0;
	
	@Column(name="block_percentage_prepaid",columnDefinition="double default 0")
	private Double blockOnpercentagePrepaid=0.0;	
	
	@Column(name="reminder_on_prepaid_day",columnDefinition="double default 0")
	private Double reminderOnPrepaidDay=0.0;
	
	@Column(name="block_on_prepaid_day",columnDefinition="double default 0")
	private Double blockOnPrepaidDay=0.0;
	
	@Column(name = "pre_from_date",columnDefinition="varchar(100) default '' ")
	private String preFromDate="";
	
	@Column(name = "pre_to_date",columnDefinition="varchar(100) default '' ")
	private String preToDate="";
	
	@Column(name = "pre_remark",columnDefinition="varchar(100) default '' ")
	private String preRemark;
	
	@Column(name = "client_potential_prepaid")
	private String clientPotentialPrepaid;
	
	@Column(name = "client_potential_postpaid")
	private String clientPotentialPostpaid;
	
	@Column(name = "pre_reason")
	private String preReason;
	
	@Column(name="credit_day")
	private Double creditDay;
	
	@Column(name="credit_amount")
	private Double credithAmount;
	
	@Column(name="reminder_on_percentage_postpaid",columnDefinition="double default 0")
	private Double reminderOnPercentagePostPaid=0.0;
	
	@Column(name="block_percentage_postpaid",columnDefinition="double default 0")
	private Double blockOnpercentagePostPaid=0.0;
	
	@Column(name="reminder_on_credit_day",columnDefinition="double default 0")
	private Double reminderOnCreditDay=0.0;
	
	@Column(name="block_on_credit_day",columnDefinition="double default 0")
	private Double blockOnCreditDay=0.0;
	
	@Column(name = "post_from_date",columnDefinition="varchar(100) default '' ")
	private String postFromDate="";
	
	@Column(name = "post_to_date",columnDefinition="varchar(100) default '' ")
	private String postToDate="";
	
	@Column(name = "post_remark",columnDefinition="varchar(255) default '' ")
	private String postRemark;
		
	@Column(name = "post_reason")
	private String postReason;
	
	@Column(name = "deleted",columnDefinition="varchar(2) default 'N'")
	private String deleted="N";
	
	@Column(name = "created_by", updatable = false)
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "deleted_by")
	private Integer deletedBy;
	
	@Column(name = "prepaid_credit_amount")
	private Double prepaidCreditAmount=0.0;

	@CreationTimestamp
	@Column(name = "created_date_time", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date_time")
	private Date updatedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_date_time")
	private Date deletedDate;
	
	@Column(name="collection_centre_id",columnDefinition="int default 0")
	private Integer collectionCentreId;
	
	@Column(name="collection_centre_name")
	private String collectionCentreName;
	
	@Column(name = "lookup_det_id_lay")
	private Integer lookupDetIdLay;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name = "on_board_Date",columnDefinition="varchar(100) default '' ")
	private String onBoardDate="";
	
	@Column(name = "lookup_det_id_client_project")
	private Integer lookupDetIdClientProject;
	
	@Column(name="unit_for")
	private Integer unitFor;
	
	@Column(name = "mail_flag")
	private String mailflag;
	
	@Column(name = "auto_whatsapp_flag")
	private String autowhatsappflag;
	
	@Column(name = "header_reflection_report")
	private String headerReportReflection;

	@Column(name = "lookup_det_id_client_test_show")
	private Integer lookupDetIdClientTestShow;
	
	@Column(name="duedays")
	private Double dueDays;
	
	@Column(name = "cpt_code")
	private String cptCode;
	
	@Column(name = "cdac_hospital_code")
	private String cdacHospitalCode;
	
	@Column(name = "dist_between_lab_facility")
	private String distBetweenLabFacility;

	@Transient
	private List<BusinessCustMasterDto> businessMasterDto;

	@Transient
	private List<TmCmLookupDet> TmCmLookupDetLookupList;

	@Transient
	private List<TmCmLookupDetHierarchical> tmCmLookupDetHierarchical;
	
	@Transient
    private List<LabChargesConfigurationViewDto> lstConfigurations;
	
	@Transient
	private String rowCount;
	
	@Transient
	private String parentLabName;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterGenralInfoDto> businessMasterGeneralInfoDto;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterContactInfoDto> businessMasterContactInfoDto;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterMarketingInfoDto> businessMasterMarketingInfoDto;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterAddressInfoDto> businessMasterAddressInfoDto;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterPaymentInfoDto> businessMasterPaymentInfoDto;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterTermsAndCondInfoDto> termsAndConditionInfoDto;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterContractInfoDto> businessMasterContractInfo;

	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
	private List<BusinessCustMasterUploadDocInfoDto> businessMasterUploadDocInfo;
}
