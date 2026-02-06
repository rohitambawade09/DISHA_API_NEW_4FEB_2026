package com.disha.hms.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseOutput {

	private String status;
	
	private String message;
	
	private  Integer patientId;
	
	private List output;

}
