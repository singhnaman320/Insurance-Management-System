package com.imtcare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imtcare.entities.InsurancePolicy;
import com.imtcare.exceptions.PolicyNotFoundException;
import com.imtcare.services.InsurancePolicyServices;


@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyServices insurancePolicyServices;
	
	
	// Registering new policy
	
	@PostMapping("/")
	public ResponseEntity<InsurancePolicy> createNewInsurancePolicyHandler(@RequestBody InsurancePolicy insurancePolicy) 
																						throws PolicyNotFoundException{
		
		InsurancePolicy addPolicy = insurancePolicyServices.createNewInsurancePolicy(insurancePolicy);
		
		return new ResponseEntity<InsurancePolicy>(addPolicy, HttpStatus.CREATED);
	}
	
	
	// Getting all the policy details
	
	@GetMapping("/")
    public ResponseEntity<List<InsurancePolicy>> fetchAllInsurancepoliciesHandler() throws PolicyNotFoundException{
		
        List<InsurancePolicy> allpolicyDetails = insurancePolicyServices.fetchAllInsurancepolicies();
        
        return new ResponseEntity<List<InsurancePolicy>>(allpolicyDetails, HttpStatus.OK);
    }

	
	// getting policy details by Id
	
    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> fetchInsurancePolicyByIdHandler(@PathVariable("id") Integer policyId) 
    																				throws PolicyNotFoundException{
    	
        InsurancePolicy getpolicyById = insurancePolicyServices.fetchInsurancePolicyById(policyId);
        
        return new ResponseEntity<InsurancePolicy>(getpolicyById, HttpStatus.OK);
    }

    
    // Updating policy details by policy Id
    
    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updateInsurancePolicyByIdHandler(@PathVariable("id") Integer policyId, InsurancePolicy insurancePolicy)
    																													throws PolicyNotFoundException{
    	
        InsurancePolicy updatepolicy = insurancePolicyServices.updateInsurancePolicyById(policyId, insurancePolicy);
        
        return new ResponseEntity<InsurancePolicy>(updatepolicy, HttpStatus.ACCEPTED);
    }

    
    // Delete policy by policy Id
    
    @DeleteMapping("/{id}")
    public ResponseEntity<InsurancePolicy> deletePolicyByIDHandler(@PathVariable("id") Integer policyId) 
    																		throws PolicyNotFoundException{
    	
        InsurancePolicy deletePolicy = insurancePolicyServices.deleteInsurancePolicyById(policyId);
        
        return new ResponseEntity<InsurancePolicy>(deletePolicy, HttpStatus.OK);
    }
}
