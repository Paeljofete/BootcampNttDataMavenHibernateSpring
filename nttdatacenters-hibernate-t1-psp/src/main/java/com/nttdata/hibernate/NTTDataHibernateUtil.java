package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NTTDataHibernateUtil {

	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/** Constructor privado. */
	private NTTDataHibernateUtil() {
	}

	/** Generación de factoría de sesiones. */
	static {
		try {
			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (final Exception ex) {
			// Error de inicialización.
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			ex.getMessage();
			throw new ExceptionInInitializerError(ex);
		}
	}

	/** Devuelve la factoría de sesiones. */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
