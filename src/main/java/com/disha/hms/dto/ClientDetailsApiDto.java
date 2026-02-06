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
public class ClientDetailsApiDto {

	private String customerName; 
	private String customerCode;
	private String customerRegistrationNo;
	private String clientStatus;
	private String clientType;
	private String clientOnBoardDate; 
	private String unitName;
	private String clientEmailId;
	private String clientMobileNumber;
	private String contactPersonPhoneNumber;
	private String contactPersonName;
	private String contactPersonEmailId;
	private String marketingPersonName;
	private String marketingPersonOnboardedDate;
	private String clientAddress;
	private String clientBillingFlag;
	private String prepaidClientPotential;
	private Double prepaidClientCreditLimit;
	private Double advanceAmount;
	private Double clientPrepaidDay;
	private String prepaidClientStatingDate;
	private String prepaidClientEndingDate;
	private Double prepaidClientReminderPercentage;
	private Double prepaidClientBlockPercentage;
	private Double prepaidClientReminderDays;
	private Double prepaidClientBlockprepaidDays;
	private Double postpaidClientBillingCreditDays;
	private Double postpaidClientBillingDueDays;
	private Double postpaidClientCreditAmount;
	private String postpaidClientStartingdate;
	private String postpaidClientEndingDate;
	private Double postpaidClientReminderPercentage;
	private Double postpaidClientBlockpercentage;
	private Double postpaidClientReminderDay;
	private Double postpaidClientBlockDay;
	private String districtName;
	private String city;
	private String street;
	
	private List<ClientDetailsApiDto> list;
	
}
