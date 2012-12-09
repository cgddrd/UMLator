package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.event.*;
import uk.ac.aber.dcs.cs124.clg11.vector.*;
import uk.ac.aber.dcs.cs124.clg11.diag.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;
import javax.swing.*;

public class MousePositionListener implements MouseMotionListener {

	private CanvasPanel canvasPane;
	private ButtonPanel buttonPane;

	public MousePositionListener(CanvasPanel cp, ButtonPanel bp) {
		canvasPane = cp;
		buttonPane = bp;
	}

	public void mouseMoved(MouseEvent e) {
		
		canvasPane.displayCoords(e.getX(), e.getY());
	
	}

	public void mouseDragged(MouseEvent e) {
		
		ClassDiag thisOne = canvasPane.findNearestClass(e.getX(),e.getY());
		
		if (thisOne !=null) {
			thisOne.update(e.getX(), e.getY());
	    canvasPane.repaint();
		}
		
		//System.out.println("hey");
		
	}
}
