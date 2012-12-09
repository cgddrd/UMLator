package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import uk.ac.aber.dcs.cs124.clg11.diag.*;
import uk.ac.aber.dcs.cs124.clg11.vector.*;
import uk.ac.aber.dcs.cs124.clg11.fileIO.*;

public class CanvasPanel extends JPanel {

	private VectorOfDrawables vod = new VectorOfDrawables();
	private CodeExport cEX = new CodeExport();

	private int varNo;
	private int opNo;
	String inputValue;
	private Vector<Drawable> vec;

	public CanvasPanel() {
		this.setBackground(Color.gray);
		this.setPreferredSize(new Dimension(600,400)); //Set size of panel
	}

	public void addClass(double x, double y) {

		JTextField className = new JTextField();
		JTextField varInput = new JTextField();
		JTextField opInput = new JTextField();
		Object[] msg = {"Class Name:", className, "No of Var:", varInput, "No of Ops", opInput };

		JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);

		JDialog dialog = op.createDialog(this, "Enter Details..");
		dialog.setVisible(true);

		int result = JOptionPane.OK_OPTION;

		if(result == JOptionPane.OK_OPTION)
		{
			varNo = Integer.parseInt(varInput.getText());
			opNo = Integer.parseInt(opInput.getText());

		}

		ClassDiagData cDD = new ClassDiagData();

		cDD.setClassName(className.getText());

		for (int i = 0; i < varNo; i++) {
			String variableInput = JOptionPane.showInputDialog(null,"Enter Variable " + i,"Enter Variable");
			cDD.addInstanceVar(variableInput); //Create new data input 'template' and populate with use inputted data	
		}

		for (int i = 0; i < opNo; i++) {
			String methodInput = JOptionPane.showInputDialog(null,"Enter Method " + i,"Enter Method");
			cDD.addMethod(methodInput); //Create new data input 'template' and populate with use inputted data	
		}

		String accessInput = JOptionPane.showInputDialog(null,"Enter Req Access Modifier (+/-)","Enter Access Modifier");
		cDD.setAccessModifier(accessInput);

		ClassDiag e = new ClassDiag(x, y, className.getText(), varNo, opNo); //Create a new class object and set the details of it
		e.setData(cDD); //Set the associated data with from the cDD.

		vod.addClass(e);
		repaint();

		this.getDrawVectors();
		//this.listVectors(); //Temporary method to check array behaviour..
		this.exportClass();
	}

	public void getDrawVectors() {
		vec = vod.getDrawable();
	}

	public void listVectors() {
		for (int i = 0; i < vec.size(); i++) {
			ClassDiagData d = (ClassDiagData) vec.get(i).getData();
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
		for (int i = 0; i < vec.size(); i++) {
			ClassDiagData d = (ClassDiagData) vec.get(i).getData();
			ArrayList<String> opList = d.getMethods();
			ArrayList<String> varList = d.getInstanceVariables();
			try {
				cEX.printOut(varList.size(), opList.size(), d.getClassName(), varList, opList);
				System.out.println("export done");

			} catch (Exception e) {
				System.out.println("IO Error");
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
}
