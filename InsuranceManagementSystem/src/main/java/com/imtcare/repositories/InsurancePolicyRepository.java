package com.imtcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imtcare.entities.InsurancePolicy;

@Repository  //Repository annotation is optional here
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>{

	public InsurancePolicy findByPolicyNumber(Integer policyNumber);
	
}
