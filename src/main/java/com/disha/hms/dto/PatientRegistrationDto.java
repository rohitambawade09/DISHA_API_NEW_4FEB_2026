package com.disha.hms.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PatientRegistrationDto {
	
	private Integer patientId;
	
	private String title;
	
	private String fname;
	
	private String mname;
	
	private String lname;
	
	private String gender;
	
	private String mobile;
	
	private Integer ageYears;
	
	private Integer ageMonth;
	
	private Integer ageDay;
	
	private String address;
	
	private String email;
	
	private Integer unitId;
	
	private Integer createdBy;
	
	private String collectedDate;
	
	private String collectedTime;
	
	private Double height;

	private Double weight;
	
	private Integer customerId;
	
	private String visitCode;
	
	private String campId;
	
	private Double totalAmount;
	
	private List<TestDetailsForRegistrationDto> listTestDetails;

}
