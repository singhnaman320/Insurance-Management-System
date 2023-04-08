package com.imtcare.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imtcare.entities.Client;
import com.imtcare.exceptions.ClientNotFoundException;
import com.imtcare.exceptions.PolicyNotFoundException;
import com.imtcare.services.ClientServices;

@RestController // @Controller + @ResponseBody
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private  ClientServices clientServices;
	
	
	// Registering new client 
	
	@PostMapping("/")
    public ResponseEntity<Client> createNewClientHandler( @RequestParam Integer policyNumber, @RequestBody Client client) throws ClientNotFoundException, PolicyNotFoundException{
		
        Client newclient = clientServices.createNewClient(policyNumber, client);
        
        return new ResponseEntity<Client>(newclient, HttpStatus.CREATED);
    }

	
	// Fetching all the clients
	
    @GetMapping("/")
    public ResponseEntity<List<Client>> fetchAllClientsHandler() throws ClientNotFoundException{
    	
        List<Client> allClients = clientServices.fetchAllClients();
        
        return new ResponseEntity<List<Client>>(allClients, HttpStatus.OK);
    }

    
    // Fetching particular client by Id
    
    @GetMapping("/{id}")
    public ResponseEntity<Client> fetchClientDetailsByIdHandler(@PathVariable("id") Integer clientId) throws ClientNotFoundException{
    	
        Client clientById = clientServices.fetchClientDetailsById(clientId);
        
        return new ResponseEntity<Client>(clientById, HttpStatus.OK);
    }

    
    // Updating client by Id
    
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClientDetailsByIdHandler(@PathVariable("id") Integer clientId, @RequestBody Client client) throws ClientNotFoundException{
    	
        Client client1 = clientServices.updateClientById(clientId, client);
        
        return new ResponseEntity<>(client1,HttpStatus.ACCEPTED);
    }

    
    // Deleting client by Id

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClientByIDHandler(@PathVariable("id") Integer clientId) throws ClientNotFoundException{
    	
        Client res = clientServices.deleteClientById(clientId);
        
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
