package com.imtcare.servicesImplementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imtcare.entities.Client;
import com.imtcare.entities.InsurancePolicy;
import com.imtcare.exceptions.ClientNotFoundException;
import com.imtcare.exceptions.PolicyNotFoundException;
import com.imtcare.repositories.InsurancePolicyRepository;
import com.imtcare.services.InsurancePolicyServices;

@Service // This annotation is compulsory
public class InsurancePolicyServicesImplementation implements InsurancePolicyServices{

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	@Override
	public InsurancePolicy createNewInsurancePolicy(InsurancePolicy insurancePolicy) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		
		Set<Client> clients= insurancePolicy.getClientsSet();
		
		if(clients.isEmpty()) {
			
			throw new PolicyNotFoundException("Already found policy details with policy Id "+insurancePolicy.getPolicyId()
            +" in database. Please register with different policy.");
			
		}
		
		for(Client client : clients ){
			
			client.getInsurancePolicies().add(insurancePolicy); // associating each student with course
		}
		
		return insurancePolicyRepository.save(insurancePolicy);

	}

	@Override
	public List<InsurancePolicy> fetchAllInsurancepolicies() throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		
		List<InsurancePolicy> allPolicyDetails = insurancePolicyRepository.findAll();  // get all policy details
		
		if(allPolicyDetails.isEmpty()) {
			
			throw new PolicyNotFoundException("Sorry! No policy found in database");
		}
		
		return allPolicyDetails;
	}

	@Override
	public InsurancePolicy fetchInsurancePolicyById(Integer policyId) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		
		// Functional programming statement
		return insurancePolicyRepository.findById(policyId).orElseThrow(()-> new PolicyNotFoundException
				                                     ("Client does not exist with client Id "+ policyId));
		
	}

	@Override
	public InsurancePolicy updateInsurancePolicyById(Integer policyId, InsurancePolicy insurancePolicy)
			throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		
		InsurancePolicy policy= insurancePolicyRepository.findByPolicyId(policyId);
		
		if(policy != null) {
			
			// setting new values
			
			policy.setPolicyNumber(insurancePolicy.getPolicyNumber());
			
			policy.setPremium(insurancePolicy.getPremium());
			
			policy.setStartdate(insurancePolicy.getStartdate());
			
			policy.setEndDate(insurancePolicy.getEndDate());
			
			policy.setCoverageAmount(insurancePolicy.getCoverageAmount());
			
			policy.setType(insurancePolicy.getType());
			
			return insurancePolicyRepository.save(policy);
		}
		
		throw new PolicyNotFoundException("Sorry! No policy exists with the given Id "+policyId);
	}

	@Override
	public InsurancePolicy deleteInsurancePolicyById(Integer policyId) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<InsurancePolicy> policyToBeDeleted = insurancePolicyRepository.findById(policyId);
		
		if(policyToBeDeleted.isPresent()) {
			
			InsurancePolicy policy = policyToBeDeleted.get(); // getting registered policy with given policy Id
			
			insurancePolicyRepository.delete(policy); // delete registered policy with given policy Id
			
			return policy;
		}
		
		else 
			
			throw new PolicyNotFoundException("Sorry! No policy present with policy Id "+ policyId);
	}

}
