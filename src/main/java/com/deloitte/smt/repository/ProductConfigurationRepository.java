package com.deloitte.smt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.smt.entity.ProductConfiguration;

/**
 * Created by Rajesh on 24-02-2019.
 */
@Repository
public interface ProductConfigurationRepository  extends JpaRepository<ProductConfiguration, Long> {

	ProductConfiguration findByProductKey(String productKey);
	
		
	
}
