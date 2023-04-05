package com.imtcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imtcare.entities.Client;

@Repository  //Repository annotation is optional here
public interface ClientRepository extends JpaRepository<Client, Integer>{

	public Client findByClientId(Integer clientId);
}
