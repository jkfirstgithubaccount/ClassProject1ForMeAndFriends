package atm;

import java.util.Vector;

public class ATM {

	/**
	 * anzAtm ist Anzahl der Automaten, die zu positionieren sind 
	 * radAtm ist der Radius, den ein Automat abdeckt
	 * cashTerminal ist ein Vektor, der Terminals speichert und damit Position (xPos, yPos) und den erzielten Wert fWert
	 * 
	 */
	
	int anzAtm;
	int radAtm;
	Vector<Terminal> cashTerminal = new Vector<Terminal>();
	
	
	public ATM(){}

	void set(int anzahlAtm, int radiusAtm){
		anzAtm = anzahlAtm;
		radAtm = radiusAtm;
		
		for (int i = 0; i < anzAtm; i++){
			cashTerminal.add(new Terminal());
		}
	}
	
}





class Terminal{
	int xPos = 0;
	int yPos = 0;
	int fWert = 0;	
	
	void set(int x, int y, int functionsWert){
		xPos = x;
		yPos = y;
		fWert = functionsWert;
	}
	
	int getX(){
		return xPos;
	}
	int getY(){
		return yPos;
	}
	int getF(){
		return fWert;
	}
}
