package com.zuul.service.service;



import org.springframework.security.core.userdetails.User;

import com.zuul.service.domain.BankDomain;
import com.zuul.service.domain.RBIDomain;
import com.zuul.service.util.ApiRequest;

public interface RBIBankService {

	public RBIDomain saveRbiData(RBIDomain rbiDomain);
	
	public BankDomain getDataById(Long id);
	
	

	
}
