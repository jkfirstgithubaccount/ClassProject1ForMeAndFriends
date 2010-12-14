package atm;

import java.awt.Polygon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataMan {

	public DataMan(){
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		City Stadt = new City();
		ATM Automat = new ATM();
		DataMan manipul = new DataMan();
		Calc calcul = new Calc();
		manipul.readFile("Set1.txt", Stadt, Automat);
		calcul.berechneWertefunktion(Stadt, 0);
		calcul.einfachePos(Stadt, Automat);
		manipul.print(Stadt);
		manipul.print(Automat);
		manipul.writeFile("Set1_log.txt", Automat);
		
		City Dorf = new City();
		ATM Auto = new ATM();
		manipul.readFile("Set2.txt", Dorf, Auto);
		manipul.print(Dorf);
		manipul.print(Auto);
		manipul.writeFile("Set2_log.txt", Auto);
	}
	
	boolean readFile(String Filename, City city, ATM atm){
		int anzP, anzA, rad; // Hilfsvariablen
		
		try{
			FileReader file = new FileReader(Filename);
			BufferedReader br = new BufferedReader(file);
			String zeile;
			
			//Attribute einlesen
			zeile=br.readLine();
			String Zahl = zeile.trim();
			city.anzAttr = Integer.parseInt(Zahl);
			city.nameAttr = new String[city.anzAttr];
			for (int i=0; i<city.anzAttr; i++){
				zeile=br.readLine();
				city.nameAttr[i]=zeile.trim();
			}
			
			//Polygone einlesen
			zeile=br.readLine();
			Zahl = zeile.trim();
			anzP = Integer.parseInt(Zahl);
			city.anzDist = anzP;
			for (int i=0; i<anzP; i++){
				//Anzahl der Ecken des Polygons
				zeile=br.readLine();
				//
				Zahl = zeile.trim();
				int anzEcke = Integer.parseInt(Zahl);
				int[] xPoly = new int[anzEcke];
				int[] yPoly = new int[anzEcke];
				//Koordinaten der Polygonecken
				zeile=br.readLine();
				String[] zahlen = zeile.split(" ");
				Polygon part = new Polygon();
				if (zahlen.length/2 == anzEcke){
					int k = 0;
					for (int j=0; j< anzEcke; j++){
						xPoly[j] = Integer.parseInt(zahlen[k]);
						k++;
						yPoly[j] = Integer.parseInt(zahlen[k]);
						k++;
					}
					part = new Polygon(xPoly, yPoly, anzEcke);					
//					city.ward.add(part);
				}
				else System.out.println("Falsches Format!");
				//Attributwerte
				zeile=br.readLine();
				String[] txtAttr = zeile.split(" ");
				int[] attrWert = new int[txtAttr.length];
				for (int j=0; j<txtAttr.length; j++){
					attrWert[j] = Integer.parseInt(txtAttr[j]);
				}
				city.setDistrict(part, city.anzAttr, attrWert);
				
			}
			
			//Bankautomaten einlesen
			zeile=br.readLine();
			Zahl = zeile.trim();
			anzA = Integer.parseInt(Zahl);
			zeile=br.readLine();
			Zahl = zeile.trim();
			rad = Integer.parseInt(Zahl);
			atm.set(anzA, rad);
					
			br.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("\nFile erfolgreich eingelesen...\n");
		//return new City();
		return true;
	}
	
	boolean writeFile(String Filename, ATM atms){
		BufferedWriter outPut;
		try{
			outPut = new BufferedWriter( new FileWriter(Filename));
			System.out.println(" Die "+atms.anzAtm+" Automaten mit Radius "+atms.radAtm+" haben folgende Koordinaten:");
			for (int i = 0; i<atms.cashTerminal.size(); i++){
				try{
					outPut.write(atms.cashTerminal.elementAt(i).getX()+" "+atms.cashTerminal.elementAt(i).yPos);
					outPut.newLine();
					outPut.write(atms.cashTerminal.elementAt(i).getF()+" ");
					outPut.newLine();
				}
				catch( IOException e){
					System.out.println("Fehler beim Schreiben in File.");
				}
				System.out.println(atms.cashTerminal.elementAt(i).getX()+" "+atms.cashTerminal.elementAt(i).yPos);
				System.out.println(atms.cashTerminal.elementAt(i).fWert);
			}
			try{
				outPut.close();
			}
			catch( IOException e){
				System.out.println("Fehler beim Schließen des Files");
			}
		}
		catch(IOException e){
			System.out.println("Output-File konnte nicht generiert werden");
		}
		return true;
	}
	
	void print(City city){
		int i =0;
		System.out.print("Die Stadt besteht aus "+ city.ward.size()+" Stadtteilen.");
		for (i=0; i< city.ward.size(); i++){
			System.out.print("\n"+(i+1)+". Stadtteil in x-y-Koordinaten: ");
			System.out.print(city.ward.get(i).form.npoints+"-Eck  ");
			for (int j=0; j<city.ward.get(i).form.npoints; j++)
				System.out.print(city.ward.get(i).form.xpoints[j] +"|"+city.ward.get(i).form.ypoints[j] +"   ");
//			for (i=0; i<xyPoly.length; i++) //Werte des letzten Polygons
//			System.out.print(xyPoly[i][0] +"|"+xyPoly[i][1] +"   ");
		}
		System.out.print("\n"+city.anzAttr+" Attribute: ");
		for (i =0; i<city.nameAttr.length-1; i++)
			System.out.print(city.nameAttr[i]+", ");
		System.out.println(city.nameAttr[i]);
		
	}

	void print(ATM atm){
		System.out.println("Es sollen "+atm.anzAtm+" Automaten mit Radius "+atm.radAtm+" aufgestellt werden.");
	}
}
