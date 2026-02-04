package com.disha.hms.repo;

public interface AuthRepo {

	boolean validateUser(String username, String password);
	
}
