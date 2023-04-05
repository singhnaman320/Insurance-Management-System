package com.imtcare.servicesImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imtcare.entities.Claim;
import com.imtcare.exceptions.ClaimNotFoundException;
import com.imtcare.services.ClaimServices;

@Service // This annotation is compulsory
public class ClaimServicesImplementation implements ClaimServices{

	
	@Override
	public Claim createNewClaim(Claim claim) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> fetchAllClaims() throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim fetchClaimById(Integer claimId) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim updateClaimById(Integer claimId, Claim claim) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim deleteClaimById(Integer claimId) throws ClaimNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
