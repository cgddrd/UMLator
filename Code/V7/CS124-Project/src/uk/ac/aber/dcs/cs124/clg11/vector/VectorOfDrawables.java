package uk.ac.aber.dcs.cs124.clg11.vector;

import java.awt.*;
import java.util.*;

import uk.ac.aber.dcs.cs124.clg11.diag.Drawable;


public class VectorOfDrawables {
	
	private Vector<Drawable> drawables;
	
	public VectorOfDrawables() {
		drawables = new Vector<Drawable>();
	}

	public void addClass(Drawable c) {
		drawables.add(c);
	}
	
	public void drawAll(Graphics g) {
		Drawable currentClass;

		if (drawables.size() > 0) {
		for(int i=0; i < drawables.size(); i++) {
			currentClass = (Drawable)(drawables.get(i));
			currentClass.paint(g);
		}
		
		//ClassDiagData cdd = new ClassDiagData();
		//cdd.setParentName("Hello");
		
		//ClassDiag e = new ClassDiag();
		//e.setData(cdd);
		
		}
	}

	public Vector<Drawable> getDrawables() {
		return drawables;
	}

}
