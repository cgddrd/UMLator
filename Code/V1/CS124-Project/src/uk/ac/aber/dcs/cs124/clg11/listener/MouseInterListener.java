package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.event.*;
import javax.swing.*;

import uk.ac.aber.dcs.cs124.clg11.panel.*;

public class MouseInterListener implements MouseListener{
	
	private CanvasPanel canvasPane;

	private ButtonPanel buttonPane;

	public MouseInterListener(CanvasPanel cp, ButtonPanel bp) {
		canvasPane = cp;
		buttonPane = bp;
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			canvasPane.addClass(e.getX(),e.getY());
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
}
