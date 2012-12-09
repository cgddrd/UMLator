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
		
		//ClassDiagData cdd = new ClassDiagData();
		//cdd.setParentName("Hello");
		
		//ClassDiag e = new ClassDiag();
		//e.setData(cdd);
		
		}
	}

}
