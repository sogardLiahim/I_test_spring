
package com.ab.model;

import java.util.ArrayList;
import java.util.List;

public class Produs 
{
	private int cantitate;
	private String numeProdus;
	private double pret;
	
	public static List<ProdusClient> produseClient = new ArrayList<ProdusClient>();
	
	
	public Produs(int cantitate, String numeProdus, double pret) {
		this.cantitate = cantitate;
		this.numeProdus = numeProdus;
		this.pret = pret;
	}
	
	
	public static void populateList() {
		produseClient.add(new ProdusClient("sampon shoulder shoulder","23","23","44","32","ffw"));
	}
	
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public String getNumeProdus() {
		return numeProdus;
	}
	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	
	
    

}
