package uk.ac.aber.dcs.cs124.clg11.vector;

import java.awt.*;
import java.util.*;

import uk.ac.aber.dcs.cs124.clg11.diag.Drawable;


public class VectorOfDrawables {

	private Vector<Drawable> drawable;

	public VectorOfDrawables() {
		drawable = new Vector<Drawable>();
	}

	public void addClass(Drawable c) {
		drawable.add(c);
	}

	public void drawAll(Graphics g) {
		Drawable currentClass;

		if (drawable.size() > 0) {
			for(int i=0; i < drawable.size(); i++) {
				currentClass = (Drawable)(drawable.get(i));
				currentClass.paint(g);
			}
		}
	}

	public Vector<Drawable> getDrawable() {
		return drawable;
	}
	
	public Drawable findNearestClass(int x, int y) {
		Drawable d = null;
		double minDist = Double.MAX_VALUE;
		int minDistIndex = -1;

		for(int i=0; i < drawable.size(); i++) {
			d = (Drawable)(drawable.get(i));
			if(d.distanceTo(x,y) < minDist) {
				minDist = d.distanceTo(x,y);
				minDistIndex = i;
			}
		}
		if((minDistIndex >= 0) && (minDist < 80)) {
			d = (Drawable)(drawable.get(minDistIndex)); // Now retrieves the item (circle) from the entire Vector array (all the circles)...
			return d;								// ..that has the smallest distance from mouse
		} else {
			return null;
			}
		} 


}
