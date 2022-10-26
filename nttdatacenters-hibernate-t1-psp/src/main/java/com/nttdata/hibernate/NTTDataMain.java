package com.nttdata.hibernate;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.services.ClienteManagementServiceI;
import com.nttdata.hibernate.services.ClienteManagementServiceImpl;

/**
 * Clase principal
 * 
 * @author psaperez
 *
 */
public class NTTDataMain {

	/**Método principal */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);

		// Generación de clientes.
		final Cliente cliente1 = new Cliente();
		cliente1.setCLIENTE_NAME("Héctor");
		cliente1.setCLIENTE_1SURNAME("Jimenez");
		cliente1.setCLIENTE_2SURNAME("Domínguez");
		cliente1.setCLIENTE_NID("128785");
		
		clienteService.insertNewClient(cliente1);
		
		// Consultas (JPA Criteria)
	//	List<Cliente> client = clienteService.searchByName("E%");

	/*	for (final Cliente cliente : client) {
			System.out.println(
					cliente.getCLIENTE_NAME() + " - " + cliente.getCLIENTE_1SURNAME() + " - " + cliente.getCLIENTE_2SURNAME() + ".");
		}*/
		
		// Cierre de sesión.
		session.close();
	}
}