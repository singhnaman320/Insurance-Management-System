package com.imtcare.entities;

//enumerated class
public enum InsurancePolicyType {

	 HEALTH_INSURANCE("Health Insurance"),
	 
	 LIFE_INSURANCE("Term Life Insurance"),
	 
	 TRAVEL_INSURANCE("Travel Insurance"),
	 
	 HOME_NSURANCE("Home Insurance");

	 private final String insurancePolicy;

	 InsurancePolicyType(String insurancePolicy) {
		 
		 this.insurancePolicy = insurancePolicy;
	 }

	public String getInsurancePolicy() {
		return insurancePolicy;
	}

}
