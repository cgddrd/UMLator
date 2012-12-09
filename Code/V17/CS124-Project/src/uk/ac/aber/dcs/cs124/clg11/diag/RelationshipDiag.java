package uk.ac.aber.dcs.cs124.clg11.diag;

import java.awt.Graphics;
import uk.ac.aber.dcs.cs124.clg11.data.ClassDiagData;
import uk.ac.aber.dcs.cs124.clg11.data.RelationshipDiagData;
import uk.ac.aber.dcs.cs124.clg11.data.RelType;


public class RelationshipDiag extends Drawable {
	
    private ClassDiag a, b;
    private String assocVar;
    private String classAMulti;
    private String classBMulti;
    private String relType;
    private int diamondX, diamondY;
   
   
    public RelationshipDiag(ClassDiag a,ClassDiag b, String assocVar, String classAMulti, String classBMulti, String relType) {
        //code for constructing a new relationship goes here
        this.assocVar = assocVar;
        this.classAMulti = classAMulti;
        this.classBMulti = classBMulti;
        this.relType = relType;

        this.a = a;
        ClassDiagData d = (ClassDiagData) this.a.getData();
        d.addAssocInstanceVar(assocVar);

        this.b = b;
    }
    
    @Override
    public void paint(Graphics g) {
        //Draw relationship line with diamond at the end
        
        int x1 = a.getX(), y1 = a.getY(), x2 = b.getX(), y2 = b.getY();
        int w1 = 180, h1 = a.getHeight(), w2 = 180, h2 = b.getHeight(); //change 180 to getWidth
        int acx = x1+w1/2, acy = y1+h1/2, bcx = x2+w2/2, bcy = y2+h2/2;
        
        if (Math.abs(acx-bcx) > Math.abs(acy-bcy)) {
            if (bcy < y1) {
                g.drawLine(acx, y1, acx, bcy);
                
                if(x2 > x1) {
                
                    g.drawLine(acx, bcy, x2 - 20, bcy);
                    this.diamondX = x2 - 20; //2nd class bottom right
                    this.diamondY = bcy - 10;
                	
                } else {
                    g.drawLine(acx, bcy, x2 + w2 + 20, bcy); 
                    this.diamondX = x2 + w2; //2nd class, top left
                    this.diamondY = bcy - 10;
                }
                
            } else if (bcy > y1 && bcy < y1 + h1) {
                if(x2 > x1) {
                    g.drawLine(x1 + w1, bcy, x2 - 20, bcy);
                    this.diamondX = x2 - 20; //2nd class left
                    this.diamondY = bcy - 10;
                } else {
                    g.drawLine(x1, bcy, x2 + w2 + 20, bcy);
                    this.diamondX = x2 + w2; //2nd class right
                    this.diamondY = bcy - 10;
                }
            } else if (bcy > y1 + h1) {
                g.drawLine(acx, y1 + h1, acx, bcy);
                if(x2 > x1) {
                    g.drawLine(acx, bcy, x2 - 20, bcy);
                    this.diamondX = x2 - 20; //2nd class top right
                    this.diamondY = bcy - 10;
                } else {
                    g.drawLine(acx, bcy, x2 + w2 + 20, bcy);
                    this.diamondX = x2 + w2; //2nd class bottom left
                    this.diamondY = bcy - 10;
                }
            }
            
        } else {
            if (bcx < x1) {
                g.drawLine(x1, acy, bcx, acy);
                if(y2 > y1) {
                    g.drawLine(bcx, acy, bcx, y2 - 20);
                    this.diamondX = bcx - 10;
                    this.diamondY = y2 - 20;
                } else {
                    g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
                    this.diamondX = bcx - 10;
                    this.diamondY = y2 + h2;
                }
                
            } else if (bcx > x1 && bcx < x1 + w1) {
                if(y2 > y1) {
                    g.drawLine(bcx, y1 + h1, bcx, y2 - 20);
                    this.diamondX = bcx - 10; //2nd class down
                    this.diamondY = y2 - 20;
                } else {
                    g.drawLine(bcx, y1, bcx, y2 + h2 + 20);
                    this.diamondX = bcx - 10;
                    this.diamondY = y2 + h2;
                }
            } else if (bcx > x1 + w1) {
                g.drawLine(x1+ w1, acy, bcx, acy);
                if(y2 > y1) {
                    g.drawLine(bcx, acy, bcx, y2 - 20);
                    this.diamondX = bcx - 10;
                    this.diamondY = y2 - 20;
                } else {
                    g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
                    this.diamondX = bcx - 10;
                    this.diamondY = y2 + h2;
                }
            }
        }
        
        //code for rel types
        RelationshipDiagData d = (RelationshipDiagData) getData();
        switch (relType) {
            case "COMPOSITION":
                        
             //   x1 = b.getX() + 90;
              //  x2 = (x1 + 20);
               // y1 = b.getY() - 20;
               // y2 = (y1 + 20);
            	
            	x1 = this.diamondX;
            	x2 = this.diamondX + 20;
            	y1 = this.diamondY;
            	y2 = this.diamondY + 20;

                int startx = (x1+x2)/2;  
                int starty = (y1+y2)/2;  

                g.drawLine(x1, starty , startx , y1);  
                g.drawLine(startx , y1, x2, starty );  
                g.drawLine(x2, starty , startx , y2);  
                g.drawLine(startx , y2, x1, starty ); 
                
                break;
            case "INHERITANCE":
                break;
            case "AGGREGATION":
                break;
            case "ASSOCIATION":
                break;
        }
        
    }

}
