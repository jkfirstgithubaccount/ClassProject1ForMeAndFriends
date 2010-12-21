package visual;

import java.awt.*;
import javax.swing.*;

import atm.*
;


public class CPanel extends JPanel{
	City stadt = new City(); 
	JPanel intern = new JPanel();

	public CPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	CPanel stadtZeichnen(City city){
		stadt = city;
		System.out.println("Bin Hier");
		this.setMinimumSize(new Dimension(500,500));

		return this;
	}
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setBounds(200, 150, 1000, 800);
		f.setTitle("I-Cup ATM CTest");
//		JDesktopPane desktopPane = new JDesktopPane();
//		f.getContentPane().add(desktopPane);
		DataMan mani = new DataMan();
		City stadt = mani.testMan("Beispiel");
		mani.print(stadt);
		CPanel can = new CPanel();
		can.stadtZeichnen(stadt);
		
		f.add(can);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		  g.drawString("Text", 20, 30);
		if (stadt.getAnzDist()== 0){
			JLabel stadtLeer = new JLabel("Stadt nicht initialisiert");
//			intern.removeAll();
//			intern.setBackground(Color.GREEN);
//			intern.add(stadtLeer, BorderLayout.CENTER);
			System.out.println("Bin Dort");
			g.drawString("Text", 20, 30);
		}
		else{
			g.setColor(Color.RED);
			System.out.println("Bin Da");
			for (int i = 0; i<stadt.getAnzDist(); i++){
				Polygon poly = stadt.getPoly(i);
				g.drawPolygon(poly);
			}
				
		}
		}
	
//	public void paint(Graphics g){
//		
//		if (stadt.getAnzDist()== 0){
//			JLabel stadtLeer = new JLabel("Stadt nicht initialisiert");
//			intern.removeAll();
//			intern.setBackground(Color.GREEN);
//			intern.add(stadtLeer, BorderLayout.CENTER);
//			System.out.println("Bin Dort");
//			g.drawString("Text", 20, 30);
//		}
//		else{
//			g.setColor(Color.RED);
//			System.out.println("Bin Da");
//			for (int i = 0; i<stadt.getAnzDist(); i++){
//				Polygon poly = stadt.getPoly(i);
//				g.drawPolygon(poly);
//			}
//				
//		}
//			
////		int [] xPos2 = {250, 500, 500, 250};
////		int [] yPos2 = {0, 0, 250, 250};
////		Polygon poly2 = new Polygon(xPos2, yPos2, 4);
////		g.fillPolygon(poly2);
//	}
}
