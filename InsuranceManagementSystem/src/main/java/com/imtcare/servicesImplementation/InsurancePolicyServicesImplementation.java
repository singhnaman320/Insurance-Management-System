package com.imtcare.servicesImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imtcare.entities.InsurancePolicy;
import com.imtcare.exceptions.PolicyNotFoundException;
import com.imtcare.services.InsurancePolicyServices;

@Service // This annotation is compulsory
public class InsurancePolicyServicesImplementation implements InsurancePolicyServices{

	
	@Override
	public InsurancePolicy createNewInsurancePolicy(InsurancePolicy insurancePolicy) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InsurancePolicy> fetchAllInsurancepolicies() throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsurancePolicy fetchInsurancePolicyById(Integer policyId) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsurancePolicy updateInsurancePolicyById(Integer policyId, InsurancePolicy insurancePolicy)
			throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsurancePolicy deleteInsurancePolicyById(Integer policyId) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
