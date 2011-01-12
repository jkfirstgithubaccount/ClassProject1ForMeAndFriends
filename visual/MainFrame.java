package visual;

import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import atm.ATM;
import atm.Calc;
import atm.City;
import atm.DataMan;

public class MainFrame extends JFrame implements ActionListener {
	// Kommentar von Jan
		private JDesktopPane desktopPane;
		private JSplitPane splitPane;
		private JPanel ground;

		
		public static void main(String[] args)
		{
			MainFrame f = new MainFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		}

		public MainFrame()
		{
			this.setBounds(200, 150, 1000, 800);
			this.setTitle("I-Cup ATM");
			setJMenuBar(erstelleMenue());
			desktopPane = new JDesktopPane();
			getContentPane().add(desktopPane);  //oder setContentPane(desktopPane);
			
			JPanel sLeft = new JPanel();
			JPanel sRight = new JPanel();
			
			JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sLeft, sRight);
			JTextArea txtSide = new JTextArea("Wertefunktionen und weitere Tabellen");
			sRight.add(txtSide);
			splitPane.add(sRight, JSplitPane.RIGHT);
			JPanel ground = new JPanel();
			ground.setLayout(new BorderLayout());
			ground.setBackground(Color.red);
			ground.setBounds(new Rectangle(20, 20, 200, 200));
			ground.add(new JLabel("Der Text "+ground.getBounds()), BorderLayout.NORTH);
//			ground.setSize(new Dimension(50, 50));

			DataMan manipul = new DataMan();
			City stadt = manipul.testMan("Beispiel");
			manipul.print(stadt);
			CPanel test = new CPanel();
			test.stadtZeichnen(stadt);
			ground.add(test, BorderLayout.CENTER);
			sLeft.setLayout(new BorderLayout());
			sLeft.add(ground, BorderLayout.CENTER);
			sLeft.add(new JLabel("Hier sehen Sie die Stadt"), BorderLayout.NORTH);
			sLeft.add(new JLabel("und "), BorderLayout.SOUTH);
			JTextArea txtSide2 = new JTextArea("Werte");
			sLeft.add(txtSide2, BorderLayout.WEST);
			splitPane.setDividerLocation(650);
			splitPane.validate();
			splitPane.repaint();
			splitPane.paintComponents(test.getGraphics());
			this.add(splitPane);
		}
		
		private JMenuBar erstelleMenue()
		{
			JMenuBar jMnuBar = new JMenuBar();
			JMenu jMnuDat = new JMenu("Datei");
			JMenu jMnuCalc = new JMenu("Algorithmus");
			JMenu jMnuConfig = new JMenu("Config");

			jMnuBar.add(jMnuDat);
			jMnuBar.add(jMnuCalc);
			jMnuBar.add(jMnuConfig);

			//Datei
			JMenuItem jMnuD1 = new JMenuItem("Laden");
			jMnuD1.addActionListener(this);
			jMnuDat.add(jMnuD1);
			JMenuItem jMnuD2 = new JMenuItem("Speichern");
			jMnuD2.addActionListener(this);
			jMnuDat.add(jMnuD2);
			jMnuDat.addSeparator();
			JMenuItem jMnuD3 = new JMenuItem("Beenden");
			jMnuD3.addActionListener(this);
			jMnuDat.add(jMnuD3);
			
			//Calculation
			JMenuItem jMnuBsp = new JMenuItem("Beispiel");
			jMnuBsp.setActionCommand("Beispiel");
			jMnuBsp.addActionListener(this);
			jMnuCalc.add(jMnuBsp);
			jMnuCalc.addSeparator();
			JMenuItem jMnuA1 = new JMenuItem("Manuel");
			jMnuA1.setActionCommand("Manuel");
			jMnuA1.addActionListener(this);
			jMnuCalc.add(jMnuA1);
			JMenuItem jMnuA2 = new JMenuItem("simple Dreieck");
			jMnuA2.setActionCommand("Simple");
			jMnuA2.addActionListener(this);
			jMnuCalc.add(jMnuA2);
			JMenuItem jMnuA3 = new JMenuItem("parallel");
			jMnuA3.setActionCommand("Parallel");
			jMnuA3.addActionListener(this);
			jMnuCalc.add(jMnuA3);

			//Config
			JMenuItem jMnuC1 = new JMenuItem("Konfig");
			jMnuC1.addActionListener(this);
			jMnuConfig.add(jMnuC1);
			JMenuItem jMnuC2 = new JMenuItem("Wertefunktion");
			jMnuC2.addActionListener(this);
			jMnuConfig.add(jMnuC2);

				
			return jMnuBar;
		}
		
		public void paint(Graphics g){
			
		
				
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getActionCommand().equals("Beispiel"))
			{
				DataMan manipul = new DataMan();
				City stadt = manipul.testMan("Beispiel");
				CPanel test = new CPanel();
//				ground.add(test.stadtZeichnen(stadt));
				
			}
			else if(ae.getActionCommand().equals("Laden"))
			{
				System.out.println("Laden");
			}
			else if(ae.getActionCommand().equals("Speichern"))
			{
				System.out.println(ae.getActionCommand());
			}
			else if(ae.getActionCommand().equals("Beenden"))
			{
				System.exit(0);
			}
			else if(ae.getActionCommand().equals("Manuel"))
			{
				System.out.println(ae.getActionCommand());
			}
			else if(ae.getActionCommand().equals("Simple"))
			{
				System.out.println(ae.getActionCommand());
			}
			else if(ae.getActionCommand().equals("Parallel"))
			{
				System.out.println(ae.getActionCommand());
			}
			else if(ae.getActionCommand().equals("Config"))
			{
				System.out.println(ae.getActionCommand());
			}
			else if(ae.getActionCommand().equals("Wertefunktion"))
			{
				System.out.println(ae.getActionCommand());
			}

		}
}
