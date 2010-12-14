package atm;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Vector;

public class City {
	//**
	// Liste der Polygone
	int anzDist; //Anzahl der Stadtteile
	Vector<District> ward = new Vector<District>();// ?? Liste Polygone
	
	
	// Wertefunktion
	int anzAttr; //Anzahl der Attribute
	String[] nameAttr; // Name der Attribute
	
	public City (){
	}
	
	boolean setDistrict(Polygon poly, int anzAttribut, int[] attrWert){
		District distr = new District(poly, attrWert);
		ward.add(distr);
		return true;
	}
	
	boolean setDistricts(int anzDistrict, ArrayList<Polygon> liste, int anzAttr, int[] attrWert){
		anzDist = anzDistrict;
//		int k = 0;
		int[] actWert = new int[anzAttr];
		for (int i = 0; i<anzDist; i++){
			for (int j = 0; j<anzAttr; j++){
				actWert[j] = attrWert[i*anzAttr+j];
//				k++;
			}
			new District(liste.get(i), actWert);
		}
		return true;
	}
	
}

class District{
	Polygon form;
	int[] attrV;
	int value = 0;
	
	public District(Polygon poly, int[] attrWert){
		form = poly;
		attrV = attrWert;
	}
	
	void setFunktionswert(int wert){
		value = wert;
	}
}

