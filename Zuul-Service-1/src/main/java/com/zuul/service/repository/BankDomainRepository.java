package com.zuul.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zuul.service.domain.BankDomain;

@Repository
public interface BankDomainRepository extends JpaRepository<BankDomain, Long>{

}
