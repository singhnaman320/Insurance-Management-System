package com.imtcare.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Claims")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer claimId;
	
	// reading validation messages from messages.properties in src/main/resources
	
	@NotNull(message = "{claimNumber.invalid}")
	@NotEmpty(message = "{claimNumber.invalid}")
	@NotBlank(message = "{claimNumber.invalid}")
	private Integer claimNumber;
	
	@NotNull(message = "{description.invalid}")
	@NotEmpty(message = "{description.invalid}")
	@NotBlank(message = "{description.invalid}")
	private String description;
	
	@NotNull(message = "{claimDate.invalid}")
	@NotEmpty(message = "{claimDate.invalid}")
	@NotBlank(message = "{claimDate.invalid}")
	private LocalDate claimDate;
	
	@NotNull(message = "{claimStatus.invalid}")
	@NotEmpty(message = "{claimStatus.invalid}")
	@NotBlank(message = "{claimStatus.invalid}")
	@Enumerated(EnumType.STRING)
	private PolicyClaimStatus claimStatus;
	
	@ManyToOne
	@JoinColumn(name = "policyId")
	private InsurancePolicy givenInsurancePolicy;
}
