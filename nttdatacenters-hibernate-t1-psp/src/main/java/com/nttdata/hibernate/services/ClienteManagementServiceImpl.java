package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.ClienteDaoI;
import com.nttdata.hibernate.persistence.ClienteDaoImpl;

/**
 * Implementación del servicio cliente.
 * 
 * @author psaperez
 *
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	/** DAO: NTTDATA_BOOTCAMP_CLIENTE. */
	private ClienteDaoI clientDao;

	/** Método constructor. */
	public ClienteManagementServiceImpl(final Session session) {
		this.clientDao = new ClienteDaoImpl(session);
	}

	@Override
	public void insertNewClient(final Cliente newClient) {
		// Verificación de la nulidad e inexistencia.
		if (newClient != null && newClient.getCLIENTE_ID() == null) {
			// Inserción.
			clientDao.insert(newClient);
		}
	}

	@Override
	public void updateClient(final Cliente updateClient) {
		// Verificación de nulidad y existencia.
		if (updateClient != null && updateClient.getCLIENTE_ID() != null) {
			// Actualización.
			clientDao.update(updateClient);
		}
	}

	@Override
	public void deleteClient(final Cliente deleteClient) {
		// Verificación de nulidad y existencia.
		if (deleteClient != null && deleteClient.getCLIENTE_ID() != null) {
			// Borrado.
			clientDao.delete(deleteClient);
		}
	}

	@Override
	public Cliente searchById(final Long clientId) {
		// Resultado.
		Cliente client = null;
		// Verificación de nulidad.
		if (clientId != null) {
			// Obtención por ID.
			client = clientDao.searchById(clientId);
		}
		return client;
	}

	@Override
	public List<Cliente> searchByName(final String name) {
		// Resultado.
		List<Cliente> clientList = new ArrayList<>();
		// Verificación de nulidad.
		if (StringUtils.isNotBlank(name)) {
			// Obtención por nombre.
			clientList = clientDao.searchByName(name);
		}
		return clientList;
	}

	@Override
	public List<Cliente> searchAll() {
		// Resultado.
		List<Cliente> clientList = new ArrayList<>();
		// Obtención de todos los clientes.
		clientList = clientDao.searchAll();

		return clientList;
	}
}
