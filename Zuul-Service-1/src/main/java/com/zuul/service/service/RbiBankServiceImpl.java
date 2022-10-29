package com.zuul.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.zuul.service.controller.RbiDomain;
import com.zuul.service.domain.BankDomain;
import com.zuul.service.domain.RBIDomain;
import com.zuul.service.repository.BankDomainRepository;
import com.zuul.service.repository.RBIRepository;
import com.zuul.service.util.ApiRequest;
import com.zuul.service.util.JwtUtil;


@Service
public class RbiBankServiceImpl implements RBIBankService {
	
	BankDomain dom=null;
	
	@Autowired
	private BankDomainRepository bankRepo;
	
	@Autowired
	private RBIRepository repository;
	
	

	@Override
	public RBIDomain saveRbiData(RBIDomain rbiDomain) {
	
			RBIDomain rbiDomain2=new RBIDomain();
	     rbiDomain2.setBankName(rbiDomain.getBankName());
	    
	   List<BankDomain> domain1=new ArrayList<BankDomain>();
	     BankDomain  dom=new BankDomain();

	       
	    for (BankDomain bankDomain1 : rbiDomain.getBanks()) {
	           dom.setAcType(bankDomain1.getAcType());
	           dom.setBankName(bankDomain1.getBankName());
	           dom.setBranch(bankDomain1.getBranch());
	           dom.setDeposite(bankDomain1.getDeposite());
	           dom.setIfsc(bankDomain1.getIfsc());
	           dom.setRegistrationNumber(bankDomain1.getRegistrationNumber());
	  	        dom.setRbiDomain(bankDomain1.getRbiDomain());
	  	        domain1.add(dom);
	  	        bankRepo.save(dom);
	  	        
	          // System.out.println(domain1);
			
		}

	    rbiDomain2.setBanks(domain1);
	    rbiDomain2.setDepositeRates(rbiDomain.getDepositeRates());
	    rbiDomain2.setPolicyRates(rbiDomain.getPolicyRates());
	    rbiDomain2.setRegistrationNumber(rbiDomain.getRegistrationNumber());
	    rbiDomain2.setReserveRatios(rbiDomain.getReserveRatios());
		
		RBIDomain domains=repository.save(rbiDomain);
		return domains;
	}

	@Override
	public BankDomain getDataById(Long id) {
		BankDomain bd=bankRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id"));
		return bd;
	}

	
	

}
