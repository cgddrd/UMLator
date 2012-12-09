package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.diag.*;
import uk.ac.aber.dcs.cs124.clg11.vector.*;
import uk.ac.aber.dcs.cs124.clg11.fileIO.*;

public class CanvasPanel extends JPanel {

	private VectorOfDrawables vod = new VectorOfDrawables();
	private CodeExport cEX = new CodeExport();
	private StatusPanel statusPane;

	private int varNo;
	private int opNo;
	String inputValue;

	public CanvasPanel(StatusPanel sp) {

		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(900,700)); //Set size of panel
		this.statusPane = sp;
		setStatus("Welcome to UMLator!");
	
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
					setStatus("Java Export Complete");

				} catch (Exception e) {
					setStatus("WARNING - IO Error");
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
		setStatus("Canvas Cleared Successfully");
	}
	
	public void setStatus(String status) {
		statusPane.setStatus("Status: " + status);
	}


	public void addDrawable(Drawable d) {
		vod.addDrawable(d);
	}

	public void saveFile() {
		FileIO file = new FileIO();
		file.saveProject(vod.getDrawable());

	}

}
