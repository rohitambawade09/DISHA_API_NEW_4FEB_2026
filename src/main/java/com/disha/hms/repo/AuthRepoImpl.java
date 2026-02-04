package com.disha.hms.repo;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepoImpl implements AuthRepo {
	
	@Autowired
	SessionFactory ses;

	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		
		Integer cnt = 0;
		
		try {
			
			StringBuilder sql = new StringBuilder("SELECT COUNT(*)    ")
					.append("    FROM UsersEntity u    ")
					.append("    WHERE LOWER(u.userName) = :userName    ")
					.append("      AND u.password = :password    ")
					.append("      AND u.status   = :status");
			
			cnt = ((Number) ses.getCurrentSession().createQuery(sql.toString())
									.setParameter("userName", username.toLowerCase())
									.setParameter("password", password)
									.setParameter("status", "Y")
									.getSingleResult()).intValue();
			
//			String sqlnative = "select * from users";
//			NativeQuery sqlnativeres = ses.getCurrentSession().createNativeQuery(sqlnative);
//			sqlnativeres.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
//			
//			List<Map<String, Object>> list = sqlnativeres.list();
//			
//			for(Map<String, Object> rs : list)
//			{
//				String user_name = (String) rs.get("User_Name");
//				String pass_word = (String) rs.get("password");
//				String user_Type = (String) rs.get("user_Type");
//				
//				System.out.println(user_name+" "+pass_word+" "+user_Type);
//			}
			
			if(cnt > 0)
				return true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
 		
		return false;
	}

}
