package com.ab.model;

import java.sql.Timestamp;

public class Film 
{
	/*
	 * ID, NUME_FILM, DESCRIERE, SALA_ID, PRET, GEN_FILM, DATA_SI_ORA_FILM
	 */ 

	
	
	private long id;
	private String numeFilm;
	private String descriere;
    private	String idSala;
    private String pret;
    private String genFilm;
    private Timestamp dataSiOra;
    
    
    
    // FARA ID - > PENTRU INSERT DE FILME ( HTTP. POST)
	public Film(String numeFilm, String descriere, String idSala, String pret, String genFilm, Timestamp dataSiOra) {
		super();
		this.numeFilm = numeFilm;
		this.descriere = descriere;
		this.idSala = idSala;
		this.pret = pret;
		this.genFilm = genFilm;
		this.dataSiOra = dataSiOra;
	}

	//CU ID - > PENTRU SELECT DIN BAZA ( HTTP. GET ) PENTRU A DUCE ID-ul inregistrarii pe front-end
	public Film(long id, String numeFilm, String descriere, String idSala, String pret, String genFilm,
			Timestamp dataSiOra) {
		super();
		this.id = id;
		this.numeFilm = numeFilm;
		this.descriere = descriere;
		this.idSala = idSala;
		this.pret = pret;
		this.genFilm = genFilm;
		this.dataSiOra = dataSiOra;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumeFilm() {
		return numeFilm;
	}
	public void setNumeFilm(String numeFilm) {
		this.numeFilm = numeFilm;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public String getIdSala() {
		return idSala;
	}
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	public String getPret() {
		return pret;
	}
	public void setPret(String pret) {
		this.pret = pret;
	}
	public String getGenFilm() {
		return genFilm;
	}
	public void setGenFilm(String genFilm) {
		this.genFilm = genFilm;
	}
	public Timestamp getDataSiOra() {
		return dataSiOra;
	}
	public void setDataSiOra(Timestamp dataSiOra) {
		this.dataSiOra = dataSiOra;
	}
    

    
    
}
