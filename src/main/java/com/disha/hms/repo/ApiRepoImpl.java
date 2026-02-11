package com.disha.hms.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<String, Object> getCustomerDetails(String customerCode) {
		
		Map<String, Object> obj = new HashMap<>();
		try {
			
			StringBuilder sql = new StringBuilder().append("select     ")
					.append("	bmn.id lab_id,     ")
					.append("	coalesce(bmn.lab_name, '-') lab_name,     ")
					.append("	coalesce(bmn.lab_code, '-') lab_code,     ")
					.append("	coalesce(bmn.unit_id, 0) unit_id,     ")
					.append("	coalesce(lookup_det_id_client_project, 0) project_id     ")
					.append("from     ")
					.append("	business_master_new bmn     ")
					.append("where     ")
					.append("	trim(bmn.lab_code) =:customerCode");
			NativeQuery sqlres = sessionFactory.getCurrentSession().createNativeQuery(sql.toString())
								.setParameter("customerCode", customerCode.trim());
			sqlres.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			
			List<Map<String, Object>> list = sqlres.list();
			
			obj = list.get(0);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public String getUnitType(Integer unitId) {
		
		String res = "";
		try {
			
			StringBuilder sql = new StringBuilder().append("select coalesce(tcld.lookup_det_value, '-') type 	"
					+ "			from ehat_unit_master eum 	"
					+ "			inner join tm_cm_lookup_det tcld on eum.unit_for =tcld.lookup_det_id 	"
					+ "			where  unit_id =:unitId");
			NativeQuery sqlres = sessionFactory.getCurrentSession().createNativeQuery(sql.toString())
								 .setParameter("unitId", unitId);
			
			res = (String) sqlres.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<Map<String, Object>> getTestDetailsforGov(Integer unitId, Integer projectId, Integer customerId) {

		List<Map<String, Object>> list = new ArrayList<>();
		try {
			
			StringBuilder sql = new StringBuilder().append("select      ")
					.append("	coalesce(teuwtm.unit_id, 0)  unit_id,      ")
					.append("	coalesce(eum.unit_name, '-')  unit_name,      ")
					.append("	coalesce(teuwtm.project_id, 0) project_id,      ")
					.append("	coalesce(epm.project_name, '-') project_name,      ")
					.append("	coalesce(teuwtm.service_id, 0) service_id,      ")
					.append("	coalesce(teuwtm.b2bcharges, 0) b2bcharges,      ")
					.append("	coalesce(teuwtm.charges, 0) b2ccharges,      ")
					.append("	coalesce(es.category_name, '-') category_name,      ")
					.append("   coalesce(MAX(es.cgscode), '-') subservice_code,		")
					.append("	coalesce(MAX(pl2.sample_name), '-') sample_type_name,      ")
					.append("   MAX(pl.id) profile_id		")
					.append("from      ")
					.append("	lab_charges_configuration teuwtm      ")
					.append("inner join ehat_project_master epm on      ")
					.append("	epm.project_id = teuwtm.project_id      ")
					.append("inner join ehat_unit_master eum on      ")
					.append("	eum.unit_id = teuwtm.unit_id      ")
					.append("inner join ehat_subservice es on      ")
					.append("	es.id = teuwtm.service_id      ")
					.append("inner join pathology_labprofile pl on pl.subservice_id = es.id      ")
					.append("inner join pathology_labsample pl2 on pl2.id = pl.idtestsample       ")
					.append("where      ")
					.append("	teuwtm.unit_id =:unitId      ")
					.append("	and teuwtm.project_id=:projectId     ")
					.append("	and teuwtm.deleted = 'N'      ")
					.append("	and teuwtm.customer_name =:customerId      ")
					.append("	and pl.profilestatus = 'Y'      ")
					.append("	and pl2.deleted = 'N'      ")
					.append("group by      ")
					.append("	1,      ")
					.append("	2,      ")
					.append("	3,      ")
					.append("	4,      ")
					.append("	5,      ")
					.append("	6,      ")
					.append("	7,      ")
					.append("	8");
			
			NativeQuery sqlres = sessionFactory.getCurrentSession().createNativeQuery(sql.toString())
					             .setParameter("unitId", unitId)
					             .setParameter("projectId", projectId)
					             .setParameter("customerId", customerId);
			sqlres.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			
			list = sqlres.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Map<String, Object>> getTestDetailsforOther(Integer unitId) {
		// TODO Auto-generated method stub
		return null;
	}

}
