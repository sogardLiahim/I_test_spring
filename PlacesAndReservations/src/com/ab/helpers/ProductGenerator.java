package com.ab.helpers;

import java.util.ArrayList;
import java.util.List;

import com.ab.model.Produs;

public class ProductGenerator 
{
	
	public static List<Produs> populateList() {
        
		List<Produs> a = new ArrayList<Produs>();
		a.add(new Produs(2, "NOKIA 4", 300.324));
		a.add(new Produs(30, "IPHONE 5", 6999));
		a.add(new Produs(400, "HUAWEI", 45353));
		a.add(new Produs(1999, "LG", 23999));
		return a;
	}

}
