package uk.ac.aber.dcs.cs124.clg11.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

import uk.ac.aber.dcs.cs124.clg11.diag.*;
import uk.ac.aber.dcs.cs124.clg11.vector.VectorOfClasses;

public class CanvasPanel extends JPanel {
	
	private VectorOfClasses voc = new VectorOfClasses();
	private ClassDiagData cDD = new ClassDiagData();
	private int varNo;
	private int opNo;
	String inputValue;

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
			
			cDD.setVarArray(varNo);	
		}
		
		
		for (int i = 0; i < varNo; i++) {
			inputValue = JOptionPane.showInputDialog("Please input a variable" + i); 
			cDD.addVar(inputValue);
			
		}
		
		cDD.printVar();
		voc.addClass(new ClassDiag (x,y,className.getText(),varNo,opNo,inputValue));
		repaint();
	}

 	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		voc.drawAll(g);
	}
}
