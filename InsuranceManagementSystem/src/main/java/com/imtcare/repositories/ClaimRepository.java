package com.imtcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imtcare.entities.Claim;
import com.imtcare.entities.InsurancePolicy;

@Repository //Repository annotation is optional here
public interface ClaimRepository extends JpaRepository<Claim, Integer>{

	public Claim findByClaimId(Integer claimId); // self implemented by JpaRepository
}
