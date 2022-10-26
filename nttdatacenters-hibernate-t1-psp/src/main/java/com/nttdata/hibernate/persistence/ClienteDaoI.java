package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * 
 * DAO de tabla NTTDATA_BOOTCAMP_CLIENTE
 * 
 * @author psaperez
 *
 */
public interface ClienteDaoI extends CommonDaoI<Cliente> {

	/** Obtiene clientes por nombre. */
	public List<Cliente> searchByName(final String name);

}
