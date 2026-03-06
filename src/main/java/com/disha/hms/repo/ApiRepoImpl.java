package com.disha.hms.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.disha.hms.dto.ClientDetailsApiDto;
import com.disha.hms.dto.PrePostConsumtionDto;
import com.disha.hms.entity.BillDetailsDto;
import com.disha.hms.entity.BusinessCustMasterDto;
import com.disha.hms.entity.PathologySampleWiseMaster;
import com.disha.hms.entity.PathologySampleWiseSuperMaster;
import com.disha.hms.entity.UnitMasterEntity;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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
					.append("	coalesce(teuwtm.service_id, 0) sub_service_id,      ")
					.append("	coalesce(teuwtm.b2bcharges, 0) b2bcharges,      ")
					.append("	coalesce(teuwtm.charges, 0) b2ccharges,      ")
					.append("	coalesce(es.category_name, '-') category_name,      ")
					.append("   coalesce(MAX(es.cgscode), '-') subservice_code,		")
					.append("	coalesce(MAX(pl2.sample_name), '-') sample_type_name,      ")
					.append("	coalesce(MAX(pl.idtestsample), 0) sample_type_id,      ")
					.append("	MAX(es.service_id),      ")
					.append("	coalesce(MAX(pl.template_wise), 'N') template_wise,      ")
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

	@Override
	public List<Object[]> getAllUnits() {
		
		List<Object[]> list = new ArrayList<>();
		
		try {
			
			CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			
			Root<UnitMasterEntity> root = cq.from(UnitMasterEntity.class);
			
			Predicate where = cb.equal(root.get("deleted"), "N");
			
			cq.multiselect(root.get("unitId"), root.get("unitName")).where(where);
			
			Query<Object[]> res = sessionFactory.getCurrentSession().createQuery(cq);
			
			list = res.getResultList();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<PrePostConsumtionDto> validateClientCreditLimit(PrePostConsumtionDto objres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getCustomerDetails(Integer customerId) {

		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			StringBuilder sb = new StringBuilder().append("select     ")
					.append("	bmn.id,     ")
					.append("	coalesce(bmn.payment_flag, 'N') payment_flag,     ")
					.append("	coalesce(bmn.lab_name, '-') lab_name,     ")
					.append("	coalesce(bmn.customer_type_name, '-') customer_type_name, 		")
					.append("	coalesce(bmn.parent_balance_utilization, 'N') parent_balance_utilization,     ")
					.append("	coalesce(bmn.parent_id, 0) parent_id,     ")
					.append("	coalesce(bmn.advance_amount, 0)  advance_amount,     ")
					.append("	coalesce(bmn.prepaid_day, 0) prepaid_day,     ")
					.append("	coalesce(bmn.reminder_on_percentage_prepaid, 0) reminder_on_percentage_prepaid,     ")
					.append("	coalesce(bmn.reminder_on_prepaid_day, 0) reminder_on_prepaid_day,     ")
					.append("	coalesce(bmn.block_percentage_prepaid, 0) block_percentage_prepaid,     ")
					.append("	coalesce(bmn.block_on_prepaid_day, 0) block_on_prepaid_day,     ")
					.append("	coalesce(bmn.pre_to_date, '-') pre_to_date,     ")
					.append("	coalesce(bmn.credit_amount, 0) credit_amount,     ")
					.append("	coalesce(bmn.credit_day, 0) credit_day,     ")
					.append("	coalesce(bmn.reminder_on_percentage_postpaid, 0) reminder_on_percentage_postpaid,     ")
					.append("	coalesce(bmn.reminder_on_credit_day, 0) reminder_on_credit_day,     ")
					.append("	coalesce(bmn.block_percentage_postpaid, 0) block_percentage_postpaid,     ")
					.append("	coalesce(bmn.block_on_credit_day, 0) block_on_credit_day,     ")
					.append("	coalesce(bmn.post_to_date, '-')  post_to_date,     ")
					.append("	bmn.unit_id		")
					.append("from     ")
					.append("	business_master_new bmn     ")
					.append("where     ")
					.append("	bmn.id =:customerId and bmn.deleted = 'N' and bmn.status = 'Active'	");
			
			NativeQuery sqlres = sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
								 .setParameter("customerId", customerId);
			sqlres.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

			list = sqlres.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Double getBillConsumedAmount(Integer customerId, Integer cycleId) {
		
		Double billConsumedAmount = 0.0;
		
		try {
			
			String sql = "select coalesce(sum(amount), 0) as consumeAmount from ehat_bill_details where "
						 + "	customer_id=? and deleted = 'N' and cancle = 'N' and b2b_payment_flag='N' "
						 + " 	and prepaid_receipt_id=?";
			NativeQuery rQuery = sessionFactory.getCurrentSession().createNativeQuery(sql);
			rQuery.setParameter(1, customerId);
			rQuery.setParameter(2, cycleId);
			billConsumedAmount = (Double)rQuery.uniqueResult();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return billConsumedAmount;
		
	}

	@Override
	public Double getConsumeAmount(Integer customerId, Integer cycleId) {
		
		Double conumentAmt = 0.0;
		try {

			String sqlLis= new StringBuilder().append("SELECT  coalesce(SUM(m.amount), 0) consumedAmt from ( ")
					.append("	select coalesce(sum(b.amount), 0) as amount from ehat_bill_details b ")
					.append("	join pathology_sample_wise_master s on (b.bill_details_id = s.bil_det_id) ")
					.append("	where s.test_status >= 3 and s.test_status <= 6 and b.customer_id =:customerId ")
					.append("	and b.deleted = 'N' and b.cancle = 'N' and b.b2b_payment_flag='N' and prepaid_receipt_id =:cycleId ")
					.append("	GROUP BY b.bill_details_id ) m").toString();
			NativeQuery lisQuery = sessionFactory.getCurrentSession().createNativeQuery(sqlLis)
								   .setParameter("customerId", customerId)
								   .setParameter("cycleId", cycleId);
			conumentAmt = (Double) lisQuery.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conumentAmt;
	}

	@Override
	public Integer getReceiptId(Integer customerId) {
		
		Integer receiptId = 0;
		
		try {
			
			String sqlRec = new StringBuilder().append("select coalesce((select cycle_id from cycle_count_master where cycle_id = (select coalesce(max(cycle_id),0) as id from cycle_count_master where ")
											   .append("      customer_id=:customerId and deleted='N')),0) as cycleId		").toString();
			NativeQuery recQuery = sessionFactory.getCurrentSession().createNativeQuery(sqlRec).setParameter("customerId", customerId);
			receiptId = ((Number) recQuery.uniqueResult()).intValue();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return receiptId;
	}

	@Override
	public String getLastPaymentDate(Integer customerId) {
		
		String lastPaymentDate = "";
		try {

			String sqlDate = new StringBuilder().append("SELECT distinct     ")
					.append("    COALESCE(     ")
					.append("        CASE      ")
					.append("            WHEN EXISTS (SELECT 1 FROM cust_receipt_master r WHERE r.deleted = 'N' AND r.customer_id =:customerId)     ")
					.append("            THEN (     ")
					.append("                SELECT TO_CHAR(r.created_date_time, 'DD-MM-YYYY')     ")
					.append("                FROM cust_receipt_master r     ")
					.append("                WHERE r.deleted = 'N' AND r.customer_id =:customerId      ")
					.append("                ORDER BY r.bill_receipt_id DESC     ")
					.append("                LIMIT 1     ")
					.append("            )     ")
					.append("            ELSE '-'     ")
					.append("        END,     ")
					.append("    '-') AS lastPaymentDate     ")
					.append("FROM      ")
					.append("    cust_receipt_master     ")
					.append("WHERE      ")
					.append("    deleted = 'N'     ")
					.append("    AND customer_id =:customerId		 ").toString();
			NativeQuery dateQuery = sessionFactory.getCurrentSession().createNativeQuery(sqlDate).setParameter("customerId", customerId);
			lastPaymentDate = (String) dateQuery.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lastPaymentDate;
		
	}

	@Override
	public Integer getRecCount(Integer customerId) {

		Integer recCount = 0;
		try {

			String sqlRef = new StringBuilder().append("select coalesce(count(cycle_id),0) from cycle_count_master where deleted='N'	")
												.append(" and customer_id=:customerId		").toString();
			NativeQuery refQuery1 = sessionFactory.getCurrentSession().createNativeQuery(sqlRef).setParameter("customerId", customerId);
			recCount = ((Number) refQuery1.uniqueResult()).intValue();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return recCount;
	}

	@Override
	public List<Map<String, Object>> getListCycle(Integer customerId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			String sqlCycle = new StringBuilder().append("select coalesce(cycle_id,0) as cycleId,coalesce(advance_amount,0) as AdvcAmt,	")
					.append("	coalesce(cycle_date,'-') as cycleDate,coalesce(carry_fwd_amount,0) as carryFwdAmt,		")
					.append("	coalesce(refund_amount,0) as refundAmt,coalesce(remain_amount,0) as remainAmt,			")
					.append("	coalesce(receipt_ids,'0') as receiptIds from cycle_count_master where 					")
					.append("	cycle_id = (select coalesce(max(cycle_id),0) as id from cycle_count_master where 		")
					.append("	customer_id=:customerId and deleted='N')	").toString();
			NativeQuery cycleQuery = sessionFactory.getCurrentSession().createNativeQuery(sqlCycle).setParameter("customerId", customerId);
			cycleQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);

			list = cycleQuery.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	
	}

	@Override
	public Double getCycleAdvcAmt(Integer customerId, Integer cycleId) {
		
		Double cycleAdvcAmt = 0.0;
		try {

			String sql = new StringBuilder().append("select coalesce(sum(total_paid),0) from cust_receipt_master where customer_id =:customerId and cycle_id =:cycleId and deleted = 'N'").toString();
			NativeQuery cycleQuery = sessionFactory.getCurrentSession().createNativeQuery(sql)
									 .setParameter("customerId", customerId)
									 .setParameter("cycleId", cycleId);
			
			cycleAdvcAmt = (Double) cycleQuery.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cycleAdvcAmt;
	}

	@Override
	public String getPostpaidLastPaymentDate(Integer customerId) {
		
		String lastPaymentDate = "";
		try {

			String sqlDate = new StringBuilder().append("SELECT COALESCE(").append("   CASE ").append(
					"       WHEN (SELECT COUNT(invoice_id) FROM business_customer_invoice WHERE deleted = 'N' AND customer_id = :customerId) > 0 ")
					.append("       THEN (").append("           SELECT TO_CHAR(r.created_date_time, 'DD-MM-YYYY') ")
					.append("           FROM business_customer_invoice r ")
					.append("           WHERE r.deleted = 'N' AND r.customer_id = :customerId ")
					.append("           ORDER BY r.invoice_id DESC ").append("           LIMIT 1").append("       ) ")
					.append("       ELSE (").append("           SELECT TO_CHAR(t.created_date_time, 'DD-MM-YYYY') ")
					.append("           FROM ehat_treatment t ")
					.append("           WHERE t.deleted = 'N' AND t.business_type = 1 AND t.customer_id = :customerId ")
					.append("           ORDER BY t.treatment_id ASC ").append("           LIMIT 1").append("       ) ")
					.append("   END, ").append("   '-' ").append(") AS lastPaymentDate").toString();

			NativeQuery dateQuery = sessionFactory.getCurrentSession().createNativeQuery(sqlDate)
									 .setParameter("customerId", customerId);
			lastPaymentDate = (String) dateQuery.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lastPaymentDate;			
	}

	@Override
	public Double getConsumedAmountNew(Integer customerId) {

		Double consumedAmountNew = 0.0;
		try {

			String sqlLis1=new StringBuilder().append("select coalesce(sum(b.amount),0) as consumeAmount from ehat_bill_details b where  b.customer_id =:customerId ")
											  .append(" and b.deleted='N' and b.cancle='N'  and b.b2b_payment_flag='N'").toString();
			NativeQuery dateQuery = sessionFactory.getCurrentSession().createNativeQuery(sqlLis1)
					 				.setParameter("customerId", customerId);
			consumedAmountNew = (Double) dateQuery.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return consumedAmountNew;
	}

	@Override
	public Map<String, Object> getCustomerTypeAndProjectId(Integer customerId) {
		
		List<Map<String, Object>> map = new ArrayList<>();
		try {
			
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery("select coalesce(lookup_det_id_lay, 0) customer_type, coalesce(lookup_det_id_client_project, 0) project_id, payment_flag from business_master_new bmn where id =:customerId")
							  .setParameter("customerId", customerId);
			sql.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			map = sql.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return map.get(0);
	}

	@Override
	public Integer getMaxCycleId(Integer customerId) {

		Integer cycleId = 0;
		try {
			
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery("select coalesce(MAX(ccm.cycle_id), 0) cycle_id from cycle_count_master ccm where ccm.customer_id =:customerId")
								.setParameter("customerId", customerId);
			cycleId = ((Number) sql.uniqueResult()).intValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cycleId;
	}

	@Override
	public Integer mergeBillDetails(BillDetailsDto obj) {
		
		Integer res = 0;
		try {
			
			sessionFactory.getCurrentSession().merge(obj);
			res = 1;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<Map<String, Object>> getTestDetailsToSendToLab(Integer treatmentId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			
			StringBuilder sb = new StringBuilder()
								.append("SELECT ep.gender, ebd.bill_details_id, ebd.patient_id, ebd.treatment_id, ebd.rate, ebd.service_id, ")
								.append("ebd.sub_service_id, ebd.sample_type_id, ebd.in_out_house, ebd.bar_code, ebd.business_type, ebd.customer_id, ")
								.append("ebd.customer_type, ebd.collection_date, ebd.collection_time, ebd.reg_ref_doc_id, ebd.histopath_lab, ")
								.append("ebd.unit_id, ebd.department_id FROM ehat_patient ep JOIN ehat_bill_details ebd ON (ep.patient_id = ebd.patient_Id) 		")
								.append("where ebd.treatment_id=:treatmentId AND ebd.cancle='N' AND ebd.deleted='N'");
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
							  .setParameter("treatmentId", treatmentId);
			sql.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			list = sql.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getRunnerBoy(Integer unitId) {
		
		String res = "";
		try {
			
			Query sql = sessionFactory.getCurrentSession().createQuery("SELECT u.runnerBoy FROM UnitMasterDto u WHERE u.unitId=:unitId")
						.setParameter("unitId", unitId);
			res = (String) sql.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Map<String, Object>> getProfileMappedDetailsBySubservice(PathologySampleWiseMaster obj, Integer unitId,
			Integer projectId) {

		List<Map<String, Object>> list = new ArrayList<>();
		try {
			
			StringBuilder sb = new StringBuilder()
					.append("SELECT lp.id as profileId, lp.profilecode as profilecode, lpc.idTest as testId, ")
					.append("lt.idTestSample as sampleId, lt.idSampleContainer as containerId, ")
					.append("coalesce(lt.nabl, 'N') AS nabl, coalesce(lp.nabl, 'N') AS nablPro, ")
					.append("lpc.organ_id AS organ_id FROM pathology_labprofile lp 	")
					.append("join pathology_labprofiletestcomp lpc on (lp.id = lpc.idprofile) 	")
					.append("join pathology_lab_test lt on(lpc.idTest = lt.idTest) 	")
					.append(" WHERE lp.service_id =:serviceId and lp.subservice_id =:subServiceId 	")
					.append("AND lt.process_test_outlab =:testOutlab AND lt.testStatus=:testStatus 	")
					.append("AND lp.profileStatus=:profileStatus AND lpc.test_status=:test_status 	")
					.append("and lp.mapped_project_id=:mappedProjectId and lp.unit_id=:unitId 	")
					.append("ORDER BY lpc.organ_id ASC");

			NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(sb.toString());

			query.setParameter("serviceId", obj.getServiceId());
			query.setParameter("subServiceId", obj.getSubServiceId());
			query.setParameter("testStatus", "Y");
			query.setParameter("profileStatus", "Y");
			query.setParameter("test_status", "Y");

			if (obj.getInOutHouse() == 0)
				query.setParameter("testOutlab", "N");
			else
				query.setParameter("testOutlab", "Y");
			
			query.setParameter("mappedProjectId", projectId);
			query.setParameter("unitId", unitId);

			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			list = query.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getCallfromForSubservice(Integer subService) {
		
		String callfrom = "";
		try {
			
			StringBuilder sb = new StringBuilder().append(" SELECT  lp.callfrom FROM pathology_labprofile lp WHERE profileStatus = 'Y' AND lp.subservice_id=:subserviceId");
			NativeQuery sqltempq = sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
								   .setParameter("subserviceId", subService);
			callfrom = (String) sqltempq.setMaxResults(1).uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return callfrom;
	}

	@Override
	public Integer getDuplicateTestCnt(PathologySampleWiseMaster obj, Integer unitId,
			PathologySampleWiseMaster master) {
		
		Integer cnt = 0;
		try {
			
			Query qry = sessionFactory.getCurrentSession().createQuery(
					"SELECT count(*) FROM PathologySampleWiseMaster WHERE 		"
					+ "deleted =:deleted AND serviceId =:serviceId AND subServiceId =:subServiceId 		"
					+ "AND treatmentId =:treatmentId AND patientId =:patientId AND inOutHouse =:inOutHouse 		"
					+ "AND unitId =:unitId AND bilDetId =:bilDetId");
			qry.setParameter("serviceId", obj.getServiceId());
			qry.setParameter("subServiceId", obj.getSubServiceId());
			qry.setParameter("unitId", unitId);
			qry.setParameter("treatmentId", master.getTreatmentId());
			qry.setParameter("patientId", master.getPatientId());
			qry.setParameter("bilDetId", obj.getBilDetId());
			qry.setParameter("inOutHouse", obj.getInOutHouse());
			qry.setParameter("deleted", "N");

			cnt = ((Number) qry.uniqueResult()).intValue();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public Integer updateSndFlagBillDetailsForLab(Integer billDetailsId) {
		
		Integer res = 0;
		try {
			
			StringBuilder sb = new StringBuilder().append("UPDATE ehat_bill_details SET sndtolabflag='Y' WHERE bill_details_id=:billDetailsId");
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
								   .setParameter("billDetailsId", billDetailsId);
			res = sql.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer updatePaidFlagForB2B(Integer billDetailsId) {
		
		Integer res = 0;
		try {
			
			StringBuilder sb = new StringBuilder().append("UPDATE ehat_bill_details SET paid_flag='Y' WHERE bill_details_id=:billDetailsId");
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery(sb.toString())
								   .setParameter("billDetailsId", billDetailsId);
			res = sql.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer getRowCount(PathologySampleWiseMaster obj, String runnerBoy, 
			PathologySampleWiseMaster master, Integer unitId) {
		
		Integer res = 0;
		try {
			String sqlRef = "";
			if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
				sqlRef = "SELECT coalesce(MAX(ssm.id), 0) AS id FROM pathology_sample_wise_super_master ssm join pathology_sample_wise_master sm on (ssm.id = sm.master_id) WHERE sm.deleted = 'N' AND sm.sample_type_id = "
						+ obj.getSampleTypeId() + " AND ssm.patient_id = " + master.getPatientId()
						+ " AND ssm.treatment_id = " + master.getTreatmentId() + " AND sm.unit_Id="
						+ unitId + " AND sm.test_status = 112";
			} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {
				sqlRef = "SELECT coalesce(MAX(ssm.id), 0) AS id FROM pathology_sample_wise_super_master ssm join pathology_sample_wise_master sm on (ssm.id = sm.master_id) WHERE sm.deleted = 'N' AND sm.sample_type_id = "
						+ obj.getSampleTypeId() + " AND ssm.patient_id = " + master.getPatientId()
						+ " AND ssm.treatment_id = " + master.getTreatmentId() + " AND sm.unit_Id="
						+ unitId + " AND sm.test_status = 2";
			} else {
				sqlRef = "SELECT coalesce(MAX(ssm.id), 0) AS id FROM pathology_sample_wise_super_master ssm join pathology_sample_wise_master sm on (ssm.id = sm.master_id) WHERE sm.deleted = 'N' AND sm.sample_type_id = "
						+ obj.getSampleTypeId() + " AND ssm.patient_id = " + master.getPatientId()
						+ " AND ssm.treatment_id = " + master.getTreatmentId() + " AND sm.unit_Id="
						+ unitId + " AND sm.test_status < 2";
			}
			
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery(sqlRef);
			res = ((Number) sql.uniqueResult()).intValue();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public PathologySampleWiseSuperMaster getSuperMasterData(Integer rowCount) {
		
		PathologySampleWiseSuperMaster obj = new PathologySampleWiseSuperMaster();
		try {
			obj = (PathologySampleWiseSuperMaster) sessionFactory.getCurrentSession()
					.get(PathologySampleWiseSuperMaster.class, rowCount);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String getAccreditatedFlagForProfile(Integer profileId) {
		String result = "";

		try {

			String sql = "SELECT chk_accreditated_header FROM pathology_labprofile WHERE id = " + profileId;
			NativeQuery sqlresult = sessionFactory.getCurrentSession().createNativeQuery(sql);
			result = (String) sqlresult.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Integer getCountVal(PathologySampleWiseMaster obj, String runnerBoy, Integer unitId) {

		Integer countVal = 0;
		try {
			if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("RRB")) {
				String sql = "select COALESCE(max(sample_count),0) from pathology_sample_wise_master where deleted ='N' and unit_Id="
						+ unitId + " and test_status=112";

				NativeQuery sqlQuery = sessionFactory.getCurrentSession().createNativeQuery(sql);
				Integer sampleCount = ((Number) sqlQuery.uniqueResult()).intValue();

				countVal = sampleCount + 1;

		} else if ((obj.getBusinessType()) == 1 && runnerBoy.equalsIgnoreCase("NRRB")) {

				String sql = "select COALESCE(max(sample_count),0)  from pathology_sample_wise_master where deleted ='N' and unit_Id="
						+ unitId + " and test_status=2";

				NativeQuery sqlQuery = sessionFactory.getCurrentSession().createNativeQuery(sql);
				Integer sampleCount = ((Number) sqlQuery.uniqueResult()).intValue();

				countVal = sampleCount + 1;

		} else {
				String sqlCount = "select COALESCE(max(sample_count),0) from pathology_sample_wise_master where deleted ='N' and unit_Id="
							+ unitId + " and test_status=1";

				NativeQuery queryCount = sessionFactory.getCurrentSession()
						.createNativeQuery(sqlCount);
				Integer PhleCount = ((Number) queryCount.uniqueResult()).intValue();
				countVal = PhleCount + 1;
		}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return countVal;
	}

	@Override
	public String getReportFooterFlag(Integer unitId) {

		String res = "";
		try {
			
			NativeQuery sql = sessionFactory.getCurrentSession().createNativeQuery("SELECT footer_address_flag FROM hospital WHERE unit_id =:unitId")
							  .setParameter("unitId", unitId);
			res = (String) sql.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String getTemplateWiseValue(Integer profileId) {

		String templateWiseValue = "";
		try {

			String queryy=" select template_wise from pathology_labprofile pl where id =:profileId and profileStatus ='Y' ";
			NativeQuery queryP= sessionFactory.getCurrentSession().createNativeQuery(queryy)
								.setParameter("profileId", profileId);        	 
			templateWiseValue = (String) queryP.uniqueResult();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return templateWiseValue;
	}

	@Override
	public List<Map<String, Object>> getHistopathTestDetails(PathologySampleWiseMaster obj, Integer projectId,
			Integer unitId) {
		
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			
			String sqltemp1 = "SELECT lp.idTestSample as sampleId, lp.idSampleContainer as containerId,lp.id as profileId,lp.profileName as profileName, coalesce(nabl, 'N') AS nabl FROM pathology_labprofile lp  WHERE lp.service_id="
					+ obj.getServiceId() + " AND lp.subservice_id=" + obj.getSubServiceId() + " "
					+ " and lp.mapped_project_id = "+projectId+" and lp.unit_id = "+unitId+" and lp.profileStatus ='Y' ";		
			NativeQuery sqlQuery1 = sessionFactory.getCurrentSession().createNativeQuery(sqltemp1);
			sqlQuery1.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			list = sqlQuery1.list();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public PathologySampleWiseSuperMaster mergeSendtoLabData(PathologySampleWiseSuperMaster obj) {

		try {
			return sessionFactory.getCurrentSession().merge(obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer closeCampIdForDISHA(String campId) {
		
		Integer res = 0;
		try {
			String sql = new StringBuilder()
						 .append("UPDATE TreatmentDto SET campCloseFlag=:campCloseFlag	")
						 .append("WHERE campId=:campId AND hmisApiFlag=:hmisApiFlag")
						 .toString();
			
			Query query = sessionFactory.getCurrentSession().createQuery(sql)
						  .setParameter("campId", campId)
						  .setParameter("campCloseFlag", "Y")
						  .setParameter("hmisApiFlag", "Y");
			
			res = query.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
