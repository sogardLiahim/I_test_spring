package com.ab.model;



public class User {
	
	private String nume;
	private String varsta;
	
	
	public User(String nume, String varsta) {
		super();
		this.nume = nume;
		this.varsta = varsta;
	}
	
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getVarsta() {
		return varsta;
	}
	public void setVarsta(String varsta) {
		this.varsta = varsta;
	}
	
	

}
