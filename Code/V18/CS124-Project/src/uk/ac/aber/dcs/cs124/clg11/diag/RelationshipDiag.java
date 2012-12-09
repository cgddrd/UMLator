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


	public RelationshipDiag() {} //keep this for XML export
	
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
		int w1 = 180, h1 = getA().getHeight(), w2 = 180, h2 = getB().getHeight(); //change 180 to getWidth
		int acx = x1+w1/2, acy = y1+h1/2, bcx = x2+w2/2, bcy = y2+h2/2;

		if (Math.abs(acx-bcx) > Math.abs(acy-bcy)) {
			if (bcy < y1) {
				g.drawLine(acx, y1, acx, bcy);

				if(x2 > x1) {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(acx, bcy, x2 - 20, bcy);
						this.setDiamondX(x2 - 20); //2nd class bottom right
						this.setDiamondY(bcy - 10);
					} else {
						g.drawLine(acx, bcy, x2, bcy);
					}

				} else {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(acx, bcy, x2 + w2 + 20, bcy); 
						this.setDiamondX(x2 + w2); //2nd class, top left
						this.setDiamondY(bcy - 10);
					} else {
						g.drawLine(acx, bcy, x2 + w2, bcy); 
					}
				}

			} else if (bcy > y1 && bcy < y1 + h1) {
				if(x2 > x1) {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(x1 + w1, bcy, x2 - 20, bcy);
						this.setDiamondX(x2 - 20); //2nd class left
						this.setDiamondY(bcy - 10);
					} else {
						g.drawLine(x1 + w1, bcy, x2, bcy);	
					}
				} else {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(x1, bcy, x2 + w2 + 20, bcy);
						this.setDiamondX(x2 + w2); //2nd class right
						this.setDiamondY(bcy - 10);
					} else {
						g.drawLine(x1, bcy, x2 + w2, bcy);
					}
				}
			} else if (bcy > y1 + h1) {
				g.drawLine(acx, y1 + h1, acx, bcy);
				if(x2 > x1) {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(acx, bcy, x2 - 20, bcy);
						this.setDiamondX(x2 - 20); //2nd class top right
						this.setDiamondY(bcy - 10);
					} else {
						g.drawLine(acx, bcy, x2, bcy);
					}
				} else {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(acx, bcy, x2 + w2 + 20, bcy);
						this.setDiamondX(x2 + w2); //2nd class bottom left
						this.setDiamondY(bcy - 10);
					} else {
						g.drawLine(acx, bcy, x2 + w2, bcy);
					}
				}
			}

		} else {
			if (bcx < x1) {
				g.drawLine(x1, acy, bcx, acy);
				if(y2 > y1) {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(bcx, acy, bcx, y2 - 20);
						this.setDiamondX(bcx - 10);
						this.setDiamondY(y2 - 20);
					} else {
						g.drawLine(bcx, acy, bcx, y2);
					}
				} else {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
						this.setDiamondX(bcx - 10);
						this.setDiamondY(y2 + h2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 + h2); 
					}
				}

			} else if (bcx > x1 && bcx < x1 + w1) {
				if(y2 > y1) {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(bcx, y1 + h1, bcx, y2 - 20);
						this.setDiamondX(bcx - 10); //2nd class down
						this.setDiamondY(y2 - 20);
					} else {
						g.drawLine(bcx, y1 + h1, bcx, y2);
					}
				} else {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(bcx, y1, bcx, y2 + h2 + 20);
						this.setDiamondX(bcx - 10);
						this.setDiamondY(y2 + h2);
					} else {
						g.drawLine(bcx, y1, bcx, y2 + h2);
					}
				}
			} else if (bcx > x1 + w1) {
				g.drawLine(x1+ w1, acy, bcx, acy);
				if(y2 > y1) {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(bcx, acy, bcx, y2 - 20);
						this.setDiamondX(bcx - 10);
						this.setDiamondY(y2 - 20);
					} else {
						g.drawLine(bcx, acy, bcx, y2);
					}
				} else {
					if (getRelType().equals("COMPOSITION") || getRelType().equals("AGGREGATION")) {
						g.drawLine(bcx, acy, bcx, y2 + h2 + 20); 
						this.setDiamondX(bcx - 10);
						this.setDiamondY(y2 + h2);
					} else {
						g.drawLine(bcx, acy, bcx, y2 + h2); 
					}
				}
			}
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

}
