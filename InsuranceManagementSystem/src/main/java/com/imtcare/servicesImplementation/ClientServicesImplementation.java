package com.imtcare.servicesImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imtcare.entities.Client;
import com.imtcare.entities.InsurancePolicy;
import com.imtcare.exceptions.ClientNotFoundException;
import com.imtcare.exceptions.PolicyNotFoundException;
import com.imtcare.repositories.ClientRepository;
import com.imtcare.repositories.InsurancePolicyRepository;
import com.imtcare.services.ClientServices;

@Service // This annotation is compulsory
public class ClientServicesImplementation implements ClientServices{

	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;
	
	@Override
	public Client createNewClient(Integer policyNumber, Client client) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		
		// First check for the policy number, if exists or not
		// If policy exists then only a client can be attached to policy
		
		InsurancePolicy insurancePolicy= insurancePolicyRepository.findByPolicyNumber(policyNumber);
		
		if(insurancePolicy != null) {
			
			// assigning clients to policy and vice versa
			
			insurancePolicy.getClientsSet().add(client);
			client.getInsurancePolicies().add(insurancePolicy);
			
			return clientRepository.save(client);
			
		}else {
			
			throw new PolicyNotFoundException("Sorry! No policy exist with policy number "+policyNumber);
		}
	}

	@Override
	public List<Client> fetchAllClients() throws ClientNotFoundException {
		// TODO Auto-generated method stub
		
		List<Client>allClientDetails= clientRepository.findAll();  // get all client details
		
		if(allClientDetails.isEmpty()) {
			
			throw new ClientNotFoundException("Sorry! No client found in database");
		}
		return allClientDetails;
	}

	@Override
	public Client fetchClientDetailsById(Integer clientId) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		
		// Functional programming statement
		//return clientRepository.findById(clientId).orElseThrow(()-> new ClientNotFoundException("Client does not exist with client Id "+ clientId));
		
		Optional<Client> clientById= clientRepository.findById(clientId);
		
		if(clientById.isPresent()) {
			
			return clientById.get();  // return client details
		}
		throw new ClientNotFoundException("Client does not exist with client Id "+ clientId);
	}

	@Override
	public Client updateClientById(Integer clientId, Client client) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		
		Client presentClient= clientRepository.findByClientId(clientId);
		
		if(presentClient != null) {
			
			// setting new values
			
			presentClient.setName(client.getName());
			presentClient.setMobileNumber(client.getMobileNumber());
			presentClient.setEmail(client.getEmail());
			presentClient.setDateOfBirth(client.getDateOfBirth());
			presentClient.setAddress(client.getAddress());
			presentClient.setInsurancePolicies(client.getInsurancePolicies());
			
			return clientRepository.save(presentClient);
		}
		
		throw new ClientNotFoundException("Sorry! No client present with the given Id "+clientId);
	}

	@Override
	public Client deleteClientById(Integer clientId) throws ClientNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Client> clientToBeDeleted= clientRepository.findById(clientId);
		
		if(clientToBeDeleted.isPresent()) {
			
			Client registeredClient = clientToBeDeleted.get(); // getting registered client with given Id 
			clientRepository.delete(registeredClient); // delete registered client with given d
			
			return registeredClient; // return deleted client
			
		}else
			
			throw new ClientNotFoundException("Unable to delete client details with client Id "+ clientId);

	}

}
