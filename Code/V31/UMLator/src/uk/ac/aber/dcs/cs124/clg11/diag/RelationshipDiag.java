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
	private String arrowDir;

	public RelationshipDiag() {}

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

		int x1 = getA().getX(), y1 = getA().getY(), x2 = getB().getX(), y2 = getB().getY();
		int w1 = getA().getWidth(), h1 = getA().getHeight(), w2 = getB().getWidth(), h2 = getB().getHeight(); //change 180 to getWidth
		int acx = x1+w1/2, acy = y1+h1/2, bcx = x2+w2/2, bcy = y2+h2/2;

		if (Math.abs(acx-bcx) > Math.abs(acy-bcy)) {
			if (bcy < y1) {
				g.drawLine(acx, y1, acx, bcy);
				if(x2 > x1) {
					System.out.println("side 1");
					this.setDiamondX(x2 - 20); //2nd class bottom right
					this.setDiamondY(bcy - 10);
					setArrowDir("EAST");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(acx, bcy, x2, bcy);
					} else {
						g.drawLine(acx, bcy, x2 - 20, bcy);
					}
					g.drawString(getClassBMulti(), x2 - 40, bcy + 15); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx + 10, y1 - 15);
				} else {
					System.out.println("side 2");
					this.setDiamondX(x2 + w2); //2nd class, top left
					this.setDiamondY(bcy - 10);
					setArrowDir("WEST");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(acx, bcy, x2 + w2, bcy); 
					} else {
						g.drawLine(acx, bcy, x2 + w2 + 20, bcy); 
					}
					g.drawString(getClassBMulti(), x2 + 200, bcy + 20); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx + 10, y1 - 15);
				}

			} else if (bcy > y1 && bcy < y1 + h1) {
				if(x2 > x1) {
					System.out.println("side 3");
					this.setDiamondX(x2 - 20); //2nd class left
					this.setDiamondY(bcy - 10);
					setArrowDir("EAST");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(x1 + w1, bcy, x2, bcy);
					} else {
						g.drawLine(x1 + w1, bcy, x2 - 20, bcy);	
					}
					g.drawString(getClassBMulti(), x2 - 40, bcy + 15); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), x1 + 190, bcy + 15);
				} else {
					System.out.println("side 4");
					this.setDiamondX(x2 + w2); //2nd class right
					this.setDiamondY(bcy - 10);
					setArrowDir("WEST");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(x1, bcy, x2 + w2, bcy);
					} else {
						g.drawLine(x1, bcy, x2 + w2 + 20, bcy);
					}
					g.drawString(getClassBMulti(), x2 + 200, bcy + 20); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), x1 - 30, bcy + 20);
				}
			} else if (bcy > y1 + h1) {
				g.drawLine(acx, y1 + h1, acx, bcy);
				if(x2 > x1) {
					System.out.println("side 5");
					this.setDiamondX(x2 - 20); //2nd class top right
					this.setDiamondY(bcy - 10);
					setArrowDir("EAST");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(acx, bcy, x2, bcy);
					} else {
						g.drawLine(acx, bcy, x2 - 20, bcy);
					}
					g.drawString(getClassBMulti(), x2 - 40, bcy + 15); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx + 10, y1 + 140);
				} else {
					System.out.println("side 6");
					this.setDiamondX(x2 + w2); //2nd class bottom left
					this.setDiamondY(bcy - 10);
					setArrowDir("WEST");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(acx, bcy, x2 + w2, bcy);
					} else {
						g.drawLine(acx, bcy, x2 + w2 + 20, bcy);
					}
					g.drawString(getClassBMulti(), x2 + 200, bcy + 20); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx + 10, y1 + 140);
				}
			}

		} else {
			if (bcx < x1) {
				g.drawLine(x1, acy, bcx, acy);
				if(y2 > y1) {
					System.out.println("side 7");
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 - 20);
					setArrowDir("SOUTH");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(bcx, acy, bcx, y2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 - 20);		
					}
					g.drawString(getClassBMulti(), x2 + 100, bcy - 90); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx - 120, y1 + 80);
				} else {
					System.out.println("side 8");
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 + h2);
					setArrowDir("NORTH");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(bcx, acy, bcx, y2 + h2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
					}
					g.drawString(getClassBMulti(), x2 + 100, bcy + 100); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), x1 - 30, y1 + 50);
				}

			} else if (bcx > x1 && bcx < x1 + w1) {
				if(y2 > y1) {
					System.out.println("side 9");
					this.setDiamondX(bcx - 10); //2nd class down
					this.setDiamondY(y2 - 20);
					setArrowDir("SOUTH");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(bcx, y1 + h1, bcx, y2);
					} else {
						g.drawLine(bcx, y1 + h1, bcx, y2 - 20);
					}
					g.drawString(getClassBMulti(), bcx + 10, y2 - 20); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), x2 + 100, y1 + 150);
				} else {
					System.out.println("side 10");
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 + h2);
					setArrowDir("NORTH");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(bcx, y1, bcx, y2 + h2);
					} else {
						g.drawLine(bcx, y1, bcx, y2 + h2 + 20);
					}
					g.drawString(getClassBMulti(), x2 + 100, bcy + 95); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), x2 + 100, y1 - 10);
				}
			} else if (bcx > x1 + w1) {
				g.drawLine(x1+ w1, acy, bcx, acy);
				if(y2 > y1) {
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 - 20);
					setArrowDir("SOUTH");
					System.out.println("side 11");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(bcx, acy, bcx, y2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 - 20);	
					}
					g.drawString(getClassBMulti(), bcx + 10, y2 - 25); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx + 100, y1 + 50);
				} else {
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 + h2);
					System.out.println("side 12");
					setArrowDir("NORTH");
					if (getRelType().equals("INHERITANCE")) {
						g.drawLine(bcx, acy, bcx, y2 + h2); 
					} else {
						g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
					}
					g.drawString(getClassBMulti(), x2 + 105, bcy + 85); //DRAW MULTIPLICITIES
					g.drawString(getClassAMulti(), acx + 105, y1 + 80);
				}
			}
		}

		//code for rel types
		RelationshipDiagData d = (RelationshipDiagData) getData();

		x1 = this.getDiamondX();
		x2 = this.getDiamondX() + 20;
		y1 = this.getDiamondY();
		y2 = this.getDiamondY() + 20;

		int startx = (x1+x2)/2;  
		int starty = (y1+y2)/2;  

		switch (getRelType()) {
		case "COMPOSITION":

			g.drawLine(x1, starty , startx , y1);  
			g.drawLine(startx , y1, x2, starty );  
			g.drawLine(x2, starty , startx , y2);  
			g.drawLine(startx , y2, x1, starty ); 

			break;
		case "INHERITANCE":

			switch (getArrowDir()) {
			case "NORTH":

				g.drawLine(startx , y1, x2, starty ); 
				g.drawLine(x1, starty , startx , y1); 

				break;
			case "SOUTH":

				g.drawLine(x2, starty , startx , y2);  
				g.drawLine(startx , y2, x1, starty ); 

				break;
			case "EAST":

				g.drawLine(startx , y1, x2, starty );  
				g.drawLine(x2, starty , startx , y2);  

				break;
			case "WEST":

				g.drawLine(x1, starty , startx , y1);
				g.drawLine(startx , y2, x1, starty ); 

				break;
			}

			break;
		case "AGGREGATION":

			int [] xpoints = { x1, startx, x2, startx, x1 };
			int [] ypoints = { starty, y1, starty, y2, starty };
			g.fillPolygon(xpoints, ypoints, xpoints.length);

			break;
			
		case "ASSOCIATION":
			switch (getArrowDir()) {
			case "NORTH":

				g.drawLine(startx , y1, x2, starty ); 
				g.drawLine(x1, starty , startx , y1); 
				g.drawLine(x1,starty, x2, starty);
				g.drawLine(startx,starty, startx, y2);

				break;
			case "SOUTH":

				g.drawLine(x2, starty , startx , y2);  
				g.drawLine(startx , y2, x1, starty ); 
				g.drawLine(x1,starty, x2, starty);
				g.drawLine(startx,starty, startx, y1);

				break;
			case "EAST":

				g.drawLine(startx , y1, x2, starty );  
				g.drawLine(x2, starty , startx , y2);
				g.drawLine(startx,y1, startx, y2);
				g.drawLine(startx,starty, x1, starty);
				
				break;
			case "WEST":

				g.drawLine(x1, starty , startx , y1);
				g.drawLine(startx , y2, x1, starty );
				g.drawLine(startx,y1, startx, y2);
				g.drawLine(startx,starty, x2, starty);

				break;
			}

			break;
		}

	}

    /**
     * @return the a
     */
    public ClassDiag getA() {
	return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(ClassDiag a) {
	this.a = a;
    }

    /**
     * @return the b
     */
    public ClassDiag getB() {
	return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(ClassDiag b) {
	this.b = b;
    }

    /**
     * @return the assocVar
     */
    public String getAssocVar() {
	return assocVar;
    }

    /**
     * @param assocVar the assocVar to set
     */
    public void setAssocVar(String assocVar) {
	this.assocVar = assocVar;
    }

    /**
     * @return the classAMulti
     */
    public String getClassAMulti() {
	return classAMulti;
    }

    /**
     * @param classAMulti the classAMulti to set
     */
    public void setClassAMulti(String classAMulti) {
	this.classAMulti = classAMulti;
    }

    /**
     * @return the classBMulti
     */
    public String getClassBMulti() {
	return classBMulti;
    }

    /**
     * @param classBMulti the classBMulti to set
     */
    public void setClassBMulti(String classBMulti) {
	this.classBMulti = classBMulti;
    }

    /**
     * @return the relType
     */
    public String getRelType() {
	return relType;
    }

    /**
     * @param relType the relType to set
     */
    public void setRelType(String relType) {
	this.relType = relType;
    }

    /**
     * @return the diamondX
     */
    public int getDiamondX() {
	return diamondX;
    }

    /**
     * @param diamondX the diamondX to set
     */
    public void setDiamondX(int diamondX) {
	this.diamondX = diamondX;
    }

    /**
     * @return the diamondY
     */
    public int getDiamondY() {
	return diamondY;
    }

    /**
     * @param diamondY the diamondY to set
     */
    public void setDiamondY(int diamondY) {
	this.diamondY = diamondY;
    }

    /**
     * @return the arrowDir
     */
    public String getArrowDir() {
	return arrowDir;
    }

    /**
     * @param arrowDir the arrowDir to set
     */
    public void setArrowDir(String arrowDir) {
	this.arrowDir = arrowDir;
    }

}
