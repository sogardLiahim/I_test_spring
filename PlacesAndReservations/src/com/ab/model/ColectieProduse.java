package com.ab.model;

import java.util.ArrayList;
import java.util.List;

public class ColectieProduse {


	private List<Produs> colectieProduse = new ArrayList<Produs>();
	
	public ColectieProduse(List<Produs> colectieProduse) {
		super();
		this.colectieProduse = colectieProduse;
		
	}

	public List<Produs> getColectieProduse() {
		return colectieProduse;
	}

	public void setColectieProduse(List<Produs> colectieProduse) {
		this.colectieProduse = colectieProduse;
	}

	
}
