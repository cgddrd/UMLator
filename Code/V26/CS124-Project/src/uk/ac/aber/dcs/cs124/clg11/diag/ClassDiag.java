package uk.ac.aber.dcs.cs124.clg11.diag;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;


public class ClassDiag extends Drawable {

    private int offset;
    private int varNo;
    private int opNo;
    private int height;

    public ClassDiag () {
    	
    }

    public ClassDiag (double x, double y, int varNo, int opNo) {
            this.x = (int)x;
            this.y = (int)y;
            this.varNo = varNo;
            this.opNo = opNo;
            height = 65 + (varNo * 15) + (opNo * 15); //Calculate how big the class diag shell has to be.
    }

    @Override
    public void paint(Graphics g) {

            ClassDiagData d = (ClassDiagData) data;
            ArrayList<String> varList = d.getInstanceVariables();
            ArrayList<String> opList = d.getMethods();

            setOffset(y + 50);
            g.setColor(Color.cyan);
            g.fillRoundRect(x, y, 180, getHeight(), 5, 5);
            g.setColor(Color.red);
            g.drawLine(x, (y + 30), (x + 180), (y + 30)); //(X1,Y1,X2,Y2) Y needs to be the same..
            g.drawRoundRect(x, y, 180, getHeight(), 5, 5); //.. X needs to be first rec coord, then + 180
            g.drawString(d.getAccessModifier() + " " + d.getClassName(), (x + 10), (y + 20)); //Need to centre!


            for (int i = 0; i < getVarNo(); i++) {
                    g.drawString(varList.get(i), (x + 10), (getOffset())); // Add variables
                    setOffset(getOffset() + 15);
            }

            g.drawLine(x, (getOffset() - 5), (x + 180), (getOffset() - 5)); // Variable separator
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

    public void update(int X, int Y) {
            this.x = X;
            this.y = Y;
            //No need to try and run 'draw()' again, it does it automatically
    }
    
    public int getHeight() {
        return height;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
	return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) {
	this.offset = offset;
    }

    /**
     * @return the varNo
     */
    public int getVarNo() {
	return varNo;
    }

    /**
     * @param varNo the varNo to set
     */
    public void setVarNo(int varNo) {
	this.varNo = varNo;
    }

    /**
     * @return the opNo
     */
    public int getOpNo() {
	return opNo;
    }

    /**
     * @param opNo the opNo to set
     */
    public void setOpNo(int opNo) {
	this.opNo = opNo;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
	this.height = height;
    }
}
