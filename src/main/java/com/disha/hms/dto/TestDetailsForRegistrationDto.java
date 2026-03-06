package com.disha.hms.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TestDetailsForRegistrationDto {

	private Integer subServiceId;
	
	private Double amount;
	
	private String subServiceName;
	
	private Integer sampleTypeId;
	
	private String barCode;
	
	private Integer quantity;
	
	private String templateWise;
	
	private Integer serviceId;
	
}
