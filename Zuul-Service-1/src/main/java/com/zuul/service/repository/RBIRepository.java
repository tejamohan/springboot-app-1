package com.zuul.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.zuul.service.domain.RBIDomain;


@Repository
public interface RBIRepository extends JpaRepository<RBIDomain, Long>{
	
	

}
