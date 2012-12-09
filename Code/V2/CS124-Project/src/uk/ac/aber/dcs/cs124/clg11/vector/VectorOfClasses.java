package uk.ac.aber.dcs.cs124.clg11.vector;

import java.awt.*;
import java.util.*;

import uk.ac.aber.dcs.cs124.clg11.diag.ClassDiag;


public class VectorOfClasses {
	
	private Vector<ClassDiag> classes;
	
	public VectorOfClasses() {
		classes = new Vector<ClassDiag>();
	}

	public void addClass(ClassDiag c) {
		classes.add(c);
	}
	
	public void drawAll(Graphics g) {
		ClassDiag currentClass;

		if (classes.size() > 0) {
		for(int i=0; i < classes.size(); i++) {
			currentClass = (ClassDiag)(classes.get(i));
			currentClass.paint(g);
		}
		}
	}

}
