package com.imtcare.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
@Table(name = "Clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clientId;
	
	// reading validation messages from messages.properties in src/main/resources
	
	@NotNull(message = "{name.invalid}")
	@NotBlank(message = "{name.invalid}")
	@NotEmpty(message = "{name.invalid}")
	@Size(min = 2, max = 15)
	private String name;
	
	@NotNull(message = "{dateOfBirth.invalid}")
	@NotBlank(message = "{dateOfBirth.invalid}")
	@NotEmpty(message = "{dateOfBirth.invalid}")
	private LocalDateTime dateOfBirth; 
	
	@NotNull(message = "{address.invalid}")
	@NotBlank(message = "{address.invalid}")
	@NotEmpty(message = "{address.invalid}")
	private String address;
	
	@NotNull(message = "{email.invalid}")
	@NotBlank(message = "{email.invalid}")
	@NotEmpty(message = "{email.invalid}")
	private String email;
	
	@NotNull(message = "{mobileNumber.invalid}")
	@NotBlank(message = "{mobileNumber.invalid}")
	@NotEmpty(message = "{mobileNumber.invalid}")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String mobileNumber;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "clientsSet")
	private Set<InsurancePolicy> insurancePolicies= new HashSet<>();
	
	
}
