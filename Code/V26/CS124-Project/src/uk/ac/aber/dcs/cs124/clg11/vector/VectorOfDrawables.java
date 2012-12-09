package uk.ac.aber.dcs.cs124.clg11.vector;

import java.awt.*;
import java.util.*;

import uk.ac.aber.dcs.cs124.clg11.diag.Drawable;


public class VectorOfDrawables extends Vector<Drawable> {

	private Vector<Drawable> drawable;

	public VectorOfDrawables() {
		drawable = new Vector<Drawable>();
	}

	public void addDrawable(Drawable c) {
		getDrawable().add(c);
	}

	public void drawAll(Graphics g) {
		Drawable currentClass;

		if (getDrawable().size() > 0) {
			for(int i=0; i < getDrawable().size(); i++) {
				currentClass = (Drawable)(getDrawable().get(i));
				currentClass.paint(g);
			}
		}
	}

	public Vector<Drawable> getDrawable() {
		return drawable;
	}
	
	public int size() {
		return getDrawable().size();
	}
	
	public Drawable get(int i) {
		return getDrawable().get(i);
	}
	
	public Drawable findNearestClass(int x, int y) {
		Drawable d = null;
		double minDist = Double.MAX_VALUE;
		int minDistIndex = -1;

		for(int i=0; i < getDrawable().size(); i++) {
			d = (Drawable)(getDrawable().get(i));
			if(d.distanceTo(x,y) < minDist) {
				minDist = d.distanceTo(x,y);
				minDistIndex = i;
			}
		}
		if((minDistIndex >= 0) && (minDist < 80)) {
			d = (Drawable)(getDrawable().get(minDistIndex)); // Now retrieves the item (circle) from the entire Vector array (all the circles)...
			return d;								// ..that has the smallest distance from mouse
		} else {
			return null;
			}
		} 
	
	public void clearAll() {
		getDrawable().clear();
	}

    /**
     * @param drawable the drawable to set
     */
    public void setDrawable(Vector<Drawable> drawable) {
	this.drawable = drawable;
    }


}
