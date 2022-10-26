package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * 
 * DAO genérico
 * 
 * @author psaperez
 *
 */
public interface CommonDaoI<T> {

	/** Inserta un registro en BBDD. */
	public void insert(final T paramT);

	/** Búsqueda de todos los registros en BBDD. */
	public List<T> searchAll();

	/** Localiza un registro por ID en BBDD. */
	public T searchById(final Long id);

	/** Elimina un registro en BBDD. */
	public void delete(final T paramT);

	/** Actualiza un registro en BBDD. */
	public void update(final T paramT);
}
