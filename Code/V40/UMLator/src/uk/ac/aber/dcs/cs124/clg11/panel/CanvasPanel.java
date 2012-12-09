package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.diag.*;
import uk.ac.aber.dcs.cs124.clg11.vector.*;
import uk.ac.aber.dcs.cs124.clg11.fileIO.*;

public class CanvasPanel extends JPanel {

	private VectorOfDrawables vod = new VectorOfDrawables();
	private CodeExport cEX = new CodeExport();
	private StatusPanel statusPane;
	private JFileChooser fc = new JFileChooser();


	private FileIO file = new FileIO();
	
	public CanvasPanel(StatusPanel sp) {

		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(900,700)); //Set size of panel
		this.statusPane = sp;

		setStatus("Welcome to UMLator!");

	}

	public void exportClass() {

		if (vod.size() == 0) {
			JOptionPane.showMessageDialog(null, "No information available to export", "UMLator | Export Error", JOptionPane.ERROR_MESSAGE);
		} else {

			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int returnVal = fc.showSaveDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {

				for (int i = 0; i < vod.size(); i++) {

					if (vod.get(i).getData() instanceof ClassDiagData) {
						ClassDiagData d = (ClassDiagData) vod.get(i).getData();
						ArrayList<String> opList = d.getMethods();
						ArrayList<String> varList = d.getInstanceVariables();
						ArrayList<String> asocVarList = d.getAssocInstanceVariables();

						try {

							String fileDir = fc.getSelectedFile().getAbsolutePath();
							cEX.printOut(fileDir, varList.size(), opList.size(), asocVarList.size(), d.getClassName(), varList, opList, asocVarList);
							setStatus("Java Export Complete");
							JOptionPane.showMessageDialog(new JFrame(), "Java Exported Successfully", "UMLator | Code Export", JOptionPane.INFORMATION_MESSAGE);

						} catch (Exception e) {
							setStatus("WARNING - IO Error");
						}	
					}

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
		file.saveProject(vod.getDrawable());
	}

	public void loadFile() {
		try {
			vod.setDrawable(file.openProject());
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "File cannot be opened - " + e, "UMLator | Parser Error", JOptionPane.ERROR_MESSAGE);
		}
		repaint();
		setStatus("Successfully Loaded Project");
	}

	public void removeClass(int x, int y) {
		if (vod.size() == 0) {
			JOptionPane.showMessageDialog(null, "No objects available to delete", "UMLator | Delete Error", JOptionPane.ERROR_MESSAGE);
		} else {
			vod.removeNearestClass(x, y);
			repaint();	
		}

	}

	public void undoAction() {
		try {
			vod.undoLast();
			repaint();
		} catch (ArrayIndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(new JFrame(), "There are no actions to undo", "UMLator | Undo Error", JOptionPane.ERROR_MESSAGE);}
	}

	public void changeColour(Color backColour) {
		if (vod.size() == 0) {
			JOptionPane.showMessageDialog(null, "No objects available to edit", "UMLator | Edit Error", JOptionPane.ERROR_MESSAGE);
		} else {
			for (int i = 0; i < vod.size(); i++) {
				ClassDiag selectClass = (ClassDiag) vod.get(i);
				selectClass.setBackColour(backColour);
			}
			repaint();
		}
	}

	public void changeTextColour(Color textColour) {
		if (vod.size() == 0) {
			JOptionPane.showMessageDialog(null, "No objects available to edit", "UMLator | Edit Error", JOptionPane.ERROR_MESSAGE);
		} else {
			for (int i = 0; i < vod.size(); i++) {
				ClassDiag selectClass = (ClassDiag) vod.get(i);
				selectClass.setTextColour(textColour);
			}
			repaint();
		}
	}

	public void exitProgram() {
		int exit = JOptionPane.YES_OPTION;
		exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "UMLator | Exit", JOptionPane.YES_NO_OPTION);

		if (exit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void displayCoords(int x, int y) {
		statusPane.setCoords(x, y);
	}
	
	public void about() {
		JOptionPane.showMessageDialog(null, "Created by: Connor Goddard (clg11), Sam Jackson (???) & Craig Heptinstall (???) - Feb/March 2012","UMLator | About", JOptionPane.INFORMATION_MESSAGE);
	}
}