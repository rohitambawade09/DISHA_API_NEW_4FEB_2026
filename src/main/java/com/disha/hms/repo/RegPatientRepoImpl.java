package com.disha.hms.repo;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.disha.hms.entity.BillMasterDto;
import com.disha.hms.entity.RegistrationDto;
import com.disha.hms.entity.TokenDto;
import com.disha.hms.entity.TreatmentDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class RegPatientRepoImpl implements RegPatientRepo {

	@Autowired
	SessionFactory sessionFactory;
	
	@Value("${doctorWiseToken}")
	private String doctorWise;

	java.util.Calendar currentDate = java.util.Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public String getHospitalInitials() {
		
		String res = "";
		try {

			String sql1 = "SELECT hospital_initial FROM hospital";
			NativeQuery query1 = sessionFactory.getCurrentSession().createNativeQuery(sql1);
			res = (String) query1.list().get(0);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer getMaxPatientId() {

		Integer max = 0;
		try {
			CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);

			Root<RegistrationDto> root = cq.from(RegistrationDto.class);

			cq.select(cb.max(root.get("patientId")));

			max = sessionFactory.getCurrentSession().createQuery(cq).getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return max;
	}

	@Override
	public Long getTotalPatientCountByUnitId(Integer unitId) {
		
		Long count = 0l;
		try {
			count = sessionFactory.getCurrentSession()
			        .createQuery(
			            "select count(r.patientId) from RegistrationDto r where r.unitId = :unitId",
			            Long.class
			        )
			        .setParameter("unitId", unitId)
			        .getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Integer getUnitIdbyPatientId(Integer patientId) {
		
		Integer unitID = 0;
		try {
			unitID = sessionFactory.getCurrentSession()
			        .createQuery(
			            "select r.unitId from RegistrationDto r where r.patientId = :patientId",
			            Integer.class
			        )
			        .setParameter("patientId", patientId)
			        .getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return unitID;
	}

	@Override
	public Integer mergePatient(RegistrationDto obj) {
		
		Integer res = 0;
		try {
			sessionFactory.getCurrentSession().merge(obj);
			res = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;		
	}
	
	public int maxCountOfColumn(@SuppressWarnings("rawtypes") Class className,
            String columnName) {
		Session session = sessionFactory.getCurrentSession();

		String entityName = className.getSimpleName();

		String hql = "select max(e." + columnName + ") from " + entityName + " e";

		Integer maxValue = session.createQuery(hql, Integer.class)
		        .getSingleResult();
        if (maxValue == null) {
        	maxValue = 0;
        }
        return maxValue;
    }

	@Override
	public Integer saveTreatmentDetails(TreatmentDto treatmentDto, String queryType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getDeptCount(int deptId) {
		
		long res = 0;
		try {
			Query q1 = sessionFactory.getCurrentSession()
					.createNativeQuery(
							"SELECT count(department_id) from ehat_treatment " + " where department_id =(:dId)")
					.setParameter("dId", deptId);
			List rows = q1.list();
			res = ((Long) rows.get(0)).longValue();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Integer> getTreatmentCount(Date date) {
		
		List<Integer> list = new ArrayList<>();
		try {
			Query q2 = sessionFactory.getCurrentSession()
					.createNativeQuery("SELECT count(*) from ehat_treatment where created_date_time >=?");

			q2.setParameter(1, date);
			list = q2.list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> getUnitNamebyUnitId(Integer unitId) {
		
		List<String> list = new ArrayList<>();
		try {
			list = sessionFactory.getCurrentSession()
				.createQuery("select u.unitName from UnitMasterDto u "
						+ "where u.unitId = :unitId and u.deleted = :deleted", String.class)
				.setParameter("unitId", unitId).setParameter("deleted", "N").getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer mergeTratment(TreatmentDto treatmentDto) {
		
		Integer res = 0;
		try {
			sessionFactory.getCurrentSession().merge(treatmentDto);
			res = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer getTokenCount(TreatmentDto treatmentDto, Date date, Integer loopCnt) {
		
		Integer tokencount = 0;
		try {
			Query tqry = null;
			if (doctorWise.equalsIgnoreCase("true")) {
				tqry = sessionFactory.getCurrentSession()
						.createNativeQuery("SELECT max(token) from token_number "
								+ " where created_date_time >=(:createdate)"
								+ "and department_id =(:dId) and doctor_id=(:drid)")
						.setParameter("dId", treatmentDto.getDepartmentId()).setParameter("drid", date)
						.setParameter("createdate", date);

			} else {
				tqry = sessionFactory.getCurrentSession()
						.createNativeQuery("SELECT max(token) from token_number "
								+ " where created_date_time >=(:createdate)" + "and department_id =(:dId)")
						.setParameter("dId", treatmentDto.getDepartmentId())
						.setParameter("createdate", date);
			}

			List<Integer> tokencnt = tqry.list();
			if (tokencnt.contains(null)) {
				tokencount++;
			} else {
				Integer toknvalue = (Integer) tqry.uniqueResult();
				tokencount = toknvalue;

				if (doctorWise.equalsIgnoreCase("false")) {
					if (loopCnt == 0) {
						tokencount++;
					}
				} else {
					tokencount++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tokencount;
	}

	@Override
	public Integer mergeToken(TokenDto tn) {

		Integer res = 0;
		try {
			sessionFactory.getCurrentSession().merge(tn);
			res = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer savePatientBMIDeatils(TreatmentDto treatmentDto, String dt, Integer a) {

		Integer res = 0;
		try {
			Query bmabsa = sessionFactory.getCurrentSession().createNativeQuery(
					"INSERT INTO patient_bmi_details (patient_treat_id, patient_treat_count, patient_id, patient_weight"
							+ ", patient_height, patient_bmi, patient_bsa, patient_headcim, status, patient_bmi_date)"
							+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
					.setParameter(1, a).setParameter(2, treatmentDto.getTrcount())
					.setParameter(3, treatmentDto.getPatientId()).setParameter(4, treatmentDto.getWeight())
					.setParameter(5, treatmentDto.getHeight()).setParameter(6, treatmentDto.getBMI())
					.setParameter(7, treatmentDto.getBSA()).setParameter(8, treatmentDto.getHCIM())
					.setParameter(9, "Y").setParameter(10, dt);
			bmabsa.executeUpdate();
			res = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer maxCountOfBilling(@SuppressWarnings("rawtypes") Class className,
			String columnName, int paramName) {

		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);

		Root<?> root = cq.from(className);

		cq.select(cb.max(root.get(columnName)))
		  .where(cb.equal(root.get("departmentId"), paramName));

		Integer maxCount = session.createQuery(cq)
		        .uniqueResultOptional()
		        .orElse(null);
		if (maxCount == null) {
			maxCount = 0;
		}
		return maxCount;
	}

	@Override
	public Integer mergeBillMaster(BillMasterDto billMasterDto) {

		Integer res = 0;
		try {
			sessionFactory.getCurrentSession().merge(billMasterDto);
			res = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Integer generateOpdCount(int userId, int treatId, int deptId) {
		int result = 0;
		if (deptId == 1) {
			String sql = "select max(invoice_count) from ehat_bill_master where department_id=1";
			NativeQuery query2 = sessionFactory.getCurrentSession().createNativeQuery(sql);
			int invCount = (Integer) query2.uniqueResult();
			invCount = invCount + 1;

			String hql = "UPDATE BillMasterDto set invoiceFlag = :invoiceFlag, invoiceCount = :invoiceCount, "
					+ "invCreatedBy = :updatedBy, invoiceCreatedDateTime = :updatedDateTime "
					+ "WHERE treatmentId = :treatmentId";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("invoiceFlag", "Y");
			query.setParameter("invoiceCount", invCount);
			query.setParameter("updatedBy", userId);
			query.setParameter("updatedDateTime", new java.util.Date());
			query.setParameter("treatmentId", treatId);
			result = query.executeUpdate();
		} else if (deptId == 3) {
			String sql = "select max(invoice_count) from ehat_bill_master where department_id=3";
			NativeQuery query2 = sessionFactory.getCurrentSession().createNativeQuery(sql);
			int invCount = (Integer) query2.uniqueResult();
			invCount = invCount + 1;

			String hql = "UPDATE BillMasterDto set invoiceFlag = :invoiceFlag, invoiceCount = :invoiceCount, "
					+ "invCreatedBy = :updatedBy, invoiceCreatedDateTime = :updatedDateTime "
					+ "WHERE treatmentId = :treatmentId";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter("invoiceFlag", "Y");
			query.setParameter("invoiceCount", invCount);
			query.setParameter("updatedBy", userId);
			query.setParameter("updatedDateTime", new java.util.Date());
			query.setParameter("treatmentId", treatId);
			result = query.executeUpdate();
		}
		return result;

	}

}
