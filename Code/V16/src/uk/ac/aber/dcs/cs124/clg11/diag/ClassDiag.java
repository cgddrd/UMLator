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

            offset = y + 50;
            g.setColor(Color.cyan);
            g.fillRoundRect(x, y, 180, height, 5, 5);
            g.setColor(Color.red);
            g.drawLine(x, (y + 30), (x + 180), (y + 30)); //(X1,Y1,X2,Y2) Y needs to be the same..
            g.drawRoundRect(x, y, 180, height, 5, 5); //.. X needs to be first rec coord, then + 180
            g.drawString(d.getAccessModifier() + " " + d.getClassName(), (x + 10), (y + 20)); //Need to centre!


            for (int i = 0; i < varNo; i++) {
                    g.drawString(varList.get(i), (x + 10), (offset)); // Add variables
                    offset = offset + 15;
            }

            g.drawLine(x, (offset - 5), (x + 180), (offset - 5)); // Variable separator
            offset = offset + 15;

            for (int i = 0; i < opNo; i++) {
                    if (opList.get(i).equals("main")){
                            g.drawString(opList.get(i) + "(String[ ] args)", (x + 10), (offset)); // Add variables
                            offset = offset + 15;
                    } else {
                            g.drawString(opList.get(i), (x + 10), (offset)); // Add variables
                            offset = offset + 15;
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
}
