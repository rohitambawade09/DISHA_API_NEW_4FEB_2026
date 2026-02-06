package com.disha.hms.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.disha.hms.dto.ClientDetailsApiDto;

@Repository
public class ApiRepoImpl implements ApiRepo {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<ClientDetailsApiDto> getBusinessDetailsList() {
		// TODO Auto-generated method stub

		List<ClientDetailsApiDto> list = new ArrayList<>();
		try {
			
			String sql = "select      "
					+ "	distinct on      "
					+ "	(bmn.id) bmn.id,      "
					+ "	TRIM(coalesce(bmn.lab_name, '-')) as customername,      "
					+ "	TRIM(coalesce(bmn.lab_code, '-')) as customercode,      "
					+ "	TRIM(coalesce(bmn.reg_no, '-')) as customerregistrationno,      "
					+ "	TRIM(coalesce(bmn.status, '-')) as clientstatus,      "
					+ "	TRIM(coalesce(ldi.lookup_det_desc_en, '-')) as clienttype,      "
					+ "	TRIM(coalesce(bmn.on_board_date, '-')) as clientonboarddate,      "
					+ "	TRIM(coalesce(eu.unit_name, '-')) as unitname,      "
					+ "	TRIM(coalesce(bcmg.mail, '-')) as clientemailid,      "
					+ "	TRIM(coalesce(bcmg.mobile, '-')) as clientmobilenumber,      "
					+ "	TRIM(coalesce(bmci.contact_info_phone_number1, '-')) as contactpersonphonenumber,      "
					+ "	TRIM(coalesce(bmci.contact_info_name, '-')) as contactpersonname,      "
					+ "	TRIM(coalesce(bmci.contact_info_email, '-')) as contactpersonemailid,      "
					+ "	TRIM(coalesce(bmmi.marketing_person_name, '-')) as marketingpersonname,      "
					+ "	TRIM(coalesce(bmmi.from_date, '-')) as marketingpersononboardeddate,      "
					+ "	TRIM(coalesce(bmai.address, '-')) as clientaddress,      "
					+ "	TRIM(coalesce(bmn.payment_flag, '-')) as clientbillingflag,      "
					+ "	TRIM(coalesce(bmn.client_potential_prepaid, '0')) as prepaidclientpotential,      "
					+ "	coalesce(bmn.prepaid_credit_amount, 0) as prepaidclientcreditlimit,      "
					+ "	coalesce(bmn.advance_amount, 0) as advanceamount,      "
					+ "	coalesce(bmn.prepaid_day, 0) as clientprepaiday,      "
					+ "	TRIM(coalesce(bmn.pre_from_date, '-')) as prepaidclientstatingdate,      "
					+ "	TRIM(coalesce(bmn.pre_to_date, '-')) as prepaidclientendingdate,      "
					+ "	coalesce(bmn.reminder_on_percentage_prepaid, 0) as prepaidclientreminderpercentage,      "
					+ "	coalesce(bmn.block_percentage_prepaid, 0) as prepaidclientblockpercentage,      "
					+ "	coalesce(bmn.reminder_on_prepaid_day, 0) as prepaidclientreminderdays,      "
					+ "	coalesce(bmn.block_on_prepaid_day, 0) as prepaidclientblockprepaiddays,      "
					+ "	coalesce(bmn.credit_day, 0) as postpaidclientbillingcreditdays,      "
					+ "	coalesce(bmn.duedays, 0) as postpaidclientbillingduedays,      "
					+ "	coalesce(bmn.credit_amount, 0) as postpaidclientcreditamount,      "
					+ "	TRIM(coalesce(bmn.post_from_date, '-')) as postpaidclientstartingdate,      "
					+ "	TRIM(coalesce(bmn.post_to_date, '-')) as postpaidclientendingdate,      "
					+ "	coalesce(bmn.reminder_on_percentage_postpaid, 0) as postpaidclientreminderpercentage,      "
					+ "	coalesce(bmn.block_percentage_postpaid, 0) as postpaidclientblockpercentage,      "
					+ "	coalesce(bmn.reminder_on_credit_day, 0) as postpaidclientreminderday,      "
					+ "	coalesce(bmn.block_on_credit_day, 0) as postpaidclientblockday,      "
					+ "	TRIM(coalesce(bmai.district_name, '-')) as districtname,      "
					+ "	TRIM(coalesce(bmai.city, '-')) as city,      "
					+ "	TRIM(coalesce(bmai.street, '-')) as street      "
					+ "from      "
					+ "	business_master_new bmn      "
					+ "left join ehat_unit_master eu on      "
					+ "	eu.unit_id = bmn.unit_id      "
					+ "left join business_cust_master_general_info_slave bcmg on      "
					+ "	bcmg.business_master_id = bmn.id      "
					+ "left join business_master_contact_info_slave bmci on      "
					+ "	bmci.business_master_id = bmn.id      "
					+ "left join business_master_marketing_info_slave bmmi on      "
					+ "	bmmi.business_master_id = bmn.id      "
					+ "left join business_master_address_info_slave bmai on      "
					+ "	bmai.business_master_id = bmn.id      "
					+ "left join tm_cm_lookup_det ldi on      "
					+ "	ldi.lookup_det_id = bmn.lookup_det_id_lay      "
					+ "where      "
					+ "	bmn.deleted = 'N'      "
					+ "	and bmn.status = 'Active'      "
					+ "	and eu.deleted = 'N'      "
					+ "order by      "
					+ "	bmn.id,      "
					+ "	bcmg.id nulls last,      "
					+ "	bmci.id nulls last,      "
					+ "	bmmi.id nulls last,      "
					+ "	bmai.id nulls last";
			System.out.println(sql);
			
			NativeQuery sqlres = sessionFactory.getCurrentSession().createNativeQuery(sql);
			sqlres.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			list = sqlres.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
