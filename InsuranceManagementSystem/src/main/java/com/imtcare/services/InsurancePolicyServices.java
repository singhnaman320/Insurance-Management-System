package com.imtcare.services;

import java.util.List;

import com.imtcare.entities.InsurancePolicy;
import com.imtcare.exceptions.PolicyNotFoundException;

public interface InsurancePolicyServices {

	// Create a new insurance policy
	public InsurancePolicy createNewInsurancePolicy(InsurancePolicy insurancePolicy) throws PolicyNotFoundException;
			
	// Fetch all insurance policies
	public List<InsurancePolicy> fetchAllInsurancepolicies()throws PolicyNotFoundException;
			
	// Fetch a specific insurance policy by ID
	public InsurancePolicy fetchInsurancePolicyById(Integer policyId) throws PolicyNotFoundException;
			
	// Update an insurance policy
	public InsurancePolicy updateInsurancePolicyById(Integer policyId, InsurancePolicy insurancePolicy) 
			throws PolicyNotFoundException;
			
	// Delete an insurance policy
	public InsurancePolicy deleteInsurancePolicyById(Integer policyId)throws PolicyNotFoundException;
}
