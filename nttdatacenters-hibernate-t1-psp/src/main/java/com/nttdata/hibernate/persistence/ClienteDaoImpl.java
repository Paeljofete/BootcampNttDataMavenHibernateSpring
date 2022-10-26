package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * 
 * DAO de tabla NTTDATA_BOOTCAMP_CLIENTE
 * 
 * @author psaperez
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	/** Sesión de conexión a BD. */
	private Session session;

	/** Método constructor. */
	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	/** Método de búsqueda por nombre. */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByName(final String name) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Localiza clientes en función del nombre.
		final List<Cliente> clientList = session.createQuery("FROM Cliente WHERE name=" + name).list();

		return clientList;
	}
}
