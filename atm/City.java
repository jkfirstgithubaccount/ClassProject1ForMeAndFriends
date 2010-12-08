package atm;

import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class City {
	//**
	// Liste der Polygone
	int anzPoly; //Anzahl der Stadtteile
	int[][] xyPoly;
	ArrayList<Polygon> ward = new ArrayList<Polygon>();// ?? Liste Polygone
	
	// Anzahl der Automaten
	int anzAtm; // Anzahl der Automaten
	int radAtm; // Radius der Automaten
	
	// Wertefunktion
	int anzAttr; //Anzahl der Attribute
	String[] nameAttr; // Name der Attribute
	
	
	public City (){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		City Stadt = new City();
		Stadt.ReadIn("Set1.txt");
		Stadt.print();
		
		City Dorf = new City();
		Dorf.ReadIn("Set2.txt");
		Dorf.print();
		
		// Stadt.neuWertefunktion; ? über Config-File einlesen?
		// Stadt.setzeAutomaten;
		// WriteFile(Stadt);
	}
	
	
	
	/**
	 * @param Filename
	 * @return
	 */

	void print(){
		int i =0;
		System.out.print("Die Stadt besteht aus "+ anzPoly +" Stadtteilen.");
		for (i=0; i< anzPoly; i++){
			System.out.print("\n"+anzPoly +". Stadtteil in x-y-Koordinaten: ");
			System.out.print(ward.get(i).npoints+"-Eck  ");
			for (int j=0; j<ward.get(i).npoints; j++)
				System.out.print(ward.get(i).xpoints[j] +"|"+ward.get(i).ypoints[j] +"   ");
			
		}
//		for (i=0; i<xyPoly.length; i++) //Werte des letzten Polygons
//			System.out.print(xyPoly[i][0] +"|"+xyPoly[i][1] +"   ");
		System.out.print("\n"+anzAttr+" Attribute: ");
		for (i =0; i<nameAttr.length-1; i++)
			System.out.print(nameAttr[i]+", ");
		System.out.println(nameAttr[i]);
		System.out.println("Es sollen "+anzAtm+" Automaten mit Radius "+radAtm+" aufgestellt werden.");
	}
	
	void ReadIn(String Filename){
		try{
			FileReader file = new FileReader(Filename);
			BufferedReader br = new BufferedReader(file);
			String zeile;
			
			//Attribute einlesen
			zeile=br.readLine();
			String Zahl = zeile.trim();
			if (Zahl.contains(".")) 
				System.out.println("Falsches Format");
			anzAttr = Integer.parseInt(Zahl);
			nameAttr = new String[anzAttr];
			for (int i=0; i<anzAttr; i++){
				zeile=br.readLine();
				nameAttr[i]=zeile.trim();
			}
			
			//Polygone einlesen
			zeile=br.readLine();
			Zahl = zeile.trim();
			if (Zahl.contains(".")) 
				System.out.println("Falsches Format");
			anzPoly = Integer.parseInt(Zahl);
			for (int i=0; i<anzPoly; i++){
				//Anzahl der Ecken des Polygons
				zeile=br.readLine();
				//
				Zahl = zeile.trim();
				if (Zahl.contains(".")) 
					System.out.println("Falsches Format");
				int anzEcke = Integer.parseInt(Zahl);
				xyPoly = new int[anzEcke][2];
				int[] xPoly = new int[anzEcke];
				int[] yPoly = new int[anzEcke];
				//Koordinaten der Polygonecken
				zeile=br.readLine();
				String[] zahlen = zeile.split(" ");
				if (zahlen.length/2 == anzEcke){
					int k = 0;
					for (int j=0; j< anzEcke; j++){
						xyPoly[j][0] = Integer.parseInt(zahlen[k]);
						xPoly[j] = Integer.parseInt(zahlen[k]);
						k++;
						xyPoly[j][1] = Integer.parseInt(zahlen[k]);
						yPoly[j] = Integer.parseInt(zahlen[k]);
						k++;
					}
					Polygon part = new Polygon(xPoly, yPoly, anzEcke);
					ward.add(part);
				}
				else System.out.println("Falsches Format!");
				//Attributwerte
				zeile=br.readLine();
				
			}
			
			//Bankautomaten einlesen
			zeile=br.readLine();
			Zahl = zeile.trim();
			if (Zahl.contains(".")) 
				System.out.println("Falsches Format");
			anzAtm = Integer.parseInt(Zahl);
			zeile=br.readLine();
			Zahl = zeile.trim();
			if (Zahl.contains(".")) 
				System.out.println("Falsches Format");
			radAtm = Integer.parseInt(Zahl);
			
		
			br.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("\nFile erfolgreich eingelesen...\n");
		//return new City();
	}	
}


