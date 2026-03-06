package com.disha.hms.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class PrePostConsumtionDto {

	int businessType, customerType, customerId, userId, unitId, prepaidReceiptId;
	double prepaidAmount, prepaidSmsPer, prepaidBlockPer;
	double prepaidDays, prepaidSmsOnDay, prepaidBlockOnDay;
	double postpaidAmount, postpaidSmsPer, postpaidBlockPer;
	double postpaidCreditDays, postpaidSmsOnDay, postpaidBlockOnDay;
	double consumeAmount, billConsumeAmount, remainAmount, billRemainAmount, carryAmount;
	String paymentFlag, customerTypeName, customerName, lastPaymentDate;
	String postToDate;
	String preToDate;
	String parentFlag, parentBalanceUtilization;
	Integer parentId;
	List<PrePostConsumtionDto> lstPrePostConsumtionDto;
	
}
