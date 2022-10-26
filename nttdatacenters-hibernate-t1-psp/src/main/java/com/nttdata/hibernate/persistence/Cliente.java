package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entidad de la tabla NTTDATA_BOOTCAMP_CLIENTE.
 * 
 * @author psaperez
 *
 */
@Entity
@Table(name = "NTTDATA_BOOTCAMP_CLIENTE")
public class Cliente extends AbstractEntity implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENTE_ID")
	private Long cliente_id;

	@Column(name = "CLIENTE_NAME")
	private String cliente_name;

	@Column(name = "CLIENTE_1SURNAME")
	private String cliente_1surname;

	@Column(name = "CLIENTE_2SURNAME")
	private String cliente_2surname;

	@Column(name = "CLIENTE_NID", unique = true, nullable = false, length = 9)
	private String cliente_nid;

	public Cliente() {
		
	}
	
	public Cliente(Long cLIENTE_ID, String cLIENTE_NAME, String cLIENTE_1SURNAME, String cLIENTE_2SURNAME,
			String cLIENTE_NID) {
		super();
		cliente_id = cLIENTE_ID;
		cliente_name = cLIENTE_NAME;
		cliente_1surname = cLIENTE_1SURNAME;
		cliente_2surname = cLIENTE_2SURNAME;
		cliente_nid = cLIENTE_NID;
	}

	public Long getCLIENTE_ID() {
		return cliente_id;
	}

	public String getCLIENTE_NAME() {
		return cliente_name;
	}

	public String getCLIENTE_1SURNAME() {
		return cliente_1surname;
	}

	public String getCLIENTE_2SURNAME() {
		return cliente_2surname;
	}

	public String getCLIENTE_NID() {
		return cliente_nid;
	}

	public void setCLIENTE_ID(Long cLIENTE_ID) {
		cliente_id = cLIENTE_ID;
	}

	public void setCLIENTE_NAME(String cLIENTE_NAME) {
		cliente_name = cLIENTE_NAME;
	}

	public void setCLIENTE_1SURNAME(String cLIENTE_1SURNAME) {
		cliente_1surname = cLIENTE_1SURNAME;
	}

	public void setCLIENTE_2SURNAME(String cLIENTE_2SURNAME) {
		cliente_2surname = cLIENTE_2SURNAME;
	}

	public void setCLIENTE_NID(String cLIENTE_NID) {
		cliente_nid = cLIENTE_NID;
	}

	@Transient
	public Class<?> getClase() {
		return Cliente.class;
	}

	@Override
	public Long getId() {
		return this.cliente_id;
	}

	@Override
	public void setId(Long id) {
		this.cliente_id = id;
	}

	@Override
	public String toString() {
		return "Cliente [CLIENTE_ID=" + cliente_id + ", CLIENTE_NAME=" + cliente_name + ", CLIENTE_1SURNAME="
				+ cliente_1surname + ", CLIENTE_2SURNAME=" + cliente_2surname + ", CLIENTE_NID=" + cliente_nid + "]";
	}
}
