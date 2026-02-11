package com.disha.hms.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestDetailsDto {
	
	private Integer subServiceId;
	
	private String subServiceCode;
	
	private String subServiceName;

	private Integer profileId;
	
	private Double b2cCharges;
	
	private Double b2bCharges;
	
	private String sampleTypeName;
}
