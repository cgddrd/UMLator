package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.diag.*;
import uk.ac.aber.dcs.cs124.clg11.vector.*;
import uk.ac.aber.dcs.cs124.clg11.fileIO.*;

public class CanvasPanel extends JPanel {

	private VectorOfDrawables vod = new VectorOfDrawables();
	private CodeExport cEX = new CodeExport();

	private int varNo;
	private int opNo;
	String inputValue;

	public CanvasPanel() {
		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(600,400)); //Set size of panel
	}

	

	public void listVectors() {
		for (int i = 0; i < vod.size(); i++) {
			ClassDiagData d = (ClassDiagData) vod.get(i).getData();
			System.out.println(d.getClassName());

			ArrayList<String> varList = d.getInstanceVariables();
			for (int y = 0; y < varList.size(); y++) {
				System.out.println(varList.get(y));
			}

			ArrayList<String> opList = d.getMethods();
			for (int z = 0; z < opList.size(); z++) {
				System.out.println(opList.get(z));
			}
		}
	}

	public void exportClass() {
		
		for (int i = 0; i < vod.size(); i++) {
			
			if (vod.get(i).getData() instanceof ClassDiagData) {
				ClassDiagData d = (ClassDiagData) vod.get(i).getData();
				ArrayList<String> opList = d.getMethods();
				ArrayList<String> varList = d.getInstanceVariables();
				ArrayList<String> asocVarList = d.getAssocInstanceVariables();
				
				try {
					cEX.printOut(varList.size(), opList.size(), asocVarList.size(), d.getClassName(), varList, opList, asocVarList);
					System.out.println("export done");

				} catch (Exception e) {
					System.out.println("IO Error");
				}	
			}
			
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		vod.drawAll(g);
	}
	
	public ClassDiag findNearestClass(int x, int y) {
		return (ClassDiag) (vod.findNearestClass(x, y));	
	}
	
	public void clearCanvas() {
		vod.clearAll();
		repaint();
		JOptionPane.showMessageDialog(null, "Canvas Cleared Successfully", "UMLator | Information", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public void addDrawable(Drawable d) {
		vod.addDrawable(d);
	}
	
}
