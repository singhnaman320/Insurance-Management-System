package com.imtcare.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.imtcare.entities.Claim;
import com.imtcare.exceptions.ClaimNotFoundException;
import com.imtcare.services.ClaimServices;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

	@Autowired
	private ClaimServices claimServices;
	
	
	// Registering claim on policy
	
	@PostMapping("/")
    public ResponseEntity<Claim> createNewClaimHandler(@Valid @RequestBody Claim claim) throws ClaimNotFoundException{
    	
        Claim addClaim = claimServices.createNewClaim(claim);
        
        return new ResponseEntity<Claim>(addClaim, HttpStatus.CREATED);
    }

	
	// Fetching all the claims
	
    @GetMapping("/")
    public ResponseEntity<List<Claim>> fetchAllClaimsHandler() throws ClaimNotFoundException{
    	
        List<Claim> allclaims = claimServices.fetchAllClaims();
        
        return new ResponseEntity<List<Claim>>(allclaims, HttpStatus.OK);
    }

    
    // Fetching claim details by claim Id
    
    @GetMapping("/{id}")
    public ResponseEntity<Claim> fetchClaimByIdHandler(@PathVariable("id") Integer claimId) throws ClaimNotFoundException{
    	
        Claim claimById = claimServices.fetchClaimById(claimId);
        
        return new ResponseEntity<Claim>(claimById, HttpStatus.OK);
    }

    
    // Updating claim details by claim Id
    
    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaimByIdHandler(@PathVariable("id") Integer claimId, @RequestBody Claim claim) throws ClaimNotFoundException{
    	
        Claim updateClaim = claimServices.updateClaimById(claimId, claim);
        
        return new ResponseEntity<Claim>(updateClaim, HttpStatus.ACCEPTED);
    }

    
    // Deleting claim by claim Id

    @DeleteMapping("/{id}")
    public ResponseEntity<Claim> deleteClaimByIDHandler(@PathVariable("id") Integer claimId) throws ClaimNotFoundException{
    	
        Claim deleteClaim = claimServices.deleteClaimById(claimId);
        
        return new ResponseEntity<>(deleteClaim, HttpStatus.OK);
    }
}
