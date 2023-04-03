package com.imtcare.entities;

public enum PolicyClaimStatus {

	 RECEIVED("Received"),
	 
	 PENDING("Pending"),
	 
	 ACCEPTED("Accepted"),
	 
	 REJECTED("Rejected");

	 private final String claimStatus;

	 PolicyClaimStatus(String claimStatus) {
		 
		 this.claimStatus = claimStatus;
	 }

	 
	 public String getClaimStatus() {
		return claimStatus;
	}

}
