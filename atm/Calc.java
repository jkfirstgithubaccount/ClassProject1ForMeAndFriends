package atm;


import java.awt.geom.Rectangle2D;

/**
 * @author admin
 *
 */
public class Calc {
	
	/**
	 * @param:
	 * City for this City-Object the value function will be calculated and written into the field value (District) 
	 * int function: 0 - average, 1 - function will be read in 
	 */
	void berechneWertefunktion(City city, int function){
		if (function == 0){
			System.out.println("Wert berechnen");
			for (int d=0; d<city.anzDist; d++){
				int avg=0;
				for (int i=0; i<city.anzAttr; i++){
					avg =+ city.ward.elementAt(d).attrV[i];
					System.out.println("in District "+d+" einlesen von Attribut "+i);
				}
				avg = avg/city.anzAttr;
				city.ward.elementAt(d).setFunktionswert(avg);
			}
		}
		else if (function == 1){
			System.out.println("Bitte Funktion zur Berechnung des Wertes eingeben");
		}
	}
	
	void einfachePos(City city, ATM atm){
		int min = 0;
		if (city.anzDist>atm.anzAtm) min=atm.anzAtm;
		else min=city.anzDist;
		
		for (int i=0; i<min; i++){
			Rectangle2D box = city.ward.elementAt(i).form.getBounds2D();
			atm.cashTerminal.elementAt(i).xPos = (int) box.getCenterX();
			atm.cashTerminal.elementAt(i).yPos = (int) box.getCenterY();
			atm.cashTerminal.elementAt(i).fWert = city.ward.firstElement().value;
		}
	}
	

}
