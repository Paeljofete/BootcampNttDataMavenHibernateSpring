package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * 
 * DAO genérico
 * 
 * @author psaperez
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/** Método constructor. */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	/** Método de inserción. */
	@Override
	public void insert(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción.
		session.save(paramT);
		session.flush();

		// Guardado.
		session.getTransaction().commit();
	}

	/** Método de actualización. */
	@Override
	public void update(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Cambiado.
		session.saveOrUpdate(paramT);

		// Guardado.
		session.getTransaction().commit();
	}

	/** Método de borrado. */
	@Override
	public void delete(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Borrado.
		session.delete(paramT);

		// Guardado.
		session.getTransaction().commit();
	}

	/** Método de búsqueda por ID. */
	@Override
	public T searchById(final Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por ID.
		T result = session.get(this.entityClass, id);

		return result;
	}

	/** Método de búsqueda completa. */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;
	}

	/** @return the entityClass. */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/** @param entityClass the entityClass to set. */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
