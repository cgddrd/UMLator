package uk.ac.aber.dcs.cs124.clg11.vector;

import java.awt.*;
import java.util.*;

import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag2;


public class VectorOfClasses {
	
	private Vector<ClassDiag2> classes;
	
	public VectorOfClasses() {
		classes = new Vector<ClassDiag2>();
	}

	public void addClass(ClassDiag2 c) {
		classes.add(c);
	}
	
	public void drawAll(Graphics g) {
		ClassDiag2 currentClass;

		if (classes.size() > 0) {
		for(int i=0; i < classes.size(); i++) {
			currentClass = (ClassDiag2)(classes.get(i));
			currentClass.paint(g);
		}
		}
	}

}
