package com.imtcare.services;

import java.util.List;

import com.imtcare.entities.Claim;
import com.imtcare.exceptions.ClaimNotFoundException;

public interface ClaimServices {

	// Create a new claim
	public Claim createNewClaim(Claim claim) throws ClaimNotFoundException;
	
	// Fetch all claims
	public List<Claim> fetchAllClaims()throws ClaimNotFoundException;
	
	// Fetch a specific claim by ID
	public Claim fetchClaimById(Integer claimId) throws ClaimNotFoundException;
	
	// Update a claim's information
	public Claim updateClaimById(Integer claimId, Claim policyClaim) throws ClaimNotFoundException;
	
	// Delete a claim
	public Claim deleteClaimById(Integer claimId)throws ClaimNotFoundException;
}
