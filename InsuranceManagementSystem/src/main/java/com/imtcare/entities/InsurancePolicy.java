package com.imtcare.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Policies")
public class InsurancePolicy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policyId;
    
    // reading validation messages from messages.properties in src/main/resources
    
    @NotNull(message = "{policyNumber.invalid}")
    @NotBlank(message = "{policyNumber.invalid}")
    @NotEmpty(message = "{policyNumber.invalid}")
	private Integer policyNumber;
    
    @NotNull(message = "{policyType.invalid}")
    @NotBlank(message = "{policyType.invalid}")
    @NotEmpty(message = "{policyType.invalid}")
	private String type;
    
    @NotNull(message = "{coverageAmount.invalid}")
    @NotBlank(message = "{coverageAmount.invalid}")
    @NotEmpty(message = "{coverageAmount.invalid}")
	private Double coverageAmount;
    
    @NotNull(message = "{premium.invalid}")
    @NotBlank(message = "{premium.invalid}")
    @NotEmpty(message = "{premium.invalid}")
	private Double premium;
    
    @NotNull(message = "{startdate.invalid}")
    @NotBlank(message = "{startdate.invalid}")
    @NotEmpty(message = "{startdate.invalid}")
	private LocalDate startdate;
    
    @NotNull(message = "{Please provide a suitable end date}")
    @NotBlank(message = "{Please provide a suitable end date}")
    @NotEmpty(message = "{Please provide a suitable end date}")
	private LocalDate endDate;
    
    @JsonIgnore
    @OneToMany(mappedBy = "givenInsurancePolicy", cascade = CascadeType.ALL)
    private List<Claim> claimsList= new ArrayList<>();
    

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ClientPolicies", joinColumns = {@JoinColumn(name="policyId")}, inverseJoinColumns= {@JoinColumn(name="clientId")})
    private List<Client> clientsList = new ArrayList<>();
    
}
