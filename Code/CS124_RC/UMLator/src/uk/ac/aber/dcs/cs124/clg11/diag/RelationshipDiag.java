package uk.ac.aber.dcs.cs124.clg11.diag;

import java.awt.Graphics;
import uk.ac.aber.dcs.cs124.clg11.data.ClassData;
import uk.ac.aber.dcs.cs124.clg11.data.RelationshipData;


public class RelationshipDiag extends Drawable {


	private int diamondX, diamondY;
	private String arrowDir;
	private RelationshipData reld = new RelationshipData();

	public RelationshipDiag() {}

	public RelationshipDiag(ClassDiag a,ClassDiag b, String assocVar, String classAMulti, String classBMulti, String relType) {
		//code for constructing a new relationship goes here  
		reld.setClassA(a);
		ClassData d = (ClassData) reld.getClassA().getData();
		d.addAssocInstanceVar(assocVar);

		reld.setAssocVar(assocVar);
		reld.setRelType(relType);
		reld.setClassAMulti(classAMulti);
		reld.setClassBMulti(classBMulti);

		reld.setClassB(b);
	}
	
	public boolean contains(Drawable d) {
		if (reld.getClassA().equals(d) || reld.getClassB().equals(d)) {
			return true;
		}
		
		return false;
	}

	@Override
	public void paint(Graphics g) {
		//Draw relationship line with diamond at the end

		int x1 = reld.getClassA().getX(), y1 = reld.getClassA().getY(), x2 = reld.getClassB().getX(), y2 = reld.getClassB().getY();
		int w1 = reld.getClassA().getWidth(), h1 = reld.getClassA().getHeight(), w2 = reld.getClassB().getWidth(), h2 = reld.getClassB().getHeight(); //change 180 to getWidth
		int acx = x1+w1/2, acy = y1+h1/2, bcx = x2+w2/2, bcy = y2+h2/2;

		if (Math.abs(acx-bcx) > Math.abs(acy-bcy)) {
			if (bcy < y1) {
				g.drawLine(acx, y1, acx, bcy);
				if(x2 > x1) {
					System.out.println("side 1");
					this.setDiamondX(x2 - 20); //2nd class bottom right
					this.setDiamondY(bcy - 10);
					setArrowDir("EAST");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(acx, bcy, x2, bcy);
					} else {
						g.drawLine(acx, bcy, x2 - 20, bcy);
					}
					g.drawString(reld.getClassBMulti(), x2 - 40, bcy + 15); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx + 10, y1 - 15);
				} else {
					System.out.println("side 2");
					this.setDiamondX(x2 + w2); //2nd class, top left
					this.setDiamondY(bcy - 10);
					setArrowDir("WEST");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(acx, bcy, x2 + w2, bcy); 
					} else {
						g.drawLine(acx, bcy, x2 + w2 + 20, bcy); 
					}
					g.drawString(reld.getClassBMulti(), x2 + 200, bcy + 20); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx + 10, y1 - 15);
				}

			} else if (bcy > y1 && bcy < y1 + h1) {
				if(x2 > x1) {
					System.out.println("side 3");
					this.setDiamondX(x2 - 20); //2nd class left
					this.setDiamondY(bcy - 10);
					setArrowDir("EAST");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(x1 + w1, bcy, x2, bcy);
					} else {
						g.drawLine(x1 + w1, bcy, x2 - 20, bcy);	
					}
					g.drawString(reld.getClassBMulti(), x2 - 40, bcy + 15); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), x1 + 190, bcy + 15);
				} else {
					System.out.println("side 4");
					this.setDiamondX(x2 + w2); //2nd class right
					this.setDiamondY(bcy - 10);
					setArrowDir("WEST");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(x1, bcy, x2 + w2, bcy);
					} else {
						g.drawLine(x1, bcy, x2 + w2 + 20, bcy);
					}
					g.drawString(reld.getClassBMulti(), x2 + 200, bcy + 20); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), x1 - 30, bcy + 20);
				}
			} else if (bcy > y1 + h1) {
				g.drawLine(acx, y1 + h1, acx, bcy);
				if(x2 > x1) {
					System.out.println("side 5");
					this.setDiamondX(x2 - 20); //2nd class top right
					this.setDiamondY(bcy - 10);
					setArrowDir("EAST");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(acx, bcy, x2, bcy);
					} else {
						g.drawLine(acx, bcy, x2 - 20, bcy);
					}
					g.drawString(reld.getClassBMulti(), x2 - 40, bcy + 15); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx + 10, y1 + 140);
				} else {
					System.out.println("side 6");
					this.setDiamondX(x2 + w2); //2nd class bottom left
					this.setDiamondY(bcy - 10);
					setArrowDir("WEST");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(acx, bcy, x2 + w2, bcy);
					} else {
						g.drawLine(acx, bcy, x2 + w2 + 20, bcy);
					}
					g.drawString(reld.getClassBMulti(), x2 + 200, bcy + 20); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx + 10, y1 + 140);
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
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(bcx, acy, bcx, y2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 - 20);		
					}
					g.drawString(reld.getClassBMulti(), x2 + 100, bcy - 90); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx - 120, y1 + 80);
				} else {
					System.out.println("side 8");
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 + h2);
					setArrowDir("NORTH");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(bcx, acy, bcx, y2 + h2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
					}
					g.drawString(reld.getClassBMulti(), x2 + 100, bcy + 100); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), x1 - 30, y1 + 50);
				}

			} else if (bcx > x1 && bcx < x1 + w1) {
				if(y2 > y1) {
					System.out.println("side 9");
					this.setDiamondX(bcx - 10); //2nd class down
					this.setDiamondY(y2 - 20);
					setArrowDir("SOUTH");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(bcx, y1 + h1, bcx, y2);
					} else {
						g.drawLine(bcx, y1 + h1, bcx, y2 - 20);
					}
					g.drawString(reld.getClassBMulti(), bcx + 10, y2 - 20); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), x2 + 100, y1 + 150);
				} else {
					System.out.println("side 10");
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 + h2);
					setArrowDir("NORTH");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(bcx, y1, bcx, y2 + h2);
					} else {
						g.drawLine(bcx, y1, bcx, y2 + h2 + 20);
					}
					g.drawString(reld.getClassBMulti(), x2 + 100, bcy + 95); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), x2 + 100, y1 - 10);
				}
			} else if (bcx > x1 + w1) {
				g.drawLine(x1+ w1, acy, bcx, acy);
				if(y2 > y1) {
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 - 20);
					setArrowDir("SOUTH");
					System.out.println("side 11");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(bcx, acy, bcx, y2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 - 20);	
					}
					g.drawString(reld.getClassBMulti(), bcx + 10, y2 - 25); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx + 100, y1 + 50);
				} else {
					this.setDiamondX(bcx - 10);
					this.setDiamondY(y2 + h2);
					System.out.println("side 12");
					setArrowDir("NORTH");
					if (reld.getRelType().equals("ASSOCIATION")) {
						g.drawLine(bcx, acy, bcx, y2 + h2); 
					} else {
						g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
					}
					g.drawString(reld.getClassBMulti(), x2 + 105, bcy + 85); //DRAW MULTIPLICITIES
					g.drawString(reld.getClassAMulti(), acx + 105, y1 + 80);
				}
			}
		}

		x1 = this.getDiamondX();
		x2 = this.getDiamondX() + 20;
		y1 = this.getDiamondY();
		y2 = this.getDiamondY() + 20;

		int startx = (x1+x2)/2;  
		int starty = (y1+y2)/2;  

		switch (reld.getRelType()) {
		case "AGGREGATION":

			g.drawLine(x1, starty , startx , y1);  
			g.drawLine(startx , y1, x2, starty );  
			g.drawLine(x2, starty , startx , y2);  
			g.drawLine(startx , y2, x1, starty ); 

			break;
		case "ASSOCIATION":

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
		case "COMPOSITION":

			int [] xpoints = { x1, startx, x2, startx, x1 };
			int [] ypoints = { starty, y1, starty, y2, starty };
			g.fillPolygon(xpoints, ypoints, xpoints.length);

			break;
			
		case "INHERITANCE":
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
