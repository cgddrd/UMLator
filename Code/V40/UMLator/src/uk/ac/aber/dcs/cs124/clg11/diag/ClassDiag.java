package uk.ac.aber.dcs.cs124.clg11.diag;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;

/**
 * GUI layer used to output/draw a particular class created by a user
 * to the {@link uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel}. 
 * 
 * Retrieves data about class from {@link uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData} object. 
 * 
 * Stored of type 'ClassDiag' in VectorOfDrawables
 * 
 * @author Connor Goddard (clg11), Sam Jackson (???), Craig Hepinsthall (???)
 *
 */

public class ClassDiag extends Drawable {

	private int height, width, opNo, offset, varNo;
	private Color backColour = Color.DARK_GRAY;
	private Color textColour = Color.white;

	public ClassDiag () {

	}

	/**
	 * Sets local variables required to draw class diagram. 
	 * Calculates height and width using number of variables/methods and maximum length of class entries.
	 * 
	 * @param x - X coordinate of mouse position when clicked (i.e. X coord. of new ClassDiag)
	 * @param y - Y coordinate of mouse position when clicked (i.e. Y coord. of new ClassDiag)
	 * @param varNo - Number of variables entered by user
	 * @param opNo - Number of methods entered by user
	 */
	public ClassDiag (double x, double y, int varNo, int opNo) {

		this.x = (int)x;
		this.y = (int)y;
		this.varNo = varNo;
		this.opNo = opNo;
		this.height = 65 + (varNo * 15) + (opNo * 15); 

	}

	/** 
	 * Calculates the width of class diagram by determining maximum length of any class variables/methods
	 * entered, before drawing complete diagram, including class data (retrieved from {@link uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData})
	 * to {@link uk.ac.aber.dcs.cs124.clg11.panel.CanvasPanel}. 
	 * 
	 * @see uk.ac.aber.dcs.cs124.clg11.diag.Drawable#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		
		/**
		 * {@link uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData} object that contains data about the class
		 */
		ClassDiagData d = (ClassDiagData) data;
		
		ArrayList<String> varList = d.getInstanceVariables();
		ArrayList<String> opList = d.getMethods();

		/**
		 * Holds the longest length of any of the variables/methods in class inputed
		 * by user
		 */
		int maxWidth = 0;

		for (int i = 0; i < varList.size(); i++) {
			if (varList.get(i).length() > maxWidth) {
				maxWidth = varList.get(i).length();
			}
		}

		for (int i = 0; i < opList.size(); i++) {
			if (opList.get(i).length() > maxWidth) {
				maxWidth = opList.get(i).length();
			}
		}

		this.width = (maxWidth * 5) + 80 ;

		setOffset(y + 50);
		g.setColor(backColour);
		g.fillRoundRect(x, y, getWidth(), getHeight(), 5, 5);
		g.setColor(textColour);
		g.drawLine(x, (y + 30), (x + getWidth()), (y + 30)); //(X1,Y1,X2,Y2) Y needs to be the same..
		g.drawRoundRect(x, y, getWidth(), getHeight(), 5, 5); //.. X needs to be first rec coord, then + 180
		g.drawString(d.getAccessModifier() + " " + d.getClassName(), (x + 10), (y + 20)); //Need to centre!


		for (int i = 0; i < getVarNo(); i++) {
			g.drawString(varList.get(i), (x + 10), (getOffset())); // Add variables
			setOffset(getOffset() + 15);
		}

		g.drawLine(x, (getOffset() - 5), (x + getWidth()), (getOffset() - 5)); // Variable separator
		setOffset(getOffset() + 15);

		for (int i = 0; i < getOpNo(); i++) {
			if (opList.get(i).equals("main")){
				g.drawString(opList.get(i) + "(String[ ] args)", (x + 10), (getOffset())); // Add variables
				setOffset(getOffset() + 15);
			} else {
				g.drawString(opList.get(i), (x + 10), (getOffset())); // Add variables
				setOffset(getOffset() + 15);
			}
		}
	}

	/**
	 * @return width - Width of class diagram calculated from longest string length
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Updates the X/Y position of the class diagram after user has completed 
	 * moving the diagram by dragging across the CanvasPanel
	 * 
	 * @param X - X coordinate of mouse position after dragging (i.e. new X position coordinate for class diagram)
	 * @param Y - Y coordinate of mouse position after dragging (i.e. new Y position coordinate for class diagram)
	 */
	public void update(int X, int Y) {
		this.x = X;
		this.y = Y;
	}

	/**
	 * @return height - Height of class diagram calculated by number of variables/method in class
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return offset - Equal 'Y' distance between each of the variables/methods to allow correct drawing
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset - Increment of 'offset' to allow equal 'Y' spacing as class diagram is drawn downwards
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return varNo - Number of variables entered by the user in the class
	 */
	public int getVarNo() {
		return varNo;
	}

	/**
	 * @param varNo - Sets the number of variables entered by the user in the class
	 */
	public void setVarNo(int varNo) {
	}

	/**
	 * @return opNo - Number of operations/methods entered by the user in the class
	 */
	public int getOpNo() {
		return opNo;
	}

	/**
	 * @param opNo - Sets the number of operations/methods entered by the user in the class
	 */
	public void setOpNo(int opNo) {
		this.opNo = opNo;
	}

	/**
	 * @param height - Sets height of class diagram calculated by number of variables/method in class
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @param backColour - Colour of class diagram background chosen by user using {@link javax.swing.JColorChooser}
	 */
	public void setBackColour(Color backColour) {
		this.backColour = backColour;
	}
	
	/**
	 * @param textColour - Colour of class diagram text and lines chosen by user using {@link javax.swing.JColorChooser}
	 */
	public void setTextColour(Color textColour) {
		this.textColour = textColour;
	}

}
