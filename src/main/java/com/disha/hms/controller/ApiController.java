package com.disha.hms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.PatientRegistrationDto;
import com.disha.hms.dto.PrePostConsumtionDto;
import com.disha.hms.dto.ResponseOutput;
import com.disha.hms.dto.TestDetailsResponseDto;
import com.disha.hms.dto.UnitMasterDataDto;
import com.disha.hms.service.ApiService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/")
@Tag(name = "ApiController", description = "APIs for the Application")
public class ApiController {
	
	@Autowired
	ApiService apiService;
	
	@GetMapping("/getCustomerList")
	public ResponseEntity<ResponseOutput>  getBusinessDetailsList()
	{
		ResponseOutput obj = new ResponseOutput();
		
		List<ClientDetailsApiDto> list = new ArrayList<>();
		list = apiService.getBusinessDetailsList();
		
		obj.setStatus("Success");
		obj.setOutput(list);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping("/getTestbyCustomerId")
	public ResponseEntity<TestDetailsResponseDto> getTestbyCustomerId(@RequestParam String customerCode)
	{
		TestDetailsResponseDto objData = apiService.getTestbyCustomerId(customerCode);
		
		return ResponseEntity.ok().body(objData);
	}
	
	@GetMapping("/getAllUnits")
	public ResponseEntity<ResponseOutput> getAllUnits()
	{
		ResponseOutput obj = new ResponseOutput();
		
		List<UnitMasterDataDto> list = apiService.getAllUnits();
		
		obj.setMessage("Unit List Response");
		obj.setStatus("Success");
		obj.setOutput(list);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/validateClientCreditLimit")
	public ResponseEntity<ResponseOutput> validateClientCreditLimit(@RequestParam Integer custId)
	{
		ResponseOutput obj = new ResponseOutput();
		
		List<PrePostConsumtionDto> lstPrePostConsumtionDto = new ArrayList<PrePostConsumtionDto>();
		PrePostConsumtionDto objres = new PrePostConsumtionDto();
		objres.setCustomerId(custId);
		lstPrePostConsumtionDto = apiService.validateClientCreditLimit(objres);
		
		obj.setMessage("B2B Client account details");
		obj.setStatus("Success");
		obj.setOutput(lstPrePostConsumtionDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@PostMapping("/registerPatientFromHMIS")
	public ResponseEntity<ResponseOutput> registerPatientFromHMIS(@RequestBody PatientRegistrationDto patientObj)
	{
		ResponseOutput obj = new ResponseOutput();
		
		Integer res = apiService.registerPatientFromHMIS(patientObj);
		
		if(res > 0)
		{
			obj.setStatus("Success");
			obj.setMessage("Patient Registered Successfully!");
		} else if(res == -1) {
			obj.setStatus("Failed");
			obj.setMessage("Patient Failed to Register For Insufficient Balance!");
		} else {
			obj.setStatus("Failed");
			obj.setMessage("Patient Failed to Register!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@PostMapping("/closeCampIdForDISHA")
	public ResponseEntity<ResponseOutput> closeCampIdForDISHA(@RequestParam String campId)
	{
		ResponseOutput obj = new ResponseOutput();
		Integer res = apiService.closeCampIdForDISHA(campId);
		
		if(res > 0)
		{
			obj.setStatus("Success");
			obj.setMessage("Camp closed successfully!");
		} else {
			obj.setStatus("Success");
			obj.setMessage("Camp already closed!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
}
