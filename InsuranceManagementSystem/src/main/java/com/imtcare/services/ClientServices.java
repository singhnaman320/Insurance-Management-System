package com.imtcare.services;

import java.util.List;

import com.imtcare.entities.Client;
import com.imtcare.exceptions.ClientNotFoundException;
import com.imtcare.exceptions.PolicyNotFoundException;

public interface ClientServices {

	// Create a new client
	public Client createNewClient(Integer policyNumber, Client client) throws ClientNotFoundException, PolicyNotFoundException;
		
	// Fetch all clients
	public List<Client> fetchAllClients()throws ClientNotFoundException;
		
	// Fetch a specific client by ID
	public Client fetchClientDetailsById(Integer clientId) throws ClientNotFoundException;
		
	// Update a client's information
	public Client updateClientById(Integer clientId, Client client) throws ClientNotFoundException;
		
	// Delete a client
	public Client deleteClientById(Integer clientId)throws ClientNotFoundException;
	
}
