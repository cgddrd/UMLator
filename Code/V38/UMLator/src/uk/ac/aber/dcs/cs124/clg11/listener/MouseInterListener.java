package uk.ac.aber.dcs.cs124.clg11.listener;

import java.awt.event.*;
import javax.swing.*;

import uk.ac.aber.dcs.cs124.clg11.frame.*;
import uk.ac.aber.dcs.cs124.clg11.panel.*;


public class MouseInterListener implements MouseListener{

	private CanvasPanel canvasPane;

	private ButtonPanel buttonPane;

	private NewRelDialog relDialog;

	private int[] clickArray = new int[4];

	int count;
	int arrayCount = 0;

	public MouseInterListener(CanvasPanel cp, ButtonPanel bp) {
		canvasPane = cp;
		buttonPane = bp;
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) throws NullPointerException {
		if (buttonPane.addVar == true) {	
			if(SwingUtilities.isLeftMouseButton(e)) {
				//new NewClassDialog(canvasPane, e.getX(), e.getY());
				new AddClassDialog(canvasPane, e.getX(), e.getY());
				buttonPane.addVar = false;
				canvasPane.setStatus("Class location confirmed");
			} 
		} else if (buttonPane.addRel == true) {

			if (count < 2) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					System.out.println(e.getX() +  " / " + e.getY());
					clickArray[arrayCount] = e.getX();
					arrayCount++;
					clickArray[arrayCount] = e.getY();
					arrayCount++;
					count++;
				}
			}
			if (count == 2){
				relDialog = new NewRelDialog(canvasPane, clickArray[0], clickArray[1], clickArray[2], clickArray[3]);
				buttonPane.addRel = false;
				count = 0;
				arrayCount = 0;
			}
		} else if (buttonPane.delItem == true) {
			if(SwingUtilities.isLeftMouseButton(e)) {
				canvasPane.removeClass(e.getX(), e.getY());
				buttonPane.delItem = false;
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}
