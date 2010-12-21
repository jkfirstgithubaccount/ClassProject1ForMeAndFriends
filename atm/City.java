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

	/**
	 * @return the anzDist
	 */
	public int getAnzDist() {
		return anzDist;
	}

	/**
	 * @param anzDist the anzDist to set
	 */
	public void setAnzDist(int anzDist) {
		this.anzDist = anzDist;
	}

	/**
	 * @return the ward
	 */
	public Vector<District> getWard() {
		return ward;
	}
	/**
	 * @return the Polygon in Position i
	 */
	public Polygon getPoly(int i) {
		return ward.elementAt(i).form;
	}

	/**
	 * @param ward the ward to set
	 */
	public void setWard(Vector<District> ward) {
		this.ward = ward;
	}

	/**
	 * @return the anzAttr
	 */
	public int getAnzAttr() {
		return anzAttr;
	}

	/**
	 * @param anzAttr the anzAttr to set
	 */
	public void setAnzAttr(int anzAttr) {
		this.anzAttr = anzAttr;
	}

	/**
	 * @return the nameAttr
	 */
	public String[] getNameAttr() {
		return nameAttr;
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

