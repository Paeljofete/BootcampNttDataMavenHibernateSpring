package com.nttdata.spring.repsitory;

import java.util.Date;

public class Cliente {

	private int id;
	private String name;
	private String surname;
	private Date born;
	private String nid;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Date getBorn() {
		return born;
	}
	public String getNid() {
		return nid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
}
