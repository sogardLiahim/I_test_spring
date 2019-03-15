package com.ab.model;

public class ProdusClient 
{
	private String Nume;
	private String Cantitate;
	private String Pret;
	private String ID;
	private String Serie;
	private String Tara;
	
	
	
	ProdusClient(){System.out.println("INSTANTIAT!!");}
	
	
	
	public ProdusClient(String nume, String cantitate, String pret, String iD, String serie, String tara) {
		super();
		Nume = nume;
		Cantitate = cantitate;
		Pret = pret;
		ID = iD;
		Serie = serie;
		Tara = tara;
	}



	public String getNume() {
		return Nume;
	}
	public void setNume(String nume) {
		System.out.println("nume setat");
		Nume = nume;
	}
	public String getCantitate() {
		return Cantitate;
	}
	public void setCantitate(String cantitate) {
		Cantitate = cantitate;
	}
	public String getPret() {
		return Pret;
	}
	public void setPret(String pret) {
		Pret = pret;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSerie() {
		return Serie;
	}
	public void setSerie(String serie) {
		Serie = serie;
	}
	public String getTara() {
		return Tara;
	}
	public void setTara(String tara) {
		Tara = tara;
	}
}
