package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;

/**
 * Interfaz del servicio cliente.
 * 
 * @author psaperez
 *
 */
public interface ClienteManagementServiceI {

	/** Inserta un nuevo cliente. */
	public void insertNewClient(final Cliente newCliente);

	/** Actualiza un cliente existente. */
	public void updateClient(final Cliente updateClient);

	/** Elimina un cliente existente. */
	public void deleteClient(final Cliente deleteClient);

	/** Obtiene un cliente por ID. */
	public Cliente searchById(final Long clientId);

	/** Obtiene un cliente por el nombre. */
	public List<Cliente> searchByName(final String name);

	/** Obtienen todos los clientes. */
	public List<Cliente> searchAll();
}
