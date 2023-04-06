package com.imtcare.servicesImplementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imtcare.entities.Claim;
import com.imtcare.entities.InsurancePolicy;
import com.imtcare.exceptions.ClaimNotFoundException;
import com.imtcare.exceptions.PolicyNotFoundException;
import com.imtcare.repositories.ClaimRepository;
import com.imtcare.repositories.InsurancePolicyRepository;
import com.imtcare.services.ClaimServices;

@Service // This annotation is compulsory
public class ClaimServicesImplementation implements ClaimServices{

	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	@Override
	public Claim createNewClaim(Claim claim) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		
		InsurancePolicy claimPolicy= claim.getGivenInsurancePolicy();
		
		if(claimPolicy != null) {
			
			claimPolicy.getClaimSet().add(claim);
			
			claim.setGivenInsurancePolicy(claimPolicy);
			
			return claimRepository.save(claim);
		}
		else 
			
			throw new ClaimNotFoundException("");
	}

	@Override
	public List<Claim> fetchAllClaims() throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		
		List<Claim> allClaimDetails = claimRepository.findAll();  // get all claim details
		
		if(allClaimDetails.isEmpty()) {
			
			throw new ClaimNotFoundException("Sorry! No claim found for this policy");
		}
		
		return allClaimDetails;
	}

	@Override
	public Claim fetchClaimById(Integer claimId) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		
		return claimRepository.findById(claimId).orElseThrow(()-> new ClaimNotFoundException
				                          ("Client does not exist with client Id "+ claimId));
	}

	@Override
	public Claim updateClaimById(Integer claimId, Claim policyClaim) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		
		Claim updateClaim = claimRepository.findByClaimId(claimId);
		
		if(updateClaim != null) {
			
			// Setting updated values
			updateClaim.setClaimNumber(policyClaim.getClaimNumber());
			
			updateClaim.setClaimDate(policyClaim.getClaimDate());
			
			updateClaim.setClaimStatus(policyClaim.getClaimStatus());
			
			updateClaim.setDescription(policyClaim.getDescription());

			
			return claimRepository.save(updateClaim);
		}
		
		throw new ClaimNotFoundException("Sorry! No claim exists with the given claim Id "+ claimId);
		
	}

	@Override
	public Claim deleteClaimById(Integer claimId) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Claim> claimToBeDeleted = claimRepository.findById(claimId);
		
		if(claimToBeDeleted.isPresent()) {
			
			Claim deleteClaim = claimToBeDeleted.get(); // getting registered claim with given claim Id
			
			claimRepository.delete(deleteClaim); // delete registered claim with given claim Id
			
			return deleteClaim;
		}
		
		else 
			
			throw new ClaimNotFoundException("Sorry! No claim present with claim Id "+ claimId);

	}

}
