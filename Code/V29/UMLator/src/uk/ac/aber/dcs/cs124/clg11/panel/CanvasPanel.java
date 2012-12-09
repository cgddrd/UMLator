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
	private String inputValue;

	public CanvasPanel(StatusPanel sp) {

		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(900,700)); //Set size of panel
		this.statusPane = sp;
		
		setStatus("Welcome to UMLator!");
	
	}

	public void exportClass() {
		
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		//fc.setFileFilter(new FileNameExtensionFilter("Java file", ".java"));
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

				} catch (Exception e) {
					setStatus("WARNING - IO Error");
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
	    vod.setDrawable(file.openProject());
	    repaint();
	    setStatus("Successfully Loaded Project");
	}

}
