package com.nttdata.spring.service;

import java.util.List;

import com.nttdata.spring.repsitory.Cliente;

/**
 * Para Hibernate.
 * 
 * */

public interface ClienteManagementServiceI {

	public void insertNewClient(final Cliente newClient);
	
	public void updateClient(final Cliente uptateClient);
	
	public void deleteClient(final Cliente deleteClient);
	
	public Cliente searchById(final int ClientId);
	
	public List<Cliente> searchByName(final String name);
	
	public List<Cliente> searchAll();
}

