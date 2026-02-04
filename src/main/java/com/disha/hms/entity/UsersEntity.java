package com.disha.hms.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private Integer userId;
	
	@Column(name = "User_Name")
	private String userName;
	
	@Column(name = "user_Type")
	private String userType;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "Availability")
	private String availability;

	@Column(name = "status")
	private String status;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "f_name")
	private String firstName;
	
	@Column(name = "m_name")
	private String middleName;
	
	@Column(name = "l_name")
	private String lastName;
	
	@Column(name = "loged_in_status")
	private String loggedInStatus;
	
	@Column(name = "last_loged_in_date_time")
	private String lastLoggedInDateTime;
	
	@Column(name = "last_loged_out_date_time")
	private String lastLoggedOutDateTime;
	
	@Column(name = "current_loged_in_date_time")
	private String currentLoggedInDateTime;
	
	@Column(name = "current_loged_out_date_time")
	private String currentLoggedOutDateTime;
	
	@Column(name = "doctype_id")
	private Integer docTypeId;
	
	@Column(name = "doctor_type_id_list")
	private String doctorTypeIdList;
	
	@Column(name = "unitmaster_id")
	private String unitMasterId;
	
	@Column(name = "dept_id")
	private String deptId;
	
	@Column(name = "service_id")
	private String serviceId;
	
	@Column(name = "empIdhr")
	private String empIdHr;
	
	@Column(name = "customer_type")
	private String customerType;
	
	@Column(name ="customer_id")
	private String customerId;
	
	@Column(name ="hrms_emp_flag")
	private String hrms_emp_flag;
	
	@Transient
	private List<UsersEntity> listUsers;

}
