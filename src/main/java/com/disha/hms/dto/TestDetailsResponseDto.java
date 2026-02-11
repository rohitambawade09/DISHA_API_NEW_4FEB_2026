package com.disha.hms.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestDetailsResponseDto {
	
	private Integer customerId;
	
	private String customerCode;
	
	private String customerName;
	
	private List<TestDetailsDto> listTestDetailsDto;

	
	
}
